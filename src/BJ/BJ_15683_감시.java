//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//class CCTV{
//    int x, y;
//
//    public CCTV(int x, int y){
//        super();
//        this.x = x;
//        this.y = y;
//    }
//}
//
//
//public class BJ_15683_감시 {
//    static int n, m;
//    static int[][] map;
//    static int[][][] pos = {{}, {{0},{1},{2},{3}},{{0,2},{1,3}},
//            {{0,1}, {1,2}, {2,3}, {3,0}}, {{0,2,3}, {0,1,3},{1,2,0},{3,2,1}}};
//
//    static ArrayList<CCTV> list = new ArrayList<>();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = null;
//
//        st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        map = new int[n][m];
//        for(int i=0; i<n; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j=0; j<m; j++){
//                map[i][j] = Integer.parseInt(st.nextToken());
//
//                if(map[i][j] != 6 && map[i][j] > 0){
//                    list.add(new CCTV(i, j));
//                }
//            }
//        }
//
//        dfs(0);
//    }
//
//    public static void dfs(int cnt){
//        if(cnt == list.size()){
//            check();
//            return;
//        }
//
//        int x = list.get(cnt).x;
//        int y = list.get(cnt).y;
//        int num = map[]
//    }
//
//    public static void check(){
//        int[][] copy = new int[n][m];
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                copy[i][j] = map[i][j];
//            }
//        }
//
//        int total = 0;
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                if(map[i][j] == 6){
//                    total += 1;
//                    continue;
//                }
//                if(map[i][j] > 0){
//                    int num = map[i][j];
//                    total += 1;
//                    for(int k=0; i<pos[num][mark])
//                }
//            }
//        }
//    }
//}
