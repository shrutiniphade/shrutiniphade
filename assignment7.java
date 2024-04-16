import java.util.*;

class Edge implements Comparable<Edge>
{
    int source,destination,weight;
    public Edge(int source,int destination,int weight)
    {
        this.source=source;
        this.destination=destination;
        this.weight=weight;
    }

    public int compareTo(Edge oEdge)
    {
        return this.weight-oEdge.weight;
    }
}

public class assignment7 
{
     int vertices;
     ArrayList<ArrayList<Edge>>graph;

     public assignment7(int vertices)
     {
        this.vertices=vertices;
        graph=new ArrayList<>(vertices);
        for(int i=0; i<vertices;i++)
        {
            graph.add(new ArrayList<>());
        }
     }

     void addEdge(int source,int destination,int weight)
     {
        Edge e=new Edge(source, destination, weight);
        graph.get(source).add(e);
        e=new Edge(source, destination, weight);
        graph.get(destination).add(e);  
    }

    void prims()
    {
        boolean[] visited= new boolean[vertices];
        Edge[] parent= new Edge[vertices];
        int[] key= new int[vertices];
        Arrays.fill(key,Integer.MAX_VALUE);

        PriorityQueue<Edge>p=new PriorityQueue<>(vertices,(a,b)->a.weight-b.weight);
        key[0] = 0;
        p.add(new Edge(-1, 0, 0));

        while (!p.isEmpty()) {
            int u = p.poll().destination;
            visited[u] = true;
            for (Edge edge : graph.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;
                if (!visited[v] && weight < key[v]) {
                    parent[v] = edge;
                    key[v] = weight;
                    p.add(new Edge(u, v, weight));
                }
            }
        }

        // Print the input graph
        System.out.println("Input Graph:");
        for (int u = 0; u < vertices; u++) {
            for (Edge edge : graph.get(u)) {
                if (edge.destination > u) {
                    System.out.println((char)('A' + edge.source) + " " + (char)('A' + edge.destination) + " " + edge.weight);
                }
            }
        }

        // Print the MST
        System.out.println("\nResulting Minimum Spanning Tree (MST):");
        for (int i = 1; i < vertices; i++) {
            System.out.println((char)(parent[i].source + 'A') + " " + (char)(parent[i].destination + 'A') + " " + parent[i].weight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Graph:");
        System.out.print("ENTER NO OF EDGES: ");
        int edges = scanner.nextInt();
        System.out.print("ENTER NO OF VERTICES: ");
        int vertices = scanner.nextInt();
        assignment7 graph = new assignment7(vertices);

        for (int i = 0; i < edges; i++) {
            System.out.print("ENTER 1ST VERTEX: ");
            char source = scanner.next().charAt(0);
            System.out.print("ENTER 2ND VERTEX: ");
            char destination = scanner.next().charAt(0);
            System.out.print("ENTER WEIGHT: ");
            int weight = scanner.nextInt();
            graph.addEdge(source - 'A', destination - 'A', weight);
        }

        graph.prims();
    }
    }

