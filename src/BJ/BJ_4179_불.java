package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179_불 {

    static int[][] map, visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new int[r][c];

        Queue<Node> jq = new LinkedList<>();
        Queue<Node> fq = new LinkedList<>();

        // 벽 -1, 지훈이 1, 불 -2
        for(int i=0; i<r; i++){
            String tmp = br.readLine();
            for(int j=0; j<c; j++){
                char temp = tmp.charAt(j);
                if(temp == '#') map[i][j] = -1;
                else if(temp == 'J') {
                    map[i][j] = 1;
                    jq.add(new Node(i, j));
                }
                else if(temp == 'F'){
                    map[i][j] = -2;
                    fq.offer(new Node(i, j));
                }
                else map[i][j] = 0;
            }
        }
        int answer = 0;

        while(true){
            answer++;
            int fs = fq.size();
            while(fs > 0){
                fs--;
                Node node = fq.poll();
                int x = node.x;
                int y = node.y;
                for(int i=0; i<4; i++){
                    if(x+dx[i] >= 0 && x+dx[i] < r && y+dy[i] >=0 && y+dy[i] < c){
                        if(map[x+dx[i]][y+dy[i]] >= 0){
                            fq.offer(new Node(x+dx[i], y+dy[i]));
                            map[x+dx[i]][y+dy[i]] = -2;
                        }
                    }
                }
            }

            int js = jq.size();
            while(js>0){
                js--;
                Node node = jq.poll();
                int x = node.x;
                int y = node.y;
                for(int i=0; i<4; i++){
                    if(x+dx[i] < 0 || x+dx[i] >= r || y+dy[i] < 0 || y+dy[i] >= c){
                        System.out.println(answer);
                        return;
                    }

                    if(map[x+dx[i]][y+dy[i]] == 0){
                        jq.add(new Node(x+dx[i], y+dy[i]));
                        map[x+dx[i]][y+dy[i]] = 1;
                    }
                }
            }
            if(jq.isEmpty()){
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}