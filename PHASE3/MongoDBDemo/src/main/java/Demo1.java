import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Demo1 {

	public static void main(String[] args) {
		// Connect to MongoDB
		
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("mydatabase");
		
		database.createCollection("users");
		
		MongoCollection<Document> usersCollection = database.getCollection("users");
		
		
		
		// Let's insert a document
		
		Document user1 = new Document();

		user1.append("email", "mohan1@gmail.com").append("username", "mohan1").append("age", 34);

		usersCollection.insertOne(user1);
		
		System.out.println(" Demo End ");
	}

}
