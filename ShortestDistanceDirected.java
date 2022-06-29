import java.util.*;

class Pairs{
	int value, weight;
	
	Pairs(int node, int weight){
		value = node;
		this.weight = weight;
	}
}
class Main {
	public static void dfsTopoSort(int node, ArrayList<ArrayList<Pairs>> adj, int[] visited, Stack<Integer> topo){
		
		visited[node] = 1;
		
		for(Pairs k : adj.get(node)){
			
			if(visited[k.value] == 0){
				dfsTopoSort(k.value,adj,visited,topo);
			}
		}
		topo.push(node);
	}
	public static int[] shortestPathDirected(int n, ArrayList<ArrayList<Pairs>> adj){
		
		int[] visited = new int[n];
		int[] dis = new int[n];
		Stack<Integer> topo = new Stack<>();
		
		for(int i =0; i<n;i++){
			dis[i] = Integer.MAX_VALUE;
		}
		for(int i =0; i<n;i++){
			if(visited[i] == 0){
				dfsTopoSort(i,adj,visited,topo);
			}
		}
		//System.out.println(topo);
		int currNode = topo.pop();
		dis[currNode] = 0;
		while(!topo.isEmpty()){
			
			if(dis[currNode] != Integer.MAX_VALUE){
				
				for(Pairs k: adj.get(currNode)){
					int d = dis[currNode] + k.weight;
					
					if(d < dis[k.value]){
						dis[k.value] = d;
					}
				}
			}
			
			currNode = topo.pop();
		}
		
		return dis;
	}
	
	public static void main(String args[]) {
		// Your code goes here
		
		ArrayList<ArrayList<Pairs>> adj = new ArrayList<ArrayList<Pairs>>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input no. of vertices ");
		int n = sc.nextInt();
		System.out.println("Input no. of edges ");

		int e = sc.nextInt();
		
		for(int i=0; i<=n; i++){
			adj.add(new ArrayList<Pairs>());
		}
		
		for(int j=0;j<e;j++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			adj.get(u).add(new Pairs(v,w));
		}
		System.out.println("Directed Graph Shortest Distances");
		
	/*	for(ArrayList<Pairs> k:adj){
			for(Pairs a:k)
				System.out.println(a.value+" "+a.weight);
		}*/
		int [] result = shortestPathDirected(n,adj);
		
		for(int k =0; k<result.length; k++){
			System.out.print(result[k]+" ");
		}
				
	}
}