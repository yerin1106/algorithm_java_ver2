import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109_빵집 {
    static int value;
    static String[][] map;
    static int c, r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r][c];
        for(int i=0; i<r; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<c; j++){
                map[i][j] = line[j];
            }
        }

        value = 0;
        for(int i=0; i<r; i++){
            if(check(i, 0)){
                value++;
            };
        }
        System.out.println(value);
    }

    public static boolean check(int x, int y){
        map[x][y] = "-";

        if(y == c-1) return true;

        // 오른쪽 위
        if(x > 0 && map[x-1][y+1].equals(".")){
            if(check(x-1, y+1))
                return true;
        }

        // 오른쪽
        if(map[x][y+1].equals(".")){
            if(check(x, y+1))
                return true;
        }

        // 오른쪽 아래
        if(x+1 < r && map[x+1][y+1].equals(".")){
            if(check(x+1, y+1))
                return true;
        }
        return false;
    }
}
