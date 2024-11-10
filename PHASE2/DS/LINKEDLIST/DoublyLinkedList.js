class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {

    constructor() {
        this.head = null;
        this.tail = null;
    }

    add(data) {
        let newNode = new ListNode(data);

        // if the list was empty
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        //if our list had some nodes
        let currentNode = this.head;

        while (currentNode.next !== null) {
            currentNode = currentNode.next;
        }

        // Now we are at the Tail node
        currentNode.next = newNode;
        newNode.prev = currentNode;
        this.tail = newNode;
    }


    // Update: Modify the value of a node at a given position 
    update(position, data) {

        let current = this.head; 
        let count = 0; 

        while(current){

            if (count === position) { 
                current.data = data; 
                return; 
            } 

            current = current.next; 
            count++;
        }

        console.log("Position not found. No update done"); 
    }


    // Delete: Remove a node from the list at a specified position 
    delete(position) {
        if (position === 0) {
            this.head = this.head.next;
            if (this.head) {
                this.head.prev = null;
            } else {
                this.tail = null;
            }
            return;
        }

        // 
        let current = this.head;
        let count = 0;

        while (current) {

            if (count === position) {
                if (current.next) {
                    current.next.prev = current.prev;
                } else {
                    // position was at the tail
                    this.tail = current.prev;
                }

                if (current.prev) {
                    current.prev.next = current.next;
                } else {
                    // position was at the head
                    this.head = current.next;
                }
                return;
            }

            current = current.next;
            count++;
        }

        //if we are here then the position was not in the range of list. 
        console.log("Position not found. No update done!");
    }

    // Read: Traverse and display elements of the list 
    display() {
        let currentNode = this.head;
        while (currentNode) {
            console.log(currentNode.data);
            currentNode = currentNode.next;
        }
    }
}


//Test out
const list = new DoublyLinkedList();
list.add(1); 
list.add(2); 
list.add(3); 
 list.display();  // Displays 1, 2, 3 
 console.log(" Doing update(1, 4)")
list.update(1, 4);  // Updates the second element to 4 
list.display();

console.log(" Doing delete(0)");
list.delete(0);  // Deletes the first element 
list.display();  // Displays 2,3  