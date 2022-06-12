package Programmers;

import java.util.*;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> truck = new LinkedList<Integer>();
        for (int i = 0; i < truck_weights.length; i++) {
            truck.offer(truck_weights[i]);
        }

        ArrayList<int[]> cross = new ArrayList<int[]>();
        int time = 0;
        int cur = 0;

        while (!truck.isEmpty()) {
            time++;

            ArrayList<Integer> remove_idx = new ArrayList<>();
            for (int i = 0; i < cross.size(); i++) {
                int[] tmp = cross.get(i);
                if (tmp[1] < bridge_length) cross.get(i)[1]++;
                else {
                    remove_idx.add(i);
                    // System.out.println("remove_idx: " + remove_idx);
                }
            }

            Collections.reverse(remove_idx);
            for (int i = 0; i < remove_idx.size(); i++) {
                int idx = remove_idx.get(i);
                // System.out.println("idx: " + idx);
                cur -= cross.get(idx)[0];
                cross.remove(idx);
            }

            if (cross.isEmpty()) {
                cur = truck.peek();
                cross.add(new int[]{truck.poll(), 1});
            } else {
                if (cur + truck.peek() <= weight) {
                    cur = cur + truck.peek();
                    cross.add(new int[]{truck.poll(), 1});
                }
            }

            System.out.println(time);
            for (int i = 0; i < cross.size(); i++) {
                System.out.println(Arrays.toString(cross.get(i)));
            }
        }
        // System.out.println(time + bridge_length);
        answer = time + bridge_length;
        return answer;
    }

}
