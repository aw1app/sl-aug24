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