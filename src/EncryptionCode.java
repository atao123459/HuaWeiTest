import java.util.*;

public class EncryptionCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str = sc.nextLine();
        StringBuilder res = new StringBuilder();
        encrypt(str,res);
        if(res.length() < k){
            System.out.println("ERROR");
            return;
        }
    }

    public static void encrypt(String str,StringBuilder res){
        int start = 0;
        int end = str.indexOf("_");
        while(end < str.length()){
            res.append(str, start, end);
            start = end + 1;
            if(str.charAt(start) == '\"'){
                end = str.indexOf("\"");
                end++;
            }else {
                end = str.indexOf("_");
            }
        }
        res.append(str.substring(start));
    }
}
