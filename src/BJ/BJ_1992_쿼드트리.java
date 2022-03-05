package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1992_쿼드트리 {

    static int[][] img;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        img = new int[n][n];
        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split("");
            for(int j=0; j<n; j++){
                img[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        // 쿼드트리 함수 호출
        QuadTree(0, 0, n);
        //출력
        System.out.println(sb);
    }

    public static void QuadTree(int x, int y, int size){
        if(isPossible(x, y, size)){
            sb.append(img[x][y]);
            return;
        }

        sb.append("(");
        QuadTree(x, y, size / 2);
        QuadTree(x, y + size / 2, size / 2);
        QuadTree(x + size / 2, y, size / 2);
        QuadTree(x + size / 2, y + size / 2, size / 2);
        sb.append(")");
    }

    public static boolean isPossible(int x, int y, int size){
        int value = img[x][y];

        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(value != img[i][j])
                    return false;
            }
        }

        return true;
    }
}
