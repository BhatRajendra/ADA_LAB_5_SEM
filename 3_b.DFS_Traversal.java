import java.util.*;

public class DFSTraversal {
     int vertices;
     int[][] adjacencyMatrix;
     int[] marks;
     int count;
     Stack<Integer> stack;
     int[] pushArr=new int[vertices+5];
     int pushOrder=0;
     int[] pop=new int[vertices+5];
     int popOrder=0;

    // Constructor
    public DFSTraversal(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
        this.marks = new int[vertices];
        this.count = 0;
        this.stack = new Stack<>();

        for (int i = 0; i < vertices; ++i) {
            marks[i] = 0; // Mark each vertex as unvisited
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; // Assuming an undirected graph
    }

    // Perform DFS traversal
    public void performDFS() {
        for (int v = 0; v < vertices; ++v) {
            if (marks[v] == 0) {
                dfs(v);
            }
        }
    }

    // DFS traversal from a given vertex
    private void dfs(int currentVertex) {
        count++;
        marks[currentVertex] = count;
        stack.push(currentVertex);
        pushArr[++pushOrder]=currentVertex;
        System.out.println("Pushed vertex " + currentVertex + " (Order: " + count + ")");

        for (int neighbor = 0; neighbor < vertices; neighbor++) {
            if (adjacencyMatrix[currentVertex][neighbor] == 1 && marks[neighbor] == 0) {
                dfs(neighbor);
            }
        }

        int poppedVertex = stack.pop();
        pop[++popOrder]=poppedVertex;
        System.out.println("Popped vertex " + poppedVertex + " (Order: " + count + ")");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        DFSTraversal graph = new DFSTraversal(numVertices);

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter edges (vertex1 vertex2):");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            graph.addEdge(vertex1, vertex2);
        }

        scanner.close();

        System.out.println("DFS Traversal (Push and Pop Order):");
        graph.performDFS();
        System.out.println(Arrays.toString(graph.pushArr));
    }
}
