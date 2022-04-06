package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_미생물격리_Solution {
    static class Micro implements Comparable<Micro>{
        int r, c, cnt, dir;

        public Micro(int r, int c, int cnt, int dir){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public int compareTo(Micro o) {
            //return this.cnt - o.cnt; //오름차순, 최소힙
            return o.cnt - this.cnt; // 내림차순, 최대힙
        }
    }

    static int n, m, k;
    static Micro map[][];
    static int[] dr = {0, -1, 1, 0, 0}; //사용하지 않음, 상하좌우
    static int[] dc = {0, 0, 0, -1, 1};
    static PriorityQueue<Micro> pQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t=1; t<=tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new Micro[n][n];
            pQueue = new PriorityQueue<Micro>();

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                pQueue.add(new Micro(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            System.out.println("#" + t + " " + move());
        }
    }

    private static int move(){ //주어진 m 시간동안 미생물 이동 처리
        int time = m, nr, nc, remainCnt = 0;

        while(time-->0){
            // 군집리스트에서 군집들을 하나씩 모두 꺼내어 처리
            Micro micro;
            while(!pQueue.isEmpty()){
                micro = pQueue.poll();

                nr = micro.r += dr[micro.dir];
                nc = micro.c += dc[micro.dir];

                if(nr==0 || nr==n-1 || nc==0 || nc==n-1){ //가장자리 약품이 칠해진 셀
                    if((micro.cnt /= 2) == 0) continue; //크기 줄인 후 0이면 소멸

                    // 방향 반대로 턴
                    if(micro.dir % 2 == 1) micro.dir++;
                    else micro.dir--;
                }

                if(map[nr][nc] == null){ //해당 자리에 처음 이동한 미생물 군집이면 그 자리에 세팅
                    map[nr][nc] = micro;
                } else{ //해당 자리에 처음 이동한 미생물 군집이 아니면 기존 군집에 합치기
                    map[nr][nc].cnt += micro.cnt;
                }
            } //1시간 처리
            remainCnt = reset();
        }
        return remainCnt;
    }

    private static int reset(){ //매시간마다 필요한 정리, 초기화 작업
        int total = 0;

        for(int r=0; r<n; r++){
            for(int c = 0; c<n; c++){
                if(map[r][c] != null){
                    pQueue.offer(map[r][c]);
                    total += map[r][c].cnt; //살아 있는 미생물 군집의 크기 누정
                    map[r][c] = null;
                }
            }
        }
        return total;
    }
}
