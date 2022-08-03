import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
//            String[] str = sc.nextLine().split("~");
//            String ip = str[0];
//            String mask = str[1];
//            int A = 0, B = 0, C = 0, D = 0, E = 0, errorIP = 0, errorMask = 0,
//                    privateIP = 0;
//            if (!isValidIP(ip)) {
//                errorIP++;
//            }
//            if (isValidMask(mask)) {
//                errorMask++;
//            }
//            String[] ipStr = ip.split("\\.");
//            if (Integer.parseInt(ipStr[0]) >= 1 && Integer.parseInt(ipStr[0]) <= 126) {
//                int count = 0;
//                for (int i = 1; i < ipStr.length - 1; i++) {
//                    if (Integer.parseInt(ipStr[i]) >= 0 && Integer.parseInt(ipStr[i]) <= 255) {
//                        count++;
//                    }
//                }
//                if (count == 3) {
//                    A++;
//                }
//            } else if (Integer.parseInt(ipStr[0]) >= 128 &&
//                    Integer.parseInt(ipStr[0]) <= 191) {
//                int count = 0;
//                for (int i = 1; i < ipStr.length - 1; i++) {
//                    if (Integer.parseInt(ipStr[i]) >= 0 && Integer.parseInt(ipStr[i]) <= 255) {
//                        count++;
//                    }
//                }
//                if (count == 3) {
//                    B++;
//                }
//            } else if (Integer.parseInt(ipStr[0]) >= 192 &&
//                    Integer.parseInt(ipStr[0]) <= 223) {
//                int count = 0;
//                for (int i = 1; i < ipStr.length - 1; i++) {
//                    if (Integer.parseInt(ipStr[i]) >= 0 && Integer.parseInt(ipStr[i]) <= 255) {
//                        count++;
//                    }
//                }
//                if (count == 3) {
//                    C++;
//                }
//            } else if (Integer.parseInt(ipStr[0]) >= 224 &&
//                    Integer.parseInt(ipStr[0]) <= 239) {
//                int count = 0;
//                for (int i = 1; i < ipStr.length - 1; i++) {
//                    if (Integer.parseInt(ipStr[i]) >= 0 && Integer.parseInt(ipStr[i]) <= 255) {
//                        count++;
//                    }
//                }
//                if (count == 3) {
//                    D++;
//                }
//            } else if (Integer.parseInt(ipStr[0]) >= 240 &&
//                    Integer.parseInt(ipStr[0]) <= 255) {
//                int count = 0;
//                for (int i = 1; i < ipStr.length - 1; i++) {
//                    if (Integer.parseInt(ipStr[i]) >= 0 && Integer.parseInt(ipStr[i]) <= 255) {
//                        count++;
//                    }
//                }
//                if (count == 3) {
//                    E++;
//                }
//            }else {
//                privateIP++;
//            }
//            if(errorIP == 0){
//                System.out.printf(A + " " + B + " " + C + " " + D + " " + E + " " + errorMask + " " + privateIP);
//            }else if(errorMask == 0){
//                System.out.printf(A + " " + B + " " + C + " " + D + " " + E + " " + errorIP + " " + privateIP);
//            }else {
//                System.out.printf(A + " " + B + " " + C + " " + D + " " + E + " " + errorMask +" " + errorIP + " " + privateIP);
//            }
            String str = "()11245(1243sddg456)";
            System.out.println(str.replaceAll("\\(", "( ").replaceAll("\\)", " )"));
        }
    }

    public static void infection(int[][] grid,int i,int j,int n,int m,int count){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 0){
            return;
        }
        grid[i][j] = 1;
        infection(grid,i + 1,j,n,m,count + 1);
        infection(grid,i - 1,j,n,m,count + 1);
        infection(grid,i,j + 1,n,m,count + 1);
        infection(grid,i,j - 1,n,m,count + 1);
    }

    public static String[] enCode(String s,int i){
        StringBuilder sb = new StringBuilder();
        int num = 0;
        char c = 0;
        while(i < s.length()){
            if(s.charAt(i) == '{'){//遇到左括号进入递归
                c = s.charAt(i - 1);
                String[] temp = enCode(s,i + 1);//从下一位开始递归，在递归函数中记录每一次解析到的位数
                sb.append(temp[1]);
                sb.append(temp[0]);
            }else if(s.charAt(i) == '}' || s.charAt(i) == ','){//遇到右括号返回
                return new String[]{String.valueOf(c),sb.toString()};
            }else {//单个字符直接加入
//                sb.append(s.charAt(i));

            }
            i++;
        }
        return new String[]{sb.toString()};
    }


    public static boolean isValidIP(String ip) {
        String[] ipStr = ip.split("\\.");
        if (ipStr.length == 4 &&
                (Integer.parseInt(ipStr[0]) >= 0 && Integer.parseInt(ipStr[0]) <= 255) &&
                (Integer.parseInt(ipStr[1]) >= 0 && Integer.parseInt(ipStr[1]) <= 255) &&
                (Integer.parseInt(ipStr[2]) >= 0 && Integer.parseInt(ipStr[2]) <= 255) &&
                (Integer.parseInt(ipStr[3]) >= 0 && Integer.parseInt(ipStr[3]) <= 255)) {
            return true;
        }
        return false;
    }

    public static boolean isValidMask(String mask) {
        String[] maskStr = mask.split("\\.");
        int[] m = new int[maskStr.length];
        for (int i = 0; i < maskStr.length; i++) {
            m[i] = Integer.parseInt(maskStr[i]);
        }
        return m[0] >= 0 && m[0] <= 255 &&
                m[1] >= 0 && m[1] <= 255 &&
                m[2] >= 0 && m[2] <= 255 &&
                m[3] >= 0 && m[3] <= 255 &&
                m[0] >= m[1] && m[1] >= m[2] && m[2] >= m[3];
    }
}
