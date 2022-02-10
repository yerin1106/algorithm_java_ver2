import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2605_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int student = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] arr = line.split(" ");

        int[] num = new int[student];
        for(int i=0; i<student; i++){
            num[i] = Integer.parseInt(arr[i]);
        }

        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(1);
        for(int i=1; i<student; i++){
            sequence.add(sequence.size() - num[i], i+1);
        }

        for(int i=0; i<student; i++){
            System.out.print(sequence.get(i) + " ");
        }
    }
}
