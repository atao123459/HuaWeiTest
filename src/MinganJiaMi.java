import java.util.*;

/*
2022.8.5

敏感字段加密
 */
public class MinganJiaMi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();

        char[] chars = line.toCharArray();

        ArrayList<String> sl = new ArrayList<>();
        StringBuilder buf = new StringBuilder();
        boolean b = false;
        for (char c : chars) {
            if (c == '"') {
                b = !b;
            }
            if (!b && c == '_') { // 分割保存
                if (buf.length() > 0) {
                    sl.add(buf.toString());
                }
                buf.setLength(0);
            } else {
                buf.append(c);
            }
        }
        if (buf.length() > 0) {
            sl.add(buf.toString());
        }
        if (sl.size() < k) {
            System.out.println("ERROR");
            return;
        }
        StringBuilder bu = new StringBuilder();
        for (int i = 0; i < sl.size(); i++) {
            if (i + 1 == k) {
                bu.append("******").append("_");
            } else {
                bu.append(sl.get(i)).append("_");
            }
        }
        bu.deleteCharAt(bu.length() - 1);
        System.out.println(bu);
    }
}
