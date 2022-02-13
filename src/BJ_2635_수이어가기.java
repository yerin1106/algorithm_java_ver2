import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2635_수이어가기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> result = new ArrayList<>();
        int max = 0;
        for(int i=n; i>=n/2; i--){
            // int i=1; i<=n/2를 했을 경우, n이 1이면 돌아가지 않음
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(n);

            int a = i;
            int b = n-i;

            arr.add(a);
            arr.add(b);

            while(true){
                if(a-b < 0) break;

                int tmp = a;
                a = b;
                b = tmp - b;

                arr.add(b);
            }
            if(max < arr.size()){
                max = arr.size();
                result = arr;
            }
        }
        System.out.println(max);
        for(int c : result) System.out.print(c + " ");

    }

//    static int cnt;
//    static int max;
//
//    static String tmp;
//    static String result;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        tmp = Integer.toString(n);
//        for(int i=1; i<=n/2; i++){
//            int a = n - i; // 50 ~ 99
//            int b = i;
//            tmp += Integer.toString(a) + Integer.toString(b);
//            cnt = 1;
//            search(a, b);
//            System.out.println(tmp);
//            if(cnt > max) max = cnt;
//        }
//        System.out.println(max);
//
//    }
//
//    public static void search(int a, int b){
//        if(a-b<0) {
//            cnt++;
//            //System.out.println(cnt);
//            return;
//        }
//        cnt++;
//        tmp += Integer.toString(a-b);
//        //System.out.printf("%d %d\n", a, b);
//        search(b, a-b);
//    }
}
