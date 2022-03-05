package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2116_주사위쌓기 {
    static int max = 0;

    static int[][] dice;
    static int[] dice_up;
    static int[] dice_down;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dice = new int[n][6];
        for(int i=0; i<n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        dice_up = new int[n];
        dice_down = new int[n];

        int result = 0;
        for(int i=0; i<6; i++){
            int idx = 0;
            max = 0;
            for(int j=0; j<n; j++){
                if(j==0){
                    dice_up[idx] = dice[j][i];
                    dice_down[idx] = dice[j][decide(i)];
                }

                else{
                    dice_down[idx] = dice_up[idx-1];
                    for(int k=0; k<6; k++){
                        if(dice_down[idx] == dice[j][k]) {
                            dice_up[idx] = dice[j][decide(k)];
                            break;
                        }
                    }
                }

                findMax(idx);
                idx++;
            }
            if(result < max) result = max;
        }
        System.out.println(result);
    }

    public static void findMax(int idx){
        int ans=0;
        for(int i=0; i<6; i++){
            if(dice[idx][i] == dice_down[idx] || dice[idx][i] == dice_up[idx]) continue;
            if(ans < dice[idx][i]) ans = dice[idx][i];
        }

        max += ans;
    }

    public static int decide(int cnt){
        int down = 0;

        switch (cnt){
            case 0:
                down = 5;
                break;
            case 1:
                down = 3;
                break;
            case 2:
                down = 4;
                break;
            case 3:
                down = 1;
                break;
            case 4:
                down = 2;
                break;
            case 5:
                down = 0;
                break;
        }

        return down;
    }
}
