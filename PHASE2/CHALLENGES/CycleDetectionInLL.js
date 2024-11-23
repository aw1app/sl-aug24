class ListNode {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}


function hasCycle(head) {

    // Base check
    if (!head || !head.next) {
        return false;
    }

    // Given list has more than one node
    let slow = head; // Moves one step at a time 
    let fast = head.next; // Moves two steps at a time 

    while (slow !== fast) { 

        if (!fast || !fast.next) { 
            return false; // Reaches the end without cycle 
        } 

        slow = slow.next;
        fast = fast.next.next;
    }
    // if we are here then there was a cycle as slow and fast pointer have met
    return true;
}

// Test Drive;
let head = new ListNode(1); 
  head.next = new ListNode(2); 
  head.next.next = new ListNode(3); 
  head.next.next.next = new ListNode(4); 
  head.next.next.next.next = head.next; // Creating a cycle 

  console.log(hasCycle(head));
