
class Queue {
    constructor() {
        this.items = [];
    }

    // (add) an item to the queue 
    enqueue(item) {
        this.items.push(item);
    }

    // Function to dequeue (remove) an item from the queue 
    dequeue() {
        if (this.isEmpty()) {
            return "Queue is empty";
        }
        return this.items.shift();
    }

    // Function to get the front item of the queue without removing it 
    front() {
        if (this.isEmpty()) {
            return "Queue is empty";
        }
        return this.items[0];
    }

    // Function to check if the queue is empty 
    isEmpty() {
        return this.items.length === 0;
    }

    // Function to get the size of the queue 
    size() {
        return this.items.length;
    }
}


const queue = new Queue();

// Enqueue items 
queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);

// Display queue size and front item 
console.log('Queue Size:', queue.size());
console.log('Front of the Queue:', queue.front());

// Dequeue an item 
console.log('Dequeued Item:', queue.dequeue());

// Display updated queue size and front item 
console.log('Updated Queue Size:', queue.size());
console.log('Front of the Updated Queue:', queue.front()); 