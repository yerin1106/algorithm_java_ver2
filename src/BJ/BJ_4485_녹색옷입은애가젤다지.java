package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4485_녹색옷입은애가젤다지 {

    static int[][] map;
    static int[][] sum;
    static int n;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class node implements Comparable<node>{
        int x, y, cost;

        public node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o){
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int cnt=0;
        while(true){
            n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            map = new int[n][n];
            sum = new int[n][n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    sum[i][j] = Integer.MAX_VALUE;
                }
            }

            System.out.println("Problem " + ++cnt + ": " + solution());
        }
    }

    public static int solution(){
        PriorityQueue<node> queue = new PriorityQueue<node>();
        sum[0][0] = map[0][0];
        queue.offer(new node(0, 0, map[0][0]));

        while(!queue.isEmpty()){
            node p = queue.poll();

            for(int i=0; i<4; i++){
                int rx = p.x+dx[i];
                int ry = p.y+dy[i];

                if(rx < 0 || rx >= n || ry < 0 || ry >= n) continue;

                if(sum[rx][ry] > sum[p.x][p.y] + map[rx][ry]){
                    sum[rx][ry] = sum[p.x][p.y] + map[rx][ry];
                    queue.offer(new node(rx, ry, sum[rx][ry]));
                }
            }
        }
        return sum[n-1][n-1];
    }
}
