import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {
    static int n;
    static int[][] map;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        visited = new int[n+1];
        map = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(v);
        System.out.println();
        bfs(v);

    }

    public static void dfs(int v){
        visited[v] = 1;

        System.out.print(v + " ");

        for(int i=1; i<=n; i++){
            if(visited[i] == 1 || map[v][i] == 0) continue;
            dfs(i);
        }
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(v);
        visited[v] = 0;
        while(!queue.isEmpty()){
            v = queue.peek();
            System.out.print(queue.peek() + " ");
            queue.poll();
            for(int i=1; i<=n; i++){
                if(visited[i] == 0 || map[v][i] == 0) continue;
                queue.offer(i);
                visited[i] = 0;
            }
        }
    }
}
