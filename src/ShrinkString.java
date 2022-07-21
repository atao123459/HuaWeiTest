import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShrinkString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!Character.isDigit(c) && !Character.isLetter(c)){
                System.out.println("!error");
                System.exit(0);
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            String letter = String.valueOf(entry.getKey());
            int nums = entry.getValue();
            String strNums = String.valueOf(nums);
            if(nums ==1){
                sb.append(letter);
            }else if(nums == 2){
                sb.append(letter);
                sb.append(letter);
            }else {
                sb.append(nums);
                sb.append(letter);
            }
        }
        System.out.println(sb.toString());
    }
}
