import java.util.*;
class Node{
	int first;
	int prev;

	Node(int first,int prev){

		this.first = first;
		this.prev = prev;
	}
}
class Main {

	public static boolean isCycle(int node,ArrayList<ArrayList<Integer>> adjList,boolean[] visited){
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(node,-1));
		visited[node]=true;

		while(!queue.isEmpty()){

			int nodeVal = queue.peek().first;
			int prevVal = queue.peek().prev;
			queue.remove();

			for(Integer adjVal:adjList.get(nodeVal)){

				/*if(visited[adjVal] == false){

				
				}
				else if(adjVal != prevVal){
					return true;
				}*/

				if(visited[adjVal] == true && adjVal != prevVal){
					return true;
				}
				else if(visited[adjVal] == false){

						visited[adjVal] = true;
				queue.add(new Node(adjVal,nodeVal));
				}

				
				
			}
		}

		return false;

	}

	public static boolean cycleDetectFunc(int vertices, ArrayList<ArrayList<Integer>> adjList){

		boolean[] visited = new boolean[vertices+1];

		for(int i =1;i<=vertices;i++){

			if(visited[i] == false){
				if(isCycle(i,adjList,visited)){
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