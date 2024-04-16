import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.xml.transform.Source;

class Graph1 {
    int[][] adjMatrix;
    int vCount;
    boolean[] visited;

    Graph1(int vCount) {
        this.vCount = vCount;
        adjMatrix = new int[vCount][vCount];
        visited = new boolean[vCount];
    }

    void readEdges(Scanner scanner) {
        System.out.println("Enter edges (source destination): ");
        for (int i = 0; i < vCount; i++) {
            for (int j = 0; j < vCount; j++) {
                System.out.print("Enter edge " + (i + 1) + " to " + (j + 1) + ": ");
                adjMatrix[i][j] = scanner.nextInt();
            }
        }
    }

    void displayAdjacency() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vCount; i++) {
            for (int j = 0; j < vCount; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (int i = 0; i < vCount; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    void DFS(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        System.out.print("DFS: ");
        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + " ");
            for (int i = 0; i < vCount; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
}

class Graph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Enter the data of the graph");
        System.out.print("Enter vertex count: ");
        int vCount = scanner.nextInt();
        Graph1 graph = new Graph1(vCount);
        int startVertex;
        graph.readEdges(scanner);
        graph.displayAdjacency();
        while (!exit)
        {
        System.out.println("Menu:");
        System.out.println("Perform the traversal on graph");
        System.out.println("ENTER YOUR CHOICE \n1.Breadth first trversal\n2.Depth first trversal");
        int ch=scanner.nextInt();
        
        switch (ch) {
            case 1:
            System.out.print("Enter starting vertex: ");
            startVertex = scanner.nextInt();
            graph.BFS(startVertex - 1); // Adjust for 0-based indexing
            break;

            case 2:
            System.out.print("Enter starting vertex: ");
            startVertex = scanner.nextInt();
            graph.DFS(startVertex - 1); // Adjust for 0-based indexing
            break;

            case 3:
                exit=true;
                break;
            
            default:
            System.out.println("invalid choice");
        }
    
    }
    
    }
}