import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split("~");
            String ip = str[0];
            String mask = str[1];
            int A = 0, B = 0, C = 0, D = 0, E = 0, errorIP = 0, errorMask = 0,
                    privateIP = 0;
            if (!isValidIP(ip)) {
                errorIP++;
            }
            if (isValidMask(mask)) {
                errorMask++;
            }
            String[] ipStr = ip.split("\\.");
            if (Integer.parseInt(ipStr[0]) >= 1 && Integer.parseInt(ipStr[0]) <= 126) {
                int count = 0;
                for (int i = 1; i < ipStr.length - 1; i++) {
                    if (Integer.parseInt(ipStr[i]) >= 0 && Integer.parseInt(ipStr[i]) <= 255) {
                        count++;
                    }
                }
                if (count == 3) {
                    A++;
                }
            } else if (Integer.parseInt(ipStr[0]) >= 128 &&
                    Integer.parseInt(ipStr[0]) <= 191) {
                int count = 0;
                for (int i = 1; i < ipStr.length - 1; i++) {
                    if (Integer.parseInt(ipStr[i]) >= 0 && Integer.parseInt(ipStr[i]) <= 255) {
                        count++;
                    }
                }
                if (count == 3) {
                    B++;
                }
            } else if (Integer.parseInt(ipStr[0]) >= 192 &&
                    Integer.parseInt(ipStr[0]) <= 223) {
                int count = 0;
                for (int i = 1; i < ipStr.length - 1; i++) {
                    if (Integer.parseInt(ipStr[i]) >= 0 && Integer.parseInt(ipStr[i]) <= 255) {
                        count++;
                    }
                }
                if (count == 3) {
                    C++;
                }
            } else if (Integer.parseInt(ipStr[0]) >= 224 &&
                    Integer.parseInt(ipStr[0]) <= 239) {
                int count = 0;
                for (int i = 1; i < ipStr.length - 1; i++) {
                    if (Integer.parseInt(ipStr[i]) >= 0 && Integer.parseInt(ipStr[i]) <= 255) {
                        count++;
                    }
                }
                if (count == 3) {
                    D++;
                }
            } else if (Integer.parseInt(ipStr[0]) >= 240 &&
                    Integer.parseInt(ipStr[0]) <= 255) {
                int count = 0;
                for (int i = 1; i < ipStr.length - 1; i++) {
                    if (Integer.parseInt(ipStr[i]) >= 0 && Integer.parseInt(ipStr[i]) <= 255) {
                        count++;
                    }
                }
                if (count == 3) {
                    E++;
                }
            }else {
                privateIP++;
            }
            if(errorIP == 0){
                System.out.printf(A + " " + B + " " + C + " " + D + " " + E + " " + errorMask + " " + privateIP);
            }else if(errorMask == 0){
                System.out.printf(A + " " + B + " " + C + " " + D + " " + E + " " + errorIP + " " + privateIP);
            }else {
                System.out.printf(A + " " + B + " " + C + " " + D + " " + E + " " + errorMask +" " + errorIP + " " + privateIP);
            }
        }
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
