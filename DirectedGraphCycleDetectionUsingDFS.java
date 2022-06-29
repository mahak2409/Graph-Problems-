import java.util.*;

class Main {

	public static boolean dfsCheck(int node, int[] visited, int[] dfsvisited, ArrayList<ArrayList<Integer>> adjList){
		visited[node] = 1;
		dfsvisited[node] = 1;
		//System.out.println("Node "+node);
		for(Integer adjVal: adjList.get(node)){

			if(visited[adjVal] == 0){

				if(dfsCheck(adjVal,visited,dfsvisited,adjList) == true){
					return true;
				}
			}
			else if(dfsvisited[adjVal] == 1){
				return true;
			}
		}
		dfsvisited[node] = 0;
		return false;
	}

	public static boolean cycleDetectFunc(int vertices, ArrayList<ArrayList<Integer>> adjList){
		int[] visited = new int[vertices+1];
		int[] dfsvisited = new int[vertices+1];

		//i value will depend whether graph begins with vertice 1 or 0
		for(int i =1; i<=vertices; i++){
			if(visited[i] == 0){
				if(dfsCheck(i,visited,dfsvisited,adjList) == true){
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
		
		}

		for(ArrayList<Integer> arr:adjList){
			System.out.println(arr);
		}
		System.out.println("Directed Graph Cycle Status:");
		System.out.println(cycleDetectFunc(vertices,adjList));
	}
}