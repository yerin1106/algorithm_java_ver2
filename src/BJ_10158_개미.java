
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10158_개미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int rx = w - Math.abs(w - ((p+t)%(2*w)));
        int ry = h - Math.abs(h - ((q+t)%(2*h)));

        System.out.println(rx + " " + ry);
    }
}
