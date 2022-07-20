import java.util.*;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        while(start < end){
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
        for(String s : words){
            System.out.print(s + " ");
        }
    }
}
