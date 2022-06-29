import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS_Traversal {
	public static ArrayList<Integer> bfsTraversal(int v, ArrayList<ArrayList<Integer>> adj){

		ArrayList<Integer> bfs = new ArrayList<>();
		boolean[] visited = new boolean[v+1];

		//This for loop so that all the components og the graph will be visited
		for(int i =1; i<=v; i++){

			if(visited[i] == false){

				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				visited[i] = true;

				while(!queue.isEmpty()){
					Integer node = queue.poll();
					bfs.add(node);

					//adj.get(node) will return list where every element is integer and to traverse the list we have to take Integer adjVal not list adjVal
					for(Integer adjVal: adj.get(node)){

						if(visited[adjVal] == false){

							visited[adjVal] = true;
							queue.add(adjVal);
						}
					}
				}
			}
		}

		return bfs;
	}
	public static void main(String args[]) {
		// Your code goes here
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		System.out.println("Enter no. of vertices");
		int vertices = sc.nextInt();

		System.out.println("Enter no. of edges");
		int edges = sc.nextInt();
		

		for(int i =0 ; i<= vertices; i++){

			adj.add(new ArrayList<Integer>());
		}

		System.out.println("Enter Edges of Graph");

		int u,v;

		for(int j=1; j<=edges; j++){

			u = sc.nextInt();
			v = sc.nextInt();

			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		System.out.println("Adjacency List");
		for(ArrayList a:adj){

			System.out.println(a);
		}

		System.out.println("BFS Traversal");
		System.out.println(bfsTraversal(vertices,adj));
	}
}