package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5212_지구온난화 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[][] map = new String[r][c];
        for(int i=0; i<r; i++){
            String[] tmp = br.readLine().split("");
            for(int j=0; j<c; j++){
                map[i][j] = tmp[j];
            }
        } //입력

        // 잠기는 땅 예측
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j].equals("X")){
                    int cnt = 0;
                    for(int k=0; k<4; k++){
                        int rx = i + dx[k];
                        int ry = j + dy[k];

                        if(rx < 0 || ry < 0 || rx >= r || ry >= c) {
                            cnt++;
                            continue;
                        }

                        if(map[rx][ry].equals(".")) cnt++;
                    }
                    if(cnt >= 3) map[i][j] = "*";
                }
            }
        }

//        for(int i=0; i<r; i++){
//            for(int j=0; j<c; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        // 지도 그리기
        int rMin = Integer.MAX_VALUE;
        int cMin = Integer.MAX_VALUE;
        int rMax = 0;
        int cMax = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j].equals("X")){
                    rMin = Math.min(rMin, i);
                    cMin = Math.min(cMin, j);
                    rMax = Math.max(rMax, i);
                    cMax = Math.max(cMax, j);
                }
            }
        }
//        System.out.println(rMin + " " + cMin + " " + rMax + " " + cMax);

        // 출력
        for(int i=rMin; i<=rMax; i++){
            for(int j=cMin; j<=cMax; j++){
                if(map[i][j].equals("*")) map[i][j] = ".";
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
