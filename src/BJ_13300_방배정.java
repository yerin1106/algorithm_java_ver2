//남학생(1)은 남학생끼리, 여학생(0)은 여학생끼리
// 한 방에 같은 학년의 학생들끼리 (한 방에 한 명만 배정 가능)
// 한 방에 배정할 수 있는 최대 인원 수 k
// 조건에 맞게 필요한 최소 개수


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13300_방배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] count = new int[6][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken())-1;

            count[grade][sex]++;
        }

        int ans = 0;
        for(int i=0; i<6; i++){
            for(int j=0; j<2; j++){
                if(count[i][j] % k == 0) ans += count[i][j]/k;
                else ans += (count[i][j]/k) + 1;
            }
        }

        System.out.println(ans);

    }
}
