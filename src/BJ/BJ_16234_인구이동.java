package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16234_인구이동 {

    static int[][] map;
    static boolean[][] visited;
    static int n, l, r;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(true){
            visited = new boolean[n][n];
            if(!check()){
                day++;
            }else{
                break;
            }
        }
        System.out.println(day);
    }

    public static boolean check(){
        List<Node> list;
        boolean isDone = true;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    list = new LinkedList<>();
                    list.add(new Node(i, j));

                    int sum = search(i, j, list, 0);
                    if(list.size() > 1){
                        move(sum, list);
                        isDone = false;
                    }
                }
            }
        }
        return  isDone;
    }

    public static int search(int x, int y, List<Node> list, int sum){
        visited[x][y] = true;
        sum = map[x][y];

        for(int i=0; i<4; i++){
            int rx = x+dx[i];
            int ry = y+dy[i];

            if(rx < 0 || rx >= n || ry < 0 || ry >= n) continue;

            if(!visited[rx][ry]){
                int d = Math.abs(map[x][y] - map[rx][ry]);
                if(d >= l && d <= r){
                    list.add(new Node(rx, ry));
                    sum += search(rx, ry, list, sum);
                }
            }
        }
        return sum;
    }

    public static void move(int sum, List<Node> list){
        int avg = sum/list.size();
        for(Node n : list){
            map[n.x][n.y] = avg;
        }
    }
}
