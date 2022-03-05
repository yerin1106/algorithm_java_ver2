package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_10709_기상캐스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        String[][] map = new String[h][w];
        ArrayList<int[]> cloud = new ArrayList<>();
        for(int i=0; i<h; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<w; j++){
                map[i][j] = line[j];
                if(map[i][j].equals("c")) {
                    int[] tmp = {i, j};
                    cloud.add(tmp);
                }
            }
        }

        int[][] ans = new int[h][w];
        for(int i=0; i<cloud.size(); i++){
            int x = cloud.get(i)[0];
            int y = cloud.get(i)[1];

            ans[x][y] = -2;

            int cnt=0;
            while(true){
                y++;
                if(y >= w || map[x][y].equals("c")) break;
                ans[x][y] = ++cnt;
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(ans[i][j] == -2) ans[i][j] = 0;
                else if(ans[i][j] == 0) ans[i][j] = -1;
            }
        }


        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
