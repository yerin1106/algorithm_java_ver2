import java.util.ArrayList;
import java.util.Scanner;

public class D3_1234_비밀번호 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int t=0; t<10; t++){
            int n = sc.nextInt();

            String line = sc.next();
            String[] tmp = line.split("");

            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int i=0; i<line.length(); i++){
                int num = Integer.parseInt(tmp[i]);
                arr.add(num);
            }

            boolean state = true;
            while(true){
                for(int i=0; i<arr.size()-1; i++){
                    if(arr.get(i) == arr.get(i+1)){
                        //System.out.println(arr.get(i) + " " + arr.get(i+1));
                        arr.remove(i);
                        arr.remove(i);
                        //System.out.println(arr);
                        break;
                    }
                    if(i == arr.size()-2) state = false;
                }
                if(state == false) {
                    break;
                }
            }

            System.out.printf("#%d ", t+1);
            for(int i=0; i<arr.size(); i++){
                System.out.print(arr.get(i));
            }
            System.out.println();
        }
    }
}
