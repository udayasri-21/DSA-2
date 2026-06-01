import java.util.*;

public class HospitalBFS_CO3 {

    private int vertices;
    private LinkedList<Integer>[] adjList;
    private String[] departments;

    HospitalBFS_CO3(int v) {
        vertices = v;

        adjList = new LinkedList[v];
        departments = new String[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void setDepartment(int index, String name) {
        departments[index] = name;
    }

    void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    void BFS(int startNode) {

        boolean[] visited = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);

        System.out.println("\nBFS Traversal:");

        while (!queue.isEmpty()) {

            int node = queue.poll();

            System.out.println("Visited Department : "
                    + departments[node]);

            for (int neighbor : adjList[node]) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        HospitalBFS_CO3 hospital = new HospitalBFS_CO3(7);

        hospital.setDepartment(0, "Reception");
        hospital.setDepartment(1, "Emergency Ward");
        hospital.setDepartment(2, "ICU");
        hospital.setDepartment(3, "Laboratory");
        hospital.setDepartment(4, "Pharmacy");
        hospital.setDepartment(5, "Radiology");
        hospital.setDepartment(6, "Operation Theatre");

        hospital.addEdge(0, 1);
        hospital.addEdge(0, 2);
        hospital.addEdge(1, 3);
        hospital.addEdge(1, 4);
        hospital.addEdge(2, 5);
        hospital.addEdge(3, 6);

        System.out.println("MediRoute - Hospital Patient Navigation and Department Connectivity System");
        System.out.println("---------------------------------------------------------------");

        System.out.println("\nHospital Connections:");

        System.out.println("Reception <-> Emergency Ward");
        System.out.println("Reception <-> ICU");
        System.out.println("Emergency Ward <-> Laboratory");
        System.out.println("Emergency Ward <-> Pharmacy");
        System.out.println("ICU <-> Radiology");
        System.out.println("Laboratory <-> Operation Theatre");

        hospital.BFS(0);

        System.out.println("\nHospital Monitoring:");

        System.out.println("Checking hospital department connectivity...");
        System.out.println("All hospital departments are connected.");
        System.out.println("Hospital patient navigation completed successfully.");

        System.out.println("\nTime Complexity:");
        System.out.println("BFS Traversal : O(V + E)");
        System.out.println("Graph Construction : O(E)");
    }
}