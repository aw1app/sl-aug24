
class Stack {

    constructor() {
        this.items = [];
    }

    //Ops
    // Push operation 
    push(element) {
        this.items.push(element);
    }

    // Pop operation 
    pop() {
        if (this.items.length === 0) {
            return "Underflow";
        }
        return this.items.pop();
    }

     // Peek operation 
     peek() { 
        return this.items[this.items.length - 1]; 
    } 

     // Display the Stack 
     display() { 
        console.log("Stack elements:", this.items); 
    } 

     // Clear the Stack 
     clear() { 
        this.items = []; 
        console.log("Stack cleared."); 
    } 

}



// Test out
let myStack = new Stack();
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