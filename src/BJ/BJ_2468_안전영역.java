package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2468_안전영역 {

	static int n;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int min = Integer.MAX_VALUE, max = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > max)
					max = map[i][j];
				if (map[i][j] < min)
					min = map[i][j];
			}
		} // 입력

		int result = 0;
		for (int k = min-1; k <= max; k++) {
			visited = new boolean[n][n];
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] <= k) visited[i][j] = true;
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			result = Math.max(cnt, result);
		}
		System.out.println(result);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			
			if(rx < 0 || ry < 0 || rx >= n || ry >= n || visited[rx][ry]) continue;
			
			dfs(rx, ry);
		}
	}

}
