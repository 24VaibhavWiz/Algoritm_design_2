package programming_projects;
import java.util.ArrayList;
import java.util.List;
public class AllPossiblePaths {
	
	private int v;
	//private int count; 
	private ArrayList<Integer>[] adjList;
	
	public AllPossiblePaths(int ver)
	{
		//this.count = ver;
		this.v = ver;
		initAdList();
	}
	
	@SuppressWarnings({ "unchecked" })
	private void initAdList()
	{
		adjList = new ArrayList[v];
		for (int i = 0; i < v; i++) 
			 adjList[i] = new ArrayList<>();
	}
	
	public void addEdges(int u, int v)
	{
		adjList[u].add(v);
	}
	
	public void printAllPaths(int s, int t)
	{
		boolean[] Visited = new boolean[v];
		ArrayList<Integer> path = new ArrayList<>();
		path.add(s);
		printUtils(s,t,Visited,path);
	}

	private void printUtils( Integer u, Integer t, boolean[] Visited, List<Integer> localpath)
	{
		Visited[u] = true;
		if(u.equals(t))
			System.out.println(localpath);
		for (Integer i : adjList[u]) {
			if(!Visited[i])
			{
				//count--;
				localpath.add(i);
				printUtils(i, t, Visited, localpath);
				localpath.remove(i);
			}
		}
		Visited[u] = false;	
	}
	
	public static void main(String args[])
	{
		AllPossiblePaths path = new AllPossiblePaths(9);
		path.addEdges(0, 1);
		path.addEdges(0, 2);
		path.addEdges(0, 3);
		path.addEdges(2, 1);
		path.addEdges(2, 0);
		path.addEdges(1, 3);
		path.addEdges(3, 0);
		path.addEdges(3, 6);
		path.addEdges(4, 9);
		path.addEdges(5, 10);
		int s = 0 , t = 6;
		System.out.println("from "+s+" to "+ t+" : ");
		path.printAllPaths(s,t);
	}
}
