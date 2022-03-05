package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D4_3289_서로소집합 {
    static int n;
    static int[] parents;

    public static void makeSet(){
        parents = new int[n+1];

        for(int i=1; i<n+1; i++){
            parents[i] = i;
        }
    }

    public static int findSet(int a){
        if(a==parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            makeSet();

            System.out.print("#" + (i+1) +" ");
            for(int j=0; j<m; j++){
                st = new StringTokenizer(br.readLine());

                int set = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 합집합 만들기
                if(set == 0){
                    union(a, b);
                }

                // findSet
                else{
                    boolean state;
                    int aRoot = findSet(a);
                    int bRoot = findSet(b);
                    if(aRoot == bRoot) System.out.print(1);
                    else System.out.print(0);

                }
            }
        }
    }
}
