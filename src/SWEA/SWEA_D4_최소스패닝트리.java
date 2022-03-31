package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_최소스패닝트리 {
    static int v, e;
    static int[] parents;
    static Edge[] edgeList;

    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight){
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }

    static void make(){
        for(int i=1; i<=v; i++){
            parents[i] = i;
        }
    }

    static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false; //사이클 생성

        int Min_Parent = Math.min(aRoot, bRoot);	// 최대한 한쪽으로 몰아 넣는다.
        parents[aRoot] = Min_Parent;
        parents[bRoot] = Min_Parent;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            edgeList = new Edge[e];
            parents = new int[v + 1];

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                edgeList[i] = new Edge(a, b, c);
            }

            Arrays.sort(edgeList);

            make();

            long res = 0;
            int cnt = 0;

            for (Edge e : edgeList) {
                if (union(e.from, e.to)) {
                    res += e.weight;
                    if (++cnt == v - 1) break; //v-1개의 간선이 이어지면 mst 생성
                }
            }

            System.out.println("#" + t + " " + res);
        }
    }
}
