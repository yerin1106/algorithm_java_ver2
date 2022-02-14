import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2564_경비원_0214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        int[] dir = new int[n];
        int[] loc = new int[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            loc[i] = Integer.parseInt(st.nextToken());
        }

        //dong[0] 방향, dong[1] 위치
        int[] dong = new int[2];
        st = new StringTokenizer(br.readLine());
        dong[0] = Integer.parseInt(st.nextToken());
        dong[1] = Integer.parseInt(st.nextToken());

        int sum = 0;
        switch (dong[0]){
            case 1:
                for(int i=0; i<n; i++){
                    switch (dir[i]){
                        case 1:
                            sum += Math.abs(dong[1] - loc[i]);
                            break;
                        case 2:
                            int a = dong[1] + h + loc[i];
                            int b = (w-dong[1]) + h + (w-loc[i]);
                            sum += (Math.min(a, b));
                            break;
                        case 3:
                            sum += (dong[1] + loc[i]);
                            break;
                        case 4:
                            sum += (w-dong[i]) + loc[i];
                            break;
                    }
                }
                break;
            case 2:
                for(int i=0; i<n; i++){
                    switch (dir[i]){
                        case 1:
                            int a = dong[1] + h + loc[i];
                            int b = (w-dong[1]) + h + (w-loc[i]);
                            sum += (Math.min(a, b));
                            break;
                        case 2:
                            sum += Math.abs(dong[1] - loc[i]);
                            break;
                        case 3:
                            sum += (h-loc[i]) + dong[1];
                            break;
                        case 4:
                            sum += (w - dong[1]) + (h - loc[i]);
                            break;
                    }
                }
                break;
            case 3:
                for(int i=0; i<n; i++){
                    switch (dir[i]){
                        case 1:
                            sum += (dong[1] + loc[i]);
                            break;
                        case 2:
                            sum += (h-dong[1]) + loc[i];
                            break;
                        case 3:
                            sum += Math.abs(dong[1] - loc[i]);
                            break;
                        case 4:
                            int a = dong[1] + w + loc[i];
                            int b = (h-dong[1]) + w + (h-loc[i]);
                            sum += Math.min(a, b);
                            break;
                    }
                }
                break;
            case 4:
                for(int i=0; i<n; i++){
                    switch (dir[i]){
                        case 1:
                            sum += (w-loc[i]) + dong[1];
                            break;
                        case 2:
                            sum += (h-dong[1]) + (w-loc[i]);
                            break;
                        case 3:
                            int a = dong[i] + w + loc[i];
                            int b = (h-dong[i]) + w + (h-loc[i]);
                            sum += Math.min(a, b);
                            break;
                        case 4:
                            sum += Math.abs(dong[1] - loc[i]);
                            break;
                    }
                }
                break;
        }
        System.out.println(sum);
    }
}
