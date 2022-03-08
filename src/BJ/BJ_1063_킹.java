package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1063_킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();

        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[8][8];
        map[8- (king.charAt(1)-48)][king.charAt(0) - 65] = 7; //king
        map[8- (stone.charAt(1)-48)][stone.charAt(0) - 65] = 3; //stone

        int x = 8- (king.charAt(1)-48);
        int y = king.charAt(0) - 65;
        for(int i=0; i<n; i++){
            String move = br.readLine();
            // 한 칸 오른쪽으로
            if(move.equals("R")){
                if(y+1 >= 8) continue;
                if(map[x][y+1]==3){
                    if(y+2 >= 8) continue;
                    map[x][y] = 0;
                    map[x][y+1] = 7;
                    map[x][y+2] = 3;
                }
                else{
                    map[x][y] = 0;
                    map[x][y+1] = 7;
                }
                y++;
            }

            // 한 칸 왼쪽으로
            else if(move.equals("L")){
                if(y-1 < 0) continue;
                if(map[x][y-1] == 3){
                    if(y-2 < 0) continue;
                    map[x][y] = 0;
                    map[x][y-1] = 7;
                    map[x][y-2] = 3;
                }
                else{
                    map[x][y] = 0;
                    map[x][y-1] = 7;
                }
                y--;
            }

            // 한 칸 아래로
            else if(move.equals("B")){
                if(x+1 >= 8) continue;
                if(map[x+1][y] == 3){
                    if(x+2 >= 8) continue;
                    map[x][y] = 0;
                    map[x+1][y] = 7;
                    map[x+2][y] = 3;
                }
                else{
                    map[x][y] = 0;
                    map[x+1][y] = 7;
                }
                x++;
            }

            // 한 칸 위로
            else if(move.equals("T")){
                if(x-1 < 0) continue;
                if(map[x-1][y] == 3){
                    if(x-2 < 0) continue;
                    map[x][y] = 0;
                    map[x-1][y] = 7;
                    map[x-2][y] = 3;
                }
                else{
                    map[x][y] = 0;
                    map[x-1][y] = 7;
                }
                x--;
            }

            // 오른쪽 위 대각선으로
            else if(move.equals("RT")){
                if(x-1 < 0 || y+1 >= 8) continue;
                if(map[x-1][y+1] == 3){
                    if(x-2 < 0 || y+2 >= 8) continue;
                    map[x][y] = 0;
                    map[x-1][y+1] = 7;
                    map[x-2][y+2] = 3;
                }
                else{
                    map[x][y] = 0;
                    map[x-1][y+1] = 7;
                }
                x--; y++;

            }
            // 왼쪽 위 대각선으로
            else if(move.equals("LT")){
                if(x-1 < 0 || y-1 < 0) continue;
                if(map[x-1][y-1] == 3){
                    if(x-2 < 0 || y-2 < 0) continue;
                    map[x][y] = 0;
                    map[x-1][y-1] = 7;
                    map[x-2][y-2] = 3;
                }
                else{
                    map[x][y] = 0;
                    map[x-1][y-1] = 7;
                }
                x--; y--;
            }
            // 오른쪽 아래 대각선으로
            else if(move.equals("RB")){
                if(x+1 >= 8 || y+1 >= 8) continue;
                if(map[x+1][y+1] == 3){
                    if(x+2 >= 8 || y+2 >= 8) continue;
                    map[x][y] = 0;
                    map[x+1][y+1] = 7;
                    map[x+2][y+2] = 3;
                }
                else{
                    map[x][y] = 0;
                    map[x+1][y+1] = 7;
                }
                x++; y++;
            }
            // 왼쪽 아래 대각선으로
            else if(move.equals("LB")){
                if(x+1 >= 8 || y-1 < 0) continue;
                if(map[x+1][y-1] == 3){
                    if(x+2 >= 8 || y-2 < 0) continue;
                    map[x][y] = 0;
                    map[x+1][y-1] = 7;
                    map[x+2][y-2] = 3;
                }
                else{
                    map[x][y] = 0;
                    map[x+1][y-1] = 7;
                }
                x++; y--;
            }
        }

        int kx = 0, ky = 0;
        int sx = 0, sy = 0;

        for(int k=0; k<8; k++){
            for(int j=0; j<8; j++){
                if(map[k][j] == 7) {
                    kx = k;
                    ky = j;
                }
                if(map[k][j] == 3){
                    sx = k;
                    sy = j;
                }
            }
        }

        //map[8- (king.charAt(1)-48)][king.charAt(0) - 65] = 7;
        char k = (char) (ky+65);
        System.out.print(k);
        System.out.println(Math.abs(kx-8));

        char s = (char) (sy+65);
        System.out.print(s);
        System.out.println(Math.abs(sx-8));
    }
}
