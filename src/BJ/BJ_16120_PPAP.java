package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BJ_16120_PPAP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){
            char temp = arr[i];

            if(temp == 'P') stack.push('P');

            else{
                if(stack.size() >= 2 && i<arr.length - 1 && arr[i+1] == 'P'){
                    stack.pop();
                    stack.pop();
                }
                else{
                    System.out.println("NP");
                    return;
                }
            }
        }
        if(stack.size() == 1) System.out.println("PPAP");
        else System.out.println("NP");
    }
}
