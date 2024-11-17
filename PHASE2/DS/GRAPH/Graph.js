// Graph implementation using adjacency list 
class Graph {
    constructor() {
        this.vertices = [];
        this.adjacencyList = new Map();
    }


    // Function to add a vertex to the graph 
    addVertex(vertex) {
        this.vertices.push(vertex);
        this.adjacencyList.set(vertex, []);
    }

    // Function to add an edge between two vertices 
    addEdge(vertex1, vertex2) {
        this.adjacencyList.get(vertex1).push(vertex2);
        this.adjacencyList.get(vertex2).push(vertex1);
    }

     // Function to display the graph 
     printGraph() { 
        for (const vertex of this.vertices) { 
            const neighbors = this.adjacencyList.get(vertex).join(', '); 
            console.log(`${vertex} -> ${neighbors}`); 
        } 
    } 

}

// Example usage 
const graph = new Graph(); 
graph.addVertex('A'); 
graph.addVertex('B'); 
graph.addVertex('C'); 
graph.addEdge('A', 'B'); 
graph.addEdge('B', 'C'); 
 
console.log('Graph representation:'); 
graph.printGraph(); 