package JO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J0_2577_회전초밥_solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] dish = new int[n];
        for (int i = 0; i < n; i++) {
            dish[i] = Integer.parseInt(br.readLine());
        }

        int[] kind = new int[d + 1];
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (kind[dish[i]] == 0) {
                res++;
            }
            kind[dish[i]]++;
        }

        int cnt = res; //현재 초밥 가짓수
        for (int i = 1; i < n; i++) {
            if (cnt >= res) {
                if (kind[c] == 0) {
                    res = cnt + 1;
                } else {
                    res = cnt;
                }
            }
            kind[dish[i - 1]]--;
            if (kind[dish[i - 1]] == 0) {
                cnt--;
            }
            if (kind[dish[(i + k - 1) % n]] == 0) cnt++;
            kind[dish[(i + k - 1) % n]]++;
        }
        System.out.println(res);
    }
}
