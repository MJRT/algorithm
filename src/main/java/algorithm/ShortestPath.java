package algorithm;

import java.util.*;

/**
 * Created by mjrt on 4/2/2017.
 */
public class ShortestPath {

    class Edge{
        public int x,y,v;
        public Edge(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    class Node{
        public int x,v;
        public Node(int x, int v) {
            this.x = x;
            this.v = v;
        }
    }
    private int verticeNumber;
    private ArrayList<Edge> edges;
    private List<List<Integer>> graph;
    private int[] distance;
    private int[] count;
    private boolean[] visited;
    private final int INFTY = 0x3f3f3f3f;// Should be a suitable value

    public ShortestPath(int maxVerticeNumber) {
        maxVerticeNumber++;
        edges = new ArrayList<Edge>();
        graph = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < maxVerticeNumber ;i++)
            graph.add(new ArrayList<Integer>());
        distance = new int[maxVerticeNumber];
        count = new int[maxVerticeNumber];
        visited = new boolean[maxVerticeNumber];
    }

    public void initialize(int verticeNumber){
        this.verticeNumber = verticeNumber++;
        for(int i = 0 ; i < verticeNumber ; i++)
            graph.get(i).clear();
        edges.clear();
    }

    public void addUndirectedEdge(int x,int y,int v){
        addDirectedEdge(x,y,v);
        addDirectedEdge(y,x,v);
    }

    public void addDirectedEdge(int x,int y,int v){
        edges.add(new Edge(x,y,v));
        graph.get(x).add(edges.size()-1);
    }

    /*
       edgeNumber >= verticeNumber²
     */
    public int[] dijkstra(int start){
        Queue<Node> queue = new PriorityQueue<Node>(verticeNumber*verticeNumber,new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.v - o2.v ;
            }
        });
        Arrays.fill(visited,false);
        Arrays.fill(distance,INFTY);
        distance[start] = 0;
        queue.add(new Node(start,0));
        while(!queue.isEmpty()){
            int now = queue.poll().x;
            if(!visited[now]){
                visited[now] = true;
                for(int i = 0 ; i < graph.get(now).size() ; i++){
                    int pos = graph.get(now).get(i);
                    int y = edges.get(pos).y;
                    int v = edges.get(pos).v;
                    if(distance[now]<INFTY && distance[y]>distance[now]+v){
                        distance[y] = distance[now] + v;
                        queue.add(new Node(y,distance[y]));
                    }
                }
            }
        }
        return distance;
    }
    /*
        edgeNumber << verticeNumber²
     */
    public int[] bellmanFord(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Arrays.fill(visited, false);
        Arrays.fill(distance, INFTY);
        Arrays.fill(count, 0);

        distance[start] = 0;
        visited[start] = true;  //  this mean is "in queue"
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = false;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int pos = graph.get(now).get(i);
                int y = edges.get(pos).y;
                int v = edges.get(pos).v;
                if (distance[now] < INFTY && distance[y] > distance[now] + v) {
                    distance[y] = distance[now] + v;
                    if (!visited[y]) {
                        queue.add(y);
                        visited[y] = true;
                        if (++count[y] > verticeNumber) return null;
                    }
                }
            }
        }
        return distance;
    }

    /*
        all
     */
    public int[][] floydWarshall(){
        int dis[][] = new int[verticeNumber+1][verticeNumber+1];
        for(int i = 0 ; i < dis.length ; i++)
            Arrays.fill(dis[i],INFTY);
        for(int i = 0 ; i < dis.length ; i++)
            dis[i][i] = 0;
        for(int i = 0 ; i < dis.length ; i++)
            for(int j = 0 ; j < graph.get(i).size() ; j++) {
                Edge edge = edges.get(graph.get(i).get(j));
                dis[edge.x][edge.y] = edge.v;
            }

        for(int k = 0 ; k < dis.length ; k++)
            for(int i = 0 ; i < dis.length ; i++)
                for(int j = 0 ; j < dis.length ; j++)
                    dis[i][j] = Math.min(dis[i][j],dis[i][k]+dis[k][j]);
        return dis;
    }
}