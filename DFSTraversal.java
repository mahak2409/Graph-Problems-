import java.util.*;

class DFSTraversal{

	public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjList,ArrayList<Integer> dfsList){

		dfsList.add(node);
		visited[node] = true;

		for(Integer adjVal: adjList.get(node)){

			if(visited[adjVal] == false){

				dfs(adjVal,visited,adjList,dfsList);
			}
		}

	}

	public static ArrayList<Integer> dfsTraversal(int vertices, ArrayList<ArrayList<Integer>> adjList){

		boolean[] visited = new boolean[vertices+1];
		ArrayList<Integer> dfsList = new ArrayList<>();

		for(int i =1; i<=vertices;i++){
			if(visited[i] == false){

				dfs(i,visited,adjList,dfsList);

			}
		}

	 return dfsList;
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

		System.out.println("DFS Traversal");
		System.out.println(dfsTraversal(vertices,adjList));
	}
}