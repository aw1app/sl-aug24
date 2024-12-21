import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Demo1 {

	private static MongoClient mongoClient;
	private static MongoDatabase database;
	private static MongoCollection<Document> usersCollection;

	public static void main(String[] args) {
		// Disable MongoDB driver logging
		Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);

		// Connect to MongoDB
		connectToMongoDB();

		createUser();

		//readUsers();

	}

	private static void connectToMongoDB() {
		// Connect to local MongoDB
		mongoClient = MongoClients.create("mongodb://localhost:27017");

		// Get database and collection
		database = mongoClient.getDatabase("mydatabase");
		usersCollection = database.getCollection("users-sl");

		System.out.println("Successfully connected to MongoDB.");
	}

	private static void createUser() {
		// Create a single user
		Document user = new Document("name", "John Doe").append("age", 30).append("email", "john@example.com")
				.append("address", new Document("city", "New York").append("country", "USA"))
				.append("hobbies", Arrays.asList("reading", "swimming"));

		usersCollection.insertOne(user);
		System.out.println("User created successfully.");

		// Create multiple users
		Document user2 = new Document("name", "Jane Smith").append("age", 25).append("email", "jane@example.com");

		Document user3 = new Document("name", "Bob Johnson").append("age", 35).append("email", "bob@example.com");

		usersCollection.insertMany(Arrays.asList(user2, user3));
		System.out.println("Multiple users created successfully.");
	}

	private static void readUsers() {
		// Find all users
		System.out.println("\nAll users:");
		usersCollection.find().forEach(doc -> System.out.println(doc.toJson()));

		// Find users with specific criteria
		System.out.println("\nUsers aged 30 or older:");
		Bson filter = Filters.gte("age", 30);
		usersCollection.find(filter).forEach(doc -> System.out.println(doc.toJson()));

		// Find one specific user
		System.out.println("\nFinding specific user:");
		Document user = usersCollection.find(Filters.eq("name", "John Doe")).first();
		if (user != null) {
			System.out.println(user.toJson());
		}
	}

	private static void updateUser() {
		// Update one user
		Bson filter = Filters.eq("name", "John Doe");
		Bson update = Updates.combine(Updates.set("age", 31), Updates.set("email", "john.doe@example.com"));

		usersCollection.updateOne(filter, update);
		System.out.println("User updated successfully.");

		// Update multiple users
		Bson multiFilter = Filters.lt("age", 30);
		Bson multiUpdate = Updates.inc("age", 1);

		usersCollection.updateMany(multiFilter, multiUpdate);
		System.out.println("Multiple users updated successfully.");
	}

	private static void deleteUser() {
		// Delete one user
		Bson filter = Filters.eq("name", "Bob Johnson");
		usersCollection.deleteOne(filter);
		System.out.println("User deleted successfully.");

		// Delete multiple users
		Bson multiFilter = Filters.lt("age", 25);
		usersCollection.deleteMany(multiFilter);
		System.out.println("Multiple users deleted successfully.");
	}
}
