package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리
public class BJ_9372_상근이의여행 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            int length = 0;

            for(int i=1; i<n+1; i++){
                parent[i] = i;
            }

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

//                if(!isSameParent(a, b)){
//                    length++;
//                    union(a, b);
//                }
            }

            System.out.println(n-1);
        }
    }

    // 간선 연결
    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }

    // 부모 노드 찾기
    public static int find(int a){
        if(parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }

    // 부모가 같은지 판별
    public static boolean isSameParent(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return true;
        else return false;
    }
}
