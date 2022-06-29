import java.util.*;
/*
 * Input Format in interview bit compiler
 * 
 * 5
6
0
1
2
0
3
6
1
2
3
3
1
8
1
4
5
4
2
7
 */

class Pairs{
	int value, weight;
	
	Pairs(int node, int weight){
		value = node;
		this.weight = weight;
	}
}

class Main {
	
	
	public static void primsAlgo(int n,ArrayList<ArrayList<Pairs>> adj){
	
		int[] dist = new int[n];
		int[] parent = new int[n];
		boolean[] mst = new boolean[n];
		
		for(int i=0; i<n; i++){
			dist[i] = Integer.MAX_VALUE;
			parent[i] = -1;
			mst[i] = false;
		}	
		
		dist[0] = 0;
		
		for(int j=0 ; j<n-1; j++){
			int min = Integer.MAX_VALUE;
			int u =0;
			
			for(int k=0;k<n;k++){
				if(mst[k] == false && dist[k] < min){
					min = dist[k];
					u = k;
				}
			}
			mst[u] = true;
			
			for(Pairs p: adj.get(u)){
				
				if(p.weight<dist[p.value] && mst[p.value] == false){
					dist[p.value] = p.weight;
					mst[p.value] = true;
					parent[p.value] = u;
				}
			}
		}
		
		for(int i=0;i<parent.length;i++){
			System.out.println(parent[i]+"--"+i);
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
		
	/*	for(ArrayList<Pairs> k:adj){
			for(Pairs a:k)
				System.out.println(a.value+" "+a.weight);
		}*/
		primsAlgo(n,adj);
				
	}
}