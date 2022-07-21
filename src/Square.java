import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
计算向量组成的正方形数量
 */
public class Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
//        int[][] vectors = new int[num][2];
//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < 2; j++) {
//                vectors[i][j] = sc.nextInt();
//            }
//        }
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            list.add(sc.nextLine());
        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            String[] s = list.get(i).split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            for (int j = i + 1; j < list.size(); j++) {
                String[] s2 = list.get(j).split(" ");
                int x2 = Integer.parseInt(s2[0]);
                int y2 = Integer.parseInt(s2[1]);

                int x31 = x - (y - y2);
                int y31 = y + (x - x2);
                int x32 = x + (y - y2);
                int y32 = y - (x - x2);

                int x41 = x - (y - y2);
                int y41 = y + (x - x2);
                int x42 = x + (y - y2);
                int y42 = y - (x - x2);

                if (list.contains(x31 + " " + y31) && list.contains(x41 + " " + y41)) {
                    count++;
                }
                if (list.contains(x32 + " " + y32) && list.contains(x42 + " " + y42)) {
                    count++;
                }
            }
        }
        System.out.println(count / 4);
    }
}
