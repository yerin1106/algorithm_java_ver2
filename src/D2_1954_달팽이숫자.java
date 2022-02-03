import java.util.Scanner;

public class D2_1954_달팽이숫자 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //우하좌상
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int t = sc.nextInt();
        for(int tc = 0; tc<t; tc++){
            int n = sc.nextInt();

            if(n==1){
                System.out.printf("#%d\n", tc+1);
                System.out.println(1);
                continue;
            }

            int[][] arr = new int[n][n];

            int x = 0;
            int y = 0;

            //방향
            int dir = 0;

            for(int i=0; i<n*n; i++){
                arr[x][y] = i+1;
                x += dx[dir];
                y += dy[dir];

                if(x<0 || x>=n || y<0 || y>=n){
                    //원래자리로 복귀
                    x -= dx[dir];
                    y -= dy[dir];

                    //방향 전환
                    dir = (dir+1) % 4;

                    //다시 이동
                    x += dx[dir];
                    y += dy[dir];
                }

                if(arr[x][y] != 0){
                    //원래자리로 복귀
                    x -= dx[dir];
                    y -= dy[dir];

                    //방향 전환
                    dir = (dir+1) % 4;

                    //다시 이동
                    x += dx[dir];
                    y += dy[dir];
                }
            }

            System.out.printf("#%d\n", tc+1);

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
