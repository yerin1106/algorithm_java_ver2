import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백트래킹
public class BJ_1987_알파벳 {

    static int r, c;
    static int[][] map;
    static boolean[] visited = new boolean[26]; //알파벳 개수만큼
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for(int i=0; i<r; i++){
            String line = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = line.charAt(j) - 'A';
            }
        }

        search(0, 0, 0);

        System.out.println(ans);
    }

    public static void search(int x, int y, int cnt){
        if(visited[map[x][y]]){
            ans = Math.max(ans, cnt);
        }
        else{
            visited[map[x][y]] = true;
            for(int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(cx>=0 && cy>=0 && cx<r && cy<c){
                    search(cx, cy, cnt+1);
                }
            }
            visited[map[x][y]] = false;
        }
    }
}
