package undefined;

import java.util.Scanner;

public class problem_2056 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        for(int i=0; i<cnt; i++) {
            String num = sc.next();
            String[] number = num.split("");
            System.out.print("#" + (i + 1) + " ");

            String year = number[0] + number[1] + number[2] + number[3];
            String month = number[4] + number[5];
            String day = number[6] + number[7];

            //System.out.println(month);

            if (Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12) {
                if (month.equals("01") || month.equals("03") || month.equals("05") ||
                        month.equals("07") || month.equals("08") || month.equals("10") || month.equals("12")) {
                    if (Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 31) {
                        System.out.println(year + "/" + month + "/" + day);
                    } else {
                        System.out.println(-1);
                    }
                } else if (month.equals("02")) {
                    if (Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 28) {

                        System.out.println(year + "/" + month + "/" + day);
                    } else {
                        System.out.println(-1);
                    }
                } else if (month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11")) {
                    if (Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 30) {
                        System.out.println(year + "/" + month + "/" + day);
                    } else {
                        System.out.println(-1);
                    }
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}
