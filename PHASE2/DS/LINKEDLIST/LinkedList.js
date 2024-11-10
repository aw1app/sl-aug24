class ListNode { 
    constructor(data) { 
        this.data = data; 
        this.next = null; 
    } 
}

class SinglyLinkedList{

    constructor() { 
        this.head = null; 
    } 

    // Create: Add a new node to the end of the list 
    add(data) { 
        let newNode = new ListNode(data);

        // if the list was empty
        if(this.head == null){
            this.head=newNode;
            return;
        }
        
        //if our list had some elements
        let currentNode = this.head;
        
        while (currentNode.next !==null ){
            currentNode = currentNode.next;
        }

        // Now we are at the Tail node
        currentNode.next = newNode;
    }

    // Update: Modify the value of a node at a given position 
    update(position, data) {
        let current = this.head; 
        let count = 0;  

        while (current) { 
            if (count === position) { 
                current.data = data; 
                return; 
            } 
            current = current.next; 
            count++; 
        } 

        //if we are here then the position was not in the range of list. 
        console.log("Position not found. No update done!"); 

    }

     // Delete: Remove a node from the list at a specified position 
     delete(position) { 
        if (position === 0) { 
            this.head = this.head.next; 
            return; 
        } 

        let current = this.head; 
        let previous = null; 

        count=0;

        while (current) { 

            if (count === position) { 
                previous.next = current.next; 
                return; 
            } 

            previous = current; 
            current = current.next; 
            count++; 
        }

        //if we are here then the position was not in the range of list. 
        console.log("Position not found"); 
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

const list = new SinglyLinkedList(); 
list.add(1); 
list.add(24); 
list.add(13); 
list.display();  // Displays 1, 24, 13 
console.log("Delete the head now..")
list.delete(0);  // Deletes the first element 

list.display();

console.log("Update the second node data")
list.update(1,1000);
list.display();