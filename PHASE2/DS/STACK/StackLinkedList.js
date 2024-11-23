class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class StackLinkedList {
    constructor() {
        this.top = null;
        this.size = 0;
    }


    // Push operation 
    push(data) {
        let newNode = new Node(data);

        newNode.next = this.top;
        this.top = newNode;

        this.size++;
    }

    // Pop operation 
    pop() {
        if (this.size === 0) {
            return "Underflow";
        }

        const poppedNode = this.top;
        this.top = this.top.next;

        this.size--;
        return poppedNode;
    }

    //peek
    peek() {
        return this.top ? this.top.data : null;
    }

    // Display the Stack 
    display() {
        let current = this.top;
        while (current) {
            console.log(current.data);
            current = current.next;
        }
    }

    // Clear the Stack 
    clear() {
        this.top = null;
        this.size = 0;
        console.log("Stack cleared.");
    }

}

// Test out
// Creating a stack 
let myStack = new StackLinkedList();

// Pushing elements onto the stack 
myStack.push(10);
myStack.push(20);
myStack.push(30);

// Displaying the stack 
myStack.display();

// Popping an element from the stack 
let poppedElement = myStack.pop();
console.log("Popped element:", poppedElement);

// Displaying the stack after popping 
myStack.display();

// Peeking into the stack 
let topElement = myStack.peek();
console.log("Top element:", topElement);

// Clearing the stack 
myStack.clear();
myStack.display(); 