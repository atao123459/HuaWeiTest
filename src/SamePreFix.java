import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SamePreFix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String str = sc.nextLine();
        String[] words = str.split(" ");
        char prefix = sc.nextLine().charAt(0);
        for(String s : words){
            if(s.startsWith(String.valueOf(prefix))){
                list.add(s);
            }
        }
//        list.sort(String::compareTo);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
