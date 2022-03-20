package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_17413_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp = br.readLine();
        String[] input = tmp.split("");

        ArrayList<String> arr = new ArrayList<>();
        boolean flag = false;
        for(int i=0; i< input.length; i++){
            if(input[i].equals(" ")){
                for(int j=arr.size()-1; j>=0; j--){
                    System.out.print(arr.get(j));
                }
                arr.clear();
                System.out.print(" ");
                continue;
            }

            if(input[i].equals("<")){
                for(int j=arr.size()-1; j>=0; j--){
                    System.out.print(arr.get(j));
                }
                arr.clear();
                System.out.print("<");
                flag = true;
                continue;
            }

            if(input[i].equals(">")){
                flag = false;
                System.out.print(">");
                continue;
            }

            if(flag) System.out.print(input[i]);

            if(!flag) arr.add(input[i]);
        }
        for(int j=arr.size()-1; j>=0; j--){
            System.out.print(arr.get(j));
        }
    }
}
