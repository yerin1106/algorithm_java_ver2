package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_보물상자비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			String[] arr = br.readLine().split("");
			
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0; i<n; i=i+n/4) {
				String tmp = "";
				for(int j=i; j<i+n/4; j++) {
					 tmp += arr[j];
				}
				if(!list.contains(tmp)) list.add(tmp);
			}
			//System.out.println(list);
			
			while(true) {
				int cnt = 0;
				
				//1. 회전
				String temp = arr[0];
				for(int i=0; i<n-1; i++) {
					arr[i] = arr[(i+1)%n];
				}
				arr[n-1] = temp;
				
				//2. 값 넣기
				for(int i=0; i<n; i=i+n/4) {
					String tmp = "";
					for(int j=i; j<i+n/4; j++) {
						 tmp += arr[j];
					}
					if(!list.contains(tmp)) list.add(tmp);
					else cnt++;
				}
				
				//System.out.println(list);
				if(cnt == 4) break;
			}
			
			Integer[] num = new Integer[list.size()];
			for(int i=0; i<list.size(); i++){
				num[i] = Integer.parseInt(list.get(i), 16);
			}
			
			Arrays.sort(num, Collections.reverseOrder());
			//System.out.println(Arrays.toString(num));
			System.out.println("#" + tc + " " + num[k-1]);
		}

	}

}
