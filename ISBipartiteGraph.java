import java.util.*;

class Main {

	public static boolean bfs(int node,int[] color, ArrayList<ArrayList<Integer>> adjList){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		color[node] = 0;

		while(!queue.isEmpty()){
			Integer nodeVal = queue.poll();
			for(Integer adjVal : adjList.get(nodeVal)){

				if(color[adjVal] == color[nodeVal]){
					return false;
				}
				else if(color[adjVal] == -1){
					queue.add(adjVal);
					color[adjVal] = 1 - color[nodeVal];
				}
			}
		}

		return true;
		
	}

	public static boolean bipartiteCheck(int vertices,ArrayList<ArrayList<Integer>> adjList){

		int[] color = new int[vertices+1];
		for(int i=0;i<=vertices;i++){
			color[i] = -1;
		}

		for(int i =0;i<=vertices;i++){

			if(color[i] == -1){

				if(!bfs(i,color,adjList)){
					return false;
				}
			}
		}

		return true;
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
		System.out.println("Graph Bipartite Status:");
		System.out.println(bipartiteCheck(vertices,adjList));
	}
}