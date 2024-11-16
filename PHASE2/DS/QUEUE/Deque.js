class DeQue {
    constructor() {
        this.items = [];
    }


    // Methods for Stack implementation 
    push(item) {
        this.items.push(item);
    }

    pop() {
        if (this.isEmpty()) {
            return undefined;
        }
        return this.items.pop();
    }


    // Methods for Queue implementation 
    enqueue(item) {
        this.items.push(item);
    }

    dequeue() {
        if (this.isEmpty()) {
            return undefined;
        }
        return this.items.shift();
    }

    isEmpty() { 
        return this.items.length === 0; 
    } 
 
    size() { 
        return this.items.length; 
    } 


}

// Example usage 
const stack = new DeQue(); 
stack.push(1); 
stack.push(2); 
console.log('Stack pop:', stack.pop()); 
 
const queue = new DeQue(); 
queue.enqueue(1); 
queue.enqueue(2); 
console.log('Queue dequeue:', queue.dequeue()); 