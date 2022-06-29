import java.util.*;

class Main {

	public static boolean isDfsCycle(int node,int prev,boolean[] visited, ArrayList<ArrayList<Integer>> adjList){
			visited[node] = true;

			for(Integer adjVal:adjList.get(node)){

				if(visited[adjVal] == false){
					if(isDfsCycle(adjVal,node,visited,adjList)==true)
						return true;
				}
				else if(adjVal != prev){
					return true;
				}
			}
		return false;
	}

	public static boolean cycleDetectFunc(int vertices, ArrayList<ArrayList<Integer>> adjList){

		boolean[] visited = new boolean[vertices+1];

		for(int i =1; i<=vertices;i++){

			if(visited[i] == false){

				if(isDfsCycle(i,-1,visited,adjList)){

					return true;
				}
			}
		}

		return false;
	}
	public static void main(String args[]) {
		// Your code goes here

		//Making Adjacency list

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of vertices");
		int vertices = sc.nextInt();
		System.out.println("Enter no. of edges");
		int edges = sc.nextInt();

		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

		//= so that every list is at number of the vertice
		for(int i =0 ;i<=vertices; i++){
			adjList.add(new ArrayList<Integer>());
		}

		System.out.println("enter values of edges in terms of u and v");

		for(int j=0; j<edges;j++){

			int u = sc.nextInt();
			int v = sc.nextInt();

			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		for(ArrayList<Integer> arr:adjList){
			System.out.println(arr);
		}
		System.out.println("Cycle Status:");
		System.out.println(cycleDetectFunc(vertices,adjList));
	}
}