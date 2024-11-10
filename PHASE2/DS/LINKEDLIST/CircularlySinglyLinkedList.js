class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class CircularlySinglyLinkedList {

    constructor() {
        this.head = null;
    }

    // Create: Add a new node to the end of the list 
    add(data) {
        let newNode = new ListNode(data);

        // if the list was empty
        if (this.head == null) {
            this.head = newNode;
            newNode.next = this.head;
            return;
        }

        //if our list had some elements
        let currentNode = this.head;

        while (currentNode.next !== this.head) {
            currentNode = currentNode.next;
        }

        // Now we are at the Tail node
        currentNode.next = newNode;
        newNode.next = this.head;
    }


    // Delete: Remove a node from the list at a specified position 
    delete(position) {

        // If list is empty
        if (!this.head) {
            return;
        }

        // Deleting the head
        if (position === 0) {

            // If the list had only the head node
            if (this.head.next === this.head) {
                this.head = null;
            } else { // Head and there more nodes following the head.

                let current = this.head;
                while (current.next !== this.head) {
                    current = current.next;
                }
                // we are at the tail now
                this.head = this.head.next;
                current.next = this.head;
            }

            return;
        }

        // Deleting non head node
        let current = this.head;
        let previous = null;

        count = 0;

        do {

            if (count === position) {
                previous.next = current.next;
                return;
            }

            previous = current;
            current = current.next;
            count++;
        } while (current !== this.head)

        console.log("Position not found");
    }


    // Update: Modify the value of a node at a given position 
    update(position, data) {
        let current = this.head; 
        let count = 0;  

        do  { 
            if (count === position) { 
                current.data = data; 
                return; 
            } 
            current = current.next; 
            count++; 
        } while( current!== this.head )

        //if we are here then the position was not in the range of list. 
        console.log("Position not found. No update done!");
    }


    // Read: Traverse and display elements of the list 
    display() {

        if (this.head === null)
            return;

        let currentNode = this.head;
        do {
            console.log(currentNode.data);
            currentNode = currentNode.next;
        } while (currentNode !== this.head)
    }

}

// Test out
const list = new CircularlySinglyLinkedList();
list.add(1);
list.add(2);
list.add(3);
list.display();  // Displays 1, 2, 3 

console.log("Doing update(1, 4)")
list.update(1, 4);  // Updates the second element to 4 
list.display();  // Displays 1, 4, 3 

console.log("Doing delete(0)")
list.delete(0);  // Deletes the first element
list.display();  // Displays  2, 3 


