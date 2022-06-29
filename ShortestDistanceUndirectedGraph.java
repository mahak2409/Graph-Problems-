import java.util.*;
class Main {
	
	public static int[] shortDistFunc(int v, ArrayList<ArrayList<Integer>> adj,int src){
		
		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[v+1];
		
		for(int k=0; k<=v; k++){
			dist[k] = Integer.MAX_VALUE;
		}
		q.add(src);
		dist[src] = 0;
		
		while(!q.isEmpty()){
			int node = q.poll();
			for(Integer a : adj.get(node)){
				int d = dist[node]+1;
				if(d < dist[a]){
					dist[a] = d;
					q.add(a);
				}
			}
		}
		
		return dist;
		
	}
	public static void main(String args[]) {
		// Your code goes here
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input no. of vertices ");
		int n = sc.nextInt();
		System.out.println("Input no. of edges ");

		int e = sc.nextInt();
		
		for(int i =0; i<=n; i++){
			adj.add(new ArrayList<Integer>());
		}
		
		//Adjacency list for undirected graph
		for(int j =0; j<e; j++){
			
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		System.out.println("Shortest Distances");
		int [] result = shortDistFunc(n,adj,0);
		
		for(int i =0; i<result.length; i++){
			System.out.print(result[i]+" ");
		}
		
	}
}