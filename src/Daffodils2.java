import java.util.*;

public class Daffodils2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<int[]> list = new ArrayList<int[]>();
        while(in.hasNext()) {
            String str = in.nextLine();
            for(int l = 0; l < str.length(); l++) {
                for(int r = l; r < str.length(); r++) {
                    int num = 0;
                    for(int i = l; i <= r; i++) {
                        num += str.charAt(i);
                    }
                    int len = Integer.toString(num).length();
                    if(len < 3) {
                        continue;
                    }
                    if(len > 3) {
                        break;
                    }
                    if(isShuixian(num)) {
                        list.add(new int[] {l, r});
                    }
                }
            }
            int cnt = list.size();
            if(cnt <= 1) {
                System.out.println(cnt);
            }
            else {
                for(int i = 0; i < cnt - 1; i++) {
                    for(int j = i + 1; j < cnt; j++) {
                        int[] pointi = list.get(i);
                        int[] pointj = list.get(j);
                        if((pointi[0] >= pointj[0] && pointi[0] <= pointj[1])
                                || (pointi[1] >= pointj[0] && pointi[1] <= pointj[1])) {
                            System.out.println(-1);
                            return;
                        }
                    }
                }
                System.out.println(cnt);
            }
        }
    }

    public static boolean isShuixian(int num){
        if(String.valueOf(num).length() != 3){
            return false;
        }
        int num1 = num /100;//百位
        int num2 = num % 100 /10;//十位
        int num3 = num % 10;//个位
        return num1 * num1 * num1 + num2 * num2 * num2 + num3 * num3 * num3 == num;
    }
}
