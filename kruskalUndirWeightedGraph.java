import java.util.*;

class Node{
	int u,v,w;
	
	Node(int u, int v, int w){
		this.u = u;
		this.v = v;
		this.w = w;
	}
}

class SortComparator implements Comparator<Node>{
	
	@Override
	public int compare(Node n1 , Node n2){
		
		if(n1.w < n2.w){
			return -1;
		}
		if(n1.w > n2.w){
			return 1;
		}
		return 0;
	}
}
class Main {
	
	public static int findPar(int node, int[] parent){
		
		if(node == parent[node]){
			return node;
		}
		
		return parent[node] = findPar(parent[node],parent);
	}
	
	public static void unionDisjointSet(int u, int v, int[] parent, int[] rank){
		u = findPar(u,parent);
		v = findPar(v,parent);
		
		if(rank[u] < rank[v]){
			parent[u] = v;
		}
		else if(rank[u] > rank[v]){
			parent[v] = u;
		}
		else{
			parent[u] = v;
			rank[v]++;
		}
	}
	
	public static void kruskalAlgo(int n , ArrayList<Node> adj){
		
		//Sorting the linear data structure according to the weight
		Collections.sort(adj, new SortComparator());
		
		//for(Node a:adj){
			//System.out.println(a.u+" "+a.v+" "+a.w);
	//	}
		
		//For Disjoint Syste
		int[] parent = new int[n];
		int[] rank = new int[n];
		
		//Make Set
		for(int i =0; i<n;i++){
			parent[i] = i;
			rank[i] = 0;
		}
		
		int costMST = 0;
		ArrayList<Node> arr = new ArrayList<>();
		
		for(Node a:adj){
			if(findPar(a.u,parent) != findPar(a.v,parent)){
				costMST += a.w;
				arr.add(a);
				unionDisjointSet(a.u,a.v,parent,rank);
			}
		}
		
		System.out.println(costMST);
		for(Node k:arr){
			System.out.println(k.u+" "+k.v+" "+k.w);
		}
	}
	
	public static void main(String args[]) {
		// Your code goes here
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no. of vertices");
		int n = sc.nextInt();
		
		System.out.println("Enter no. of edges");
		int e = sc.nextInt();
		
		ArrayList<Node> linearAdj = new ArrayList<>();
		
		for(int i =0; i<e; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			linearAdj.add(new Node(u,v,w));
		}	
		kruskalAlgo(n,linearAdj);		
	}
}