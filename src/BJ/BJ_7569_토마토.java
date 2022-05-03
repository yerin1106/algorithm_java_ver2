package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569_토마토 {
	
	static int m, n, h;
	static int[][][] map, visited;
	static Queue<int[]> queue;
	static int res = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[n][m][h];
		visited = new int[n][m][h];
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		queue = new LinkedList<>();
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j][k] == 1) {
						queue.add(new int[] {i, j, k});
					}
				}
			}
		}
		bfs();
	
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j][k] == 0) {
						System.out.print(-1);
						return;
					}
				}
			}
		}
		if(res != 0) res--;
		System.out.println(res);
	}
	
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};

	private static void bfs() {
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			visited[current[0]][current[1]][current[2]] = 1;
			
			for (int d = 0; d < 6; d++) {
				int rx = current[0] + dx[d];
				int ry = current[1] + dy[d];
				int rz = current[2] + dz[d];

				if (rx < 0 || ry < 0 || rz < 0 || rx >= n || ry >= m || rz >= h 
						|| map[rx][ry][rz] != 0 || visited[rx][ry][rz] == 1) continue;

				visited[rx][ry][rz] = 1;
				map[rx][ry][rz] = map[current[0]][current[1]][current[2]] + 1;
				res = map[rx][ry][rz];
				queue.add(new int[] {rx, ry, rz});
			}
		}
		
	}

}
