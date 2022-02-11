import java.util.Scanner;

public class BJ_16926_배열돌리기1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m  = sc.nextInt();
        int r = sc.nextInt();

        int cnt = Math.min(n, m)/2; //안에 생기는 사각형 수

        //입력
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        //회전하는 만큼
        for(int h = 0; h<r; h++) {
            // 사각형 만큼
            for(int c = 0; c<cnt; c++){
                int n_max = n - c - 1; //사각형 크기의 1 (하나는 중복)
                int m_max = m - c - 1;

                int start = arr[c][c];

                // 왼쪽 이동(위)
                for(int i=c; i<m_max; i++){
                    arr[c][i] = arr[c][i+1];
                }

                // 위로 이동 (우)
                for(int i = c; i<n_max; i++){
                    arr[i][m_max] = arr[i+1][m_max];
                }

                // 오른쪽 이동(아래)
                for(int i = m_max; i>c; i--){
                    arr[n_max][i] = arr[n_max][i-1];
                }

                // 아래로 이동(왼)
                for(int i = n_max; i>c; i--){
                    arr[i][c] = arr[i-1][c];
                }
                arr[c+1][c] = start;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
