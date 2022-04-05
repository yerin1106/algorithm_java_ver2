package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_프로세서연결하기_수업 {

    static int n, max, totalCnt, min, map[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=t; tc++){
            n = Integer.parseInt(br.readLine()); // 셀의 크기

            map = new int[n][n];
            list = new ArrayList<>(); //가장자리가 아닌 코어리스트

            min = Integer.MAX_VALUE; //최소 전선 길이의 합
            max = 0; //최대 연결 코어수
            totalCnt = 0;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if((i==0||i==n-1||j==0||j==n-1) && map[i][j] == 1) continue; //가장자리 코어는 skip
                    if(map[i][j] == 1) {
                        list.add(new int[] {i, j});
                        totalCnt++;
                    }
                }
            }

            go(0, 0);

            System.out.println("#" + tc + " " + min);
        }
    }

    private static void go(int index, int cCNT){ //부분집한으로 코어 전선놓기 시도, cCNT: 전원과 연결된 코어 수
        if(index == totalCnt){
            int res = getLength();
            if(max < cCNT){
                max = cCNT;
                min = res;
            } else if(max == cCNT){ //최대 연결 코어수가 같다면
                if(min>res) min = res;
            }
            return;
        }

        int[] core = list.get(index);
        int r = core[0];
        int c = core[1];

        // 전선을 놓아보기(4방향으로)
        for(int d=0; d<4; d++){
            if(isAvailable(r, c, d)){ //현재 코어의 r,c 위치에서 d방향으로 전선을 놓을 수 있다면
                setStatus(r, c, d, 2); //전선 놓기기
                go(index+1, cCNT+1);
                setStatus(r, c, d, 0);
           }
        }

        // 전선 놓지 않기
        go(index+1, cCNT);
    }

    private static boolean isAvailable(int r, int c, int d){ //r, c 위치에서 d 방향으로 놓을 수 있는지 체크
        int nr = r, nc = c;
        while(true){
            nr += dx[d];
            nc += dy[d];

            if(nr<0 || nr >=n || nc < 0 || nc >= n) break;

            //다른 코어나 전선을 만나면 return false;
            if(map[nr][nc] >= 1) return false;
        }

        return true;
    }

    private static void setStatus(int r, int c, int d, int s){ //r,c 위치에서 d방향으로 전선을 놓거나(2) 지우거나(0)
        int nr = r, nc = c;
        while(true){
            nr += dx[d];
            nc += dy[d];

            if(nr<0 || nr >=n || nc < 0 || nc >= n) break;

            map[nr][nc] = s;
        }

    }

    private static int getLength(){ //놓아진 전선의 길이의 합 계산산
        int lCnt = 0;
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(map[r][c] == 2) lCnt++;
            }
        }
        return lCnt;
   }
}