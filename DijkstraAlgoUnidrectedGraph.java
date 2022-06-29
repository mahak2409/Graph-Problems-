import java.util.*;

//Dijkstra Algo To find shortest distance from source to every other node
class Pairs{
	int value, weight;
	
	Pairs(int node, int weight){
		value = node;
		this.weight = weight;
	}
}

class PComparator implements Comparator<Pairs>{
	
	@Override
	public int compare(Pairs p1, Pairs p2){
		
		return p1.weight - p2.weight;
	}
}
class Main {
	
	
	public static void dijkstraAlgo(int n,int src, ArrayList<ArrayList<Pairs>> adj){
		
		PComparator obj = new PComparator();
		PriorityQueue<Pairs> pq = new PriorityQueue<>(obj);
		pq.add(new Pairs(src,0));
		int[] dist = new int[n];
		dist[src] = 0;
		
		for(int i =1; i<n;i++){
			dist[i] = Integer.MAX_VALUE;
		}
		
		while(!pq.isEmpty()){
			
			Pairs node = pq.poll();
			//System.out.println("Node "+node.value+" "+node.weight);
			
			for(Pairs p: adj.get(node.value)){
				int d = node.weight + p.weight;
			//	System.out.println("d value "+d);
				if(d < dist[p.value]){
					//System.out.println("In if");
					dist[p.value] = d;
					pq.add(new Pairs(p.value,d));
				}
			}
		}
		
		System.out.println("Dijkstra Algo Length");
		
		System.out.println();
		for(int k:dist){
			System.out.print(k+" ");
		}
	}
	
	public static void main(String args[]) {
		// Your code goes here
		
		ArrayList<ArrayList<Pairs>> adj = new ArrayList<ArrayList<Pairs>>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input no. of vertices ");
		int n = sc.nextInt();
		System.out.println("Input no. of edges ");

		int e = sc.nextInt();
		
		for(int i=0; i<n; i++){
			adj.add(new ArrayList<Pairs>());
		}
		
		for(int j=0;j<e;j++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			adj.get(u).add(new Pairs(v,w));
			adj.get(v).add(new Pairs(u,w));
		}
		System.out.println("Directed Graph Shortest Distances");
		
	/*	for(ArrayList<Pairs> k:adj){
			for(Pairs a:k)
				System.out.println(a.value+" "+a.weight);
		}*/
		dijkstraAlgo(n,0,adj);
				
	}
}