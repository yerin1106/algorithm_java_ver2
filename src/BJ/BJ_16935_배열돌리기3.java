package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16935_배열돌리기3 {

    static int[][] tmp, arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String[] line = br.readLine().split(" ");
        int oper = 0;
        for(int i=0; i<r; i++){
            oper = Integer.parseInt(line[i]);

            switch (oper){
                case 1:
                    upDown();
                    break;
                case 2:
                    rightLeft();
                    break;
                case 3:
                    rotateRight();
                    break;
                case 4:
                    leftRight();
                    break;
                case 5:
                    fourRight();
                    break;
                case 6:
                    fourLeft();
                    break;
            }
        }

        //출력
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
    }

    // case1 (상하반전)
    public static void upDown(){
        tmp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmp[i][j] = arr[n-i-1][j];
            }
        }
        arr = tmp;
    }

    // case2 (좌우반전)
    public static void rightLeft(){
        tmp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmp[i][j] = arr[i][m-j-1];
            }
        }
        arr = tmp;
    }

    // case 3(90도 회전 (오른쪽))
    public static void rotateRight(){
        tmp = new int[m][n];

        int c = n-1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmp[j][c] = arr[i][j];
            }
            c--;
        }

        // arr 크기 변환
        int temp = n;
        n = m;
        m = temp;

        arr = tmp;
    }

    // case 4(90도 회전 (왼쪽))
    public static void leftRight(){
        tmp = new int[m][n];

        int c = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmp[m-j-1][i] = arr[i][j];
            }
        }

        // arr 크기 변환
        int temp = n;
        n = m;
        m = temp;

        arr = tmp;
    }

    //case5(4컷 오른쪽 회전)
    public static void fourRight(){
        tmp = new int[n][m];
        // 1구역
        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                tmp[i][j + m/2] = arr[i][j];
            }
        }

        // 2구역
        for(int i=0; i<n/2; i++){
            for(int j=m/2; j<m; j++){
                tmp[i + n/2][j] = arr[i][j];
            }
        }

        // 3구역
        for(int i=n/2; i<n; i++){
            for(int j=m/2; j<m; j++){
                tmp[i][j - m/2] = arr[i][j];
            }
        }

        // 4구역
        for(int i=n/2; i<n; i++){
            for(int j=0; j<m/2; j++){
                tmp[i - n/2][j] = arr[i][j];
            }
        }

        arr = tmp;
    }

    //case 6(4컷 왼쪽 회전)
    public static void fourLeft(){
        tmp = new int[n][m];
        // 1구역
        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                tmp[i + n/2][j] = arr[i][j];
            }
        }

        // 2구역
        for(int i=0; i<n/2; i++){
            for(int j=m/2; j<m; j++){
                tmp[i][j - m/2] = arr[i][j];
            }
        }

        // 3구역
        for(int i=n/2; i<n; i++){
            for(int j=m/2; j<m; j++){
                tmp[i - n/2][j] = arr[i][j];
            }
        }

        // 4구역
        for(int i=n/2; i<n; i++){
            for(int j=0; j<m/2; j++){
                tmp[i][j + m/2] = arr[i][j];
            }
        }

        arr = tmp;
    }
}
