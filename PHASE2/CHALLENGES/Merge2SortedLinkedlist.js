//import {SinglyLinkedList} from '../DS/LINKEDLIST/LinkedList'

class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

function mergeSortedLists(l1, l2) {

    let resultHead = new SinglyLinkedList(); // first temp of the resultant linked list

    let current = resultHead;

    while (l1 !== null && l2 !== null) {

        if (l1.data < l2.data) {
            current.next = l1;
            l1 = l1.next;

        } else {
            current.next = l2;
            l2 = l2.next;
        }
        current = current.next;
    }

     // At least one of l1 and l2 can still have nodes at this point, so connect 
    // the non-null list to the end of the merged list.
    current.next = l1 === null ? l2 : l1;

    return resultHead.next;
}

// The LL definition
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

// test drive
const list1 = new SinglyLinkedList(); 
list1.add(1); 
list1.add(4); 
list1.add(13); 
console.log("Displayingh List 1");
list1.display();


const list2 = new SinglyLinkedList(); 
list2.add(2); 
list2.add(7); 
list2.add(33); 
console.log("Displayingh List 2");
list2.display();

let mergedNode = mergeSortedLists(list1.head,list2.head);
console.log("Displayingh mergedList ");
const mergedlist = new SinglyLinkedList();
mergedlist.head = mergedNode;
mergedlist.display();