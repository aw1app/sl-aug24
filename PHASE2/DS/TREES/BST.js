// Binary tree node definition 
class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    constructor() {
        this.root = null;
    }

    // Function to insert a node into the binary tree 
    insert(data) {
        const newNode = new Node(data);

        //If the tree was empty
        if (!this.root) {
            this.root = newNode;
        } else {
            this.insertNode(this.root, newNode);
        }
    }

    insertNode(node, newNode) {

        if (newNode.data < node.data) {
            if (!node.left) {
                node.left = newNode;
            } else {
                this.insertNode(node.left, newNode);
            }
        }

        else if (newNode.data > node.data) {
            if (!node.right) {
                node.right = newNode;
            } else {
                this.insertNode(node.right, newNode);
            }
        }

    }

    // Function to search for a node in the binary tree 
    search(data, node = this.root) {
        if (!node) {
            return false;
        }

        if (data === node.data) {
            return true;
        } else if (data < node.data) {
            return this.search(data, node.left);
        } else {
            return this.search(data, node.right);
        }
    }


    // Function to find the minimum value in the binary tree 
    findMin(node = this.root) {
        if (!node) {
            return null;
        }

        while (node.left) {
            node = node.left;
        }
        return node.data;
    }


    // Function to perform an in-order traversal of the binary tree 
    inOrderTraversal(node, result = []) {
        if (node) {
            this.inOrderTraversal(node.left, result);
            result.push(node.data);
            this.inOrderTraversal(node.right, result);
        }
        return result;
    }

}

// Test it out.
// Example usage 
const tree = new BinaryTree();
tree.insert(10);
tree.insert(5);
tree.insert(15);
tree.insert(3);
tree.insert(8);

console.log('In-order traversal:', tree.inOrderTraversal(tree.root));

console.log('Search 11 in tree:', tree.search(11));
console.log('Search 15 in tree:', tree.search(15));