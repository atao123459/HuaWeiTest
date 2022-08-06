import java.util.*;

/*
2022.8.5

敏感字段加密
 */
public class MinganJiaMi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int index = Integer.parseInt(scanner.nextLine());
            String originStr = scanner.nextLine();
            // 讲字符按_分割,目标取出所有的命令字
            String[] split = originStr.split("_");
            //是否有单个引号
            boolean isStart = false;
            //所有命令字
            List<String> words = new ArrayList<>();
            //拼接单个引号的命令字
            StringBuilder sb = new StringBuilder();
            for (String s : split) {
                if (s == null) {
                    continue;
                }
                if (s.contains("\"") && !s.contains("\"\"")) {
                    isStart = !isStart;
                }
                if (!isStart) {
                    if (sb.length() > 0) {
                        sb.append(s);
                        words.add(sb.toString());
                        sb.setLength(0);
                    } else {
                        words.add(s);
                    }
                } else {
                    sb.append(s).append("_");
                }
            }
            //取完所有命令字，判断并拼接
            if (index > words.size() - 1) {
                System.out.println("ERROR");
            } else {
                StringBuilder resultSb = new StringBuilder();
                for (int i = 0; i < words.size(); i++) {
                    if (i == index) {
                        resultSb.append("******").append("_");
                    } else {
                        resultSb.append(words.get(i)).append("_");
                    }
                }
                resultSb.setLength(resultSb.length() - 1);
                String res = resultSb.toString();
                System.out.println(res.replaceAll("_+","_"));
            }
        }
    }
}
