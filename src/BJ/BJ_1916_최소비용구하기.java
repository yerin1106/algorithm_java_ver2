package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1916_최소비용구하기 {
    static class Bus implements Comparable<Bus>{
        int no;
        int price;

        public Bus(int no, int price){
            this.no = no;
            this.price = price;
        }

        @Override
        public int compareTo(Bus o) {
            return this.price - o.price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];
        for (int i=0; i<=n; i++){
            Arrays.fill(map[i], -1);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            if(map[start][end] != -1) map[start][end] = Math.min(map[start][end], price);
            else map[start][end] = price;
            //map[end][start] = price;
        }

//        for (int i=0; i<=n; i++){
//            for(int j=0; j<=n; j++){
//                System.out.print(map[i][j] +" ");
//            }
//            System.out.println();
//        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Bus> pQueue = new PriorityQueue<Bus>();
        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;
        pQueue.offer(new Bus(start, distance[start]));

        while(!pQueue.isEmpty()){
            Bus current = pQueue.poll();
            //System.out.println(current.no + " " + visited[current.no]);
            if(visited[current.no]) continue;
            visited[current.no] = true;

            for(int j=1; j<=n; j++){
                //System.out.println(map[current.no][j] + " " + distance[j]);
                if(map[current.no][j] != -1 &&
                        distance[j] > distance[current.no] + map[current.no][j]){
                    distance[j] = distance[current.no] + map[current.no][j];
                    pQueue.offer(new Bus(j, distance[j]));
                }
            }
        }

        //System.out.println(Arrays.toString(distance));
        System.out.println(distance[end]);
    }
}
