import java.util.*;
class LargestTree{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        //TO-DO:
//        boolean found = false;
//        int position = 0;
//        for(int i = 0; i<adj.length;i++){
//            position++;
//            if(adj[i].isEmpty()){
////                found = true;
////                break;
//                adj[i].add(u);
//                adj[i].add(v);
//            }
//
//        }
//
//        return;
        adj[u].add(v);
        adj[v].add(u);




    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited)
    {
//        visited.add(u, true);
//        int size = 1;
//        for(LinkedList<Integer> edge : adj){
//            int from = edge.get(0);
//            int to = edge.get(1);
////            if(visited.get(from) == false)
//            if(from == u){
//                if(visited.get(to)!=true){
//                    size += DFS(to, adj, visited);
//                }
//            }
//            if(to == u){
//                if(visited.get(from)!=true){
//                    size += DFS(to, adj, visited);
//                }
//            }
//        }
        visited.add(u, true);
        int sz = 1;

        // Iterating through all the nodes
        for (int i = 0; i < adj[u].size(); i++)
            if (visited.get(adj[u].get(i)) == false)

                // Perform DFS if the node is
                // not yet visited
                sz += DFS(adj[u].get(i),
                        adj, visited);
        return sz;

        // Iterate through all the nodes and perform DFS if the node is not yet visited
        //TO-DO:
//        return size;
    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        //TO-DO:
//        int largest = 0;
//        for(LinkedList<Integer> edge : adj){
//            int from = edge.get(0);
//            Vector<Boolean> visited = new Vector<>();
////            for(Boolean each : visited){
////                each = false;
////            }
//            for(int i=0;i<V;i++){
//                visited.add(i,false);
//            }
//            int size = DFS(from, adj, visited);
//            if(size>largest)
//                largest = size;
//        }
//        return largest;
        Vector<Boolean> visited = new Vector<>();
        for(int i = 0; i < V; i++)
        {
            visited.add(false);
        }
        int answer = 0;

        // Iterating through all the vertices
        for (int u = 0; u < V; u++)
        {
            if (visited.get(u) == false)
            {
                // Find the answer
                answer = Math.max(answer,
                        DFS(u, adj, visited));
            }
        }
        return answer;
    }
}