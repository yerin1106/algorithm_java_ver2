import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1238_Contact {

    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            graph = new int[101][101];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n/2; j++){
                graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            System.out.printf("#%d %d\n", i+1, bfs(start));
        }
    }

    public static int bfs(int start){
        int[] visited = new int[101];
        int max = 0;
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=1; i<101; i++){
                if(graph[cur][i] == 0 || visited[i] != 0) continue;

                visited[i] = visited[cur] + 1;
                q.offer(i);
            }
            max = visited[cur];
        }
        for(int i=1; i<101; i++){
            if(max != visited[i]) continue;
            if(ans < i)
                ans = i;
        }
        return ans;
    }
}
