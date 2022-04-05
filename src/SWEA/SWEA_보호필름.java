package SWEA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_보호필름 {

    static int d, w, k, film[][], min;
    static final int A=0, B=1;
    static int[] drugA, drugB; //drugA: 막 1개에 약품 A의 상태를 표현하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = null;

        for(int t=1; t<=tc; t++){
            st = new StringTokenizer(br.readLine());

            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            film = new int[d][w];
            drugA = new int[w];
            drugB = new int[w];
            min = k;

            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }//입력처리

            Arrays.fill(drugA, A);
            Arrays.fill(drugB, B);

            process(0, 0);
            System.out.println("#" + t + " " + min);
        }
    }

    private static boolean check(){ //보호필름 성능 검사
        //열고정 행탐색 연속된 셀의 같은 특성이 k개 이상인지 검사
        for(int c=0; c<w; c++){//열고정
            int count = 1;
            int before = film[0][c];
            for(int r = 1; r<d; r++){
                int current = film[r][c];
                if(before == current){
                    if(++count == k) break;
                    //before = current;
                } else{
                    before = current;
                    count = 1;
                }
            }//하나의 열을 고정해서 수직 검사
            if(count<k) return false;
        }
        return true;
    }

    private static boolean process(int row, int useCnt){ //각 막에 부분집합으로 약품 비투여, 약품 A투여, B투여

        if(row==d){
            if(check()){
                min = Math.min(min, useCnt);
                return min==0; //약품을 하나도 사용하지 않았으면 true, 사용했으면 false
            }
            return false;
        }

        if(useCnt >= min) return false; //기존 임시최적해의 최소 약품 수보다 사용한 약품 수가 같거나 크면 의미 없으므로 리턴

        int[] backup = film[row]; //현재 막의 상태배열 기억
        //약품 비투여
        if(process(row+1, useCnt)) return true;

        //약품 A투여
        film[row] = drugA;
        if(process(row+1, useCnt+1)) return true;

        //약품 B투여
        film[row] = drugB;
        if(process(row+1, useCnt+1)) return true;

        film[row] = backup; // 기존 막의 상태로 다시 바꿔놓기
        return false;
    }
}
