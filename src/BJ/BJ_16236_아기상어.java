package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16236_아기상어 {
    static int n;
    static int[][] map;
    static boolean[][] isVisit; //방문여부확인

    static Fish shark;
    static int size = 2; //상어의 크기
    static int ans; //탐색한 시간

    static ArrayList<Fish> feedList = new ArrayList<>(); //먹이리스트
    static int eaten = 0; //size 비교용

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    //  물고기
    public static class Fish{
        int x, y, distance;

        public Fish(int x, int y, int distance){
            super();
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        isVisit = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    shark = new Fish(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        dfs();
        System.out.println(ans);
    }

    public static void dfs(){

        Queue<Fish> q = new LinkedList<>(); //이동 리스트
        q.add(shark);
        isVisit[shark.x][shark.y] = true;

        while(true){
            while(!q.isEmpty()){
                Fish now = q.poll();
                int d = now.distance;

                for(int k=0; k<4; k++){
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n || isVisit[nx][ny]) continue;

                    // 먹이 리스트에 추가 (크기가 작다)
                    if(map[nx][ny] < size && map[nx][ny] != 0){
                        q.add(new Fish(nx, ny, d+1));
                        isVisit[nx][ny] = true;
                        feedList.add(new Fish(nx, ny, d+1));
                    }

                    // 이동만 가능 (크기가 같거나, 비어있음)
                    if(map[nx][ny] == size || map[nx][ny] == 0){
                        q.add(new Fish(nx, ny, d+1));
                        isVisit[nx][ny] = true;
                    }
                }
            }

            if(!feedList.isEmpty()){
                eat();

                // 식사 끝, 방문 배열 초기화
                q.clear();
                isVisit = new boolean[n][n];

                //다시 이동하는 q에 상어 다시 추가
                q.add(shark);
                isVisit[shark.x][shark.y] = true;
            }

            // 더이상 먹을게 없으므로 return
            else{
                return;
            }
        }
    }

    public static void eat(){

        // 좌측이 큰 경우(내림차순), 1
        // 우측이 큰 경우(오름차순), -1
        Collections.sort(feedList, new Comparator<Fish>(){

            @Override
            public int compare(Fish o1, Fish o2) {
                if(o1.distance == o2.distance){
                    if(o1.x == o2.x){
                        if(o1.y < o2.y)
                            return -1;
                        else
                            return 1;
                    }
                    else{
                        if(o1.x < o2.x)
                            return -1;
                        else
                            return 1;
                    }
                }
                else if(o1.distance > o2.distance){
                    return 1;
                }
                else{
                    // o1.distance, o2.distance 값 중에 더 작은 값을 왼쪽에
                    return -1;
                }
            };
        });

        Fish now = feedList.get(0);

        shark.x = now.x;
        shark.y = now.y;

        if(++eaten == size){
            size++;
            eaten=0;
        }

        ans += now.distance;

        map[now.x][now.y] = 0;

        feedList.clear();
    }
}
