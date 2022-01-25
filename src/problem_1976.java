import java.util.Scanner;

public class problem_1976 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        int hour = 0;
        int min = 0;
        for(int i=0; i<tc; i++){
            int hour1 = sc.nextInt();
            int min1 = sc.nextInt();
            int hour2 = sc.nextInt();
            int min2 = sc.nextInt();

            hour = hour1 + hour2;
            min = min1 + min2;

            if(min>60) {
                min -= 60;
                hour++;
            }
            if(hour>12) hour-=12;

            System.out.printf("#%d %d %d\n",i+1,hour,min);
        }
    }
}
