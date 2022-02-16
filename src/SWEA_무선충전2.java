import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 모의 SW 역량테스트
public class SWEA_무선충전2 {
    static int A;
    static int rax = 1, ray = 1, rbx = 10, rby = 10;
    static int[][] bc;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            total = 0;

            rax = 1;
            ray = 1;
            rbx = 10;
            rby = 10;

            int[] a = new int[m+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] b = new int[m+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            bc = new int[A][4];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    bc[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] dx = {0, 0, 1, 0, -1};
            int[] dy = {0, -1, 0, 1, 0};

            for(int i=0; i<=m; i++){
                charge();

                rax += dx[a[i]];
                ray += dy[a[i]];
                rbx += dx[b[i]];
                rby += dy[b[i]];
            }
            System.out.printf("#%d %d\n", tc+1, total);
        }
    }

    public static void charge(){
        ArrayList<Integer> bcA = new ArrayList<>();
        ArrayList<Integer> bcB = new ArrayList<>();

        for(int i=0; i<A; i++){
            if(Math.abs(rax-bc[i][0]) + Math.abs(ray-bc[i][1]) <= bc[i][2]){
                bcA.add(i);
            }
            if(Math.abs(rbx-bc[i][0]) + Math.abs(rby-bc[i][1]) <= bc[i][2]){
                bcB.add(i);
            }
        }

        int sizeA = bcA.size();
        int sizeB = bcB.size();
        int aMax = 0, bMax = 0;
        int max = 0;

        if(sizeA == 0 && sizeB == 0) return;

        else if(sizeA == 0){
            for(int b: bcB){
                int tmp = bc[b][3];
                if(tmp > bMax) bMax = tmp;
            }
        }

        else if(sizeB == 0){
            for(int a: bcA){
                int tmp = bc[a][3];
                if(tmp > aMax) aMax = tmp;
            }
        }

        else{
            for(int a : bcA){
                for(int b : bcB){
                    int tmp = 0;

                    if(a == b){
                        tmp = bc[a][3];
                        if(tmp > max){
                            aMax = tmp/2;
                            bMax = tmp/2;
                            max = tmp;
                        }
                    }
                    else{
                        tmp = bc[a][3] + bc[b][3];
                        if(tmp > max){
                            aMax = bc[a][3];
                            bMax = bc[b][3];
                            max = tmp;
                        }
                    }
                }
            }
        }
        total += aMax + bMax;
    }
}
