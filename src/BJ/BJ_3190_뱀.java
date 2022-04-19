package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3190_뱀 {
	
	static class Direction implements Comparable<Direction>{
		int x;
		String c;
		
		public Direction(int x, String c) {
			this.x = x;
			this.c = c;
		}

		@Override
		public int compareTo(Direction o) {
			return this.x - o.x;
		}
		
	}
	
	static class Snack{
		int r;
		int c;
		
		public Snack(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n+1][n+1];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 2;
		}// 사과의 위치 저장
		
		int l = Integer.parseInt(br.readLine());
		Queue<Direction> direction = new LinkedList<Direction>();
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 String c = st.nextToken();
			 direction.add(new Direction(x, c));
		}// 방향 저장

		int d=0; //초기 방향
		map[1][1] = -1;
		ArrayList<Snack> snack = new ArrayList<Snack>();
		snack.add(new Snack(1, 1));
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		int time = 0;
		while(true) {
			Direction current = direction.peek();
			Snack head = snack.get(snack.size()-1);
			
			if(current != null && current.x == time) {
				current = direction.poll();
				if(current.c.equals("D")) d = (d+1) % 4;
				else if(current.c.equals("L")) d = (d+3) % 4;
			}
			
			time++;
			
			int rx = head.r + dx[d];
			int ry = head.c + dy[d];

			// 범위를 넘어가거나 본인을 만나면 break
			if(rx < 1 || ry < 1 || rx > n || ry > n || map[rx][ry] == -1) break;
			
			if(map[rx][ry] == 2) {
				map[rx][ry] = -1;
				snack.add(new Snack(rx, ry));
			} else if(map[rx][ry] == 0) {
				map[rx][ry] = -1;
				snack.add(new Snack(rx, ry));
				Snack tail = snack.get(0);
				map[tail.r][tail.c] = 0;
				snack.remove(0);
			}
			
//			for(int i=1; i<n+1; i++) {
//				for(int j=1; j<n+1; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(time);
//			System.out.println("---------------------------");
		}
		System.out.println(time);
	}

}
