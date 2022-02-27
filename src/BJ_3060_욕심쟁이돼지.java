import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3060_욕심쟁이돼지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            int n = Integer.parseInt(br.readLine()); //매일 배송되는 사료의 양

            int temp = n;
            int[] num = new int[6];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<6; i++){
                num[i] = Integer.parseInt(st.nextToken());
                temp -= num[i];
            }

            int result = 1; //결과

            while(true){
                if(temp<0) break;
                temp = n;
                result++;

                int[] tmp = Arrays.copyOf(num, num.length);
                for(int i=0; i<6; i++){
                    switch (i){
                        case 0:
                            num[0] = tmp[0] + tmp[1] + tmp[5] + tmp[3];
                            break;
                        case 1:
                            num[1] = tmp[1] + tmp[0] + tmp[2] + tmp[4];
                            break;
                        case 2:
                            num[2] = tmp[2] + tmp[1] + tmp[3] + tmp[5];
                            break;
                        case 3:
                            num[3] = tmp[3] + tmp[2] + tmp[4] + tmp[0];
                            break;
                        case 4:
                            num[4] = tmp[4] + tmp[3] + tmp[5] + tmp[1];
                            break;
                        case 5:
                            num[5] = tmp[5] + tmp[0] + tmp[4] + tmp[2];
                            break;
                    }
                    temp -= num[i];
                    if(temp < 0) break;
                }
            }
            System.out.println(result);
        }
    }
}
