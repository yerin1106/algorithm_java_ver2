import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10026_적록색약 {

    static int n;
    static String[][] map;
    static String[][] map2;

    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        map2 = new String[n][n];

        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split("");
            for(int j=0; j<n; j++){
                map[i][j] = tmp[j];
                if(tmp[j].equals("G")) map2[i][j] = "R";
                else map2[i][j] = tmp[j];
            }
        }

        int cnt = 0;
        int cnt2 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!map[i][j].equals("X")){
                    dfs(i, j, map[i][j]);
                    cnt++;
                }
                if(!map2[i][j].equals("X")){
                    dfs2(i, j, map2[i][j]);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt + " " + cnt2);
    }

    public static void dfs(int x, int y, String col){
        map[x][y] = "X";

        for(int d=0; d<4; d++){
            int rx = x + dx[d];
            int ry = y + dy[d];

            if(rx < 0 || ry < 0 || rx >= n || ry >= n) continue;

            if(map[rx][ry].equals("X")) continue;
            if(!col.equals(map[rx][ry])) continue;
            dfs(rx, ry, map[rx][ry]);
        }
    }

    public static void dfs2(int x, int y, String col){
        map2[x][y] = "X";

        for(int d=0; d<4; d++){
            int rx = x + dx[d];
            int ry = y + dy[d];

            if(rx < 0 || ry < 0 || rx >= n || ry >= n) continue;

            if(map2[rx][ry].equals("X")) continue;
            if(!col.equals(map2[rx][ry])) continue;
            dfs2(rx, ry, map2[rx][ry]);
        }
    }
}
