import java.util.*;

/*
2022.7.22

【考勤信息】

公司用一个字符串来表示员工的出勤信息

absent：缺勤

late：迟到

leaveearly：早退

present：正常上班

现需根据员工出勤信息，判断本次是否能获得出勤奖，能获得出勤奖的条件如下：

缺勤不超过一次；

没有连续的迟到/早退；

任意连续7次考勤，缺勤/迟到/早退不超过3次。

输入描述

用户的考勤数据字符串，记录条数 >= 1；

输入字符串长度 < 10000；

不存在非法输入

如：

2

present

present absent present present leaveearly present absent

输出描述

根据考勤数据字符串，如果能得到考勤奖，输出”true”；否则输出”false”，

对于输入示例的结果应为：

true false

示例1 输入输出示例仅供调试，后台判题数据一般不包含示例

输入

2

present

present present

输出

true

true

示例2 输入输出示例仅供调试，后台判题数据一般不包含示例

输入

2

present

present absent present present leaveearly present absent

输出

true

false
 */
public class Attendance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = Integer.parseInt(sc.nextLine());
            String[] str = new String[num];
            for (int i = 0; i < num; i++) {
                str[i] = sc.nextLine();
            }
            for (String value : str) {
                String[] info = value.split(" ");
                int absent = 0;
                for (String item : info) {//缺勤次数
                    if (item.equals("absent")) {
                        absent++;
                    }
                }
                if (absent > 1) {
                    System.out.println("false");
                    continue;
                }
                //连续的迟到/早退
                if (value.contains("leaveearly leaveearly") || value.contains("late late") || value.contains("late leaveearly") || value.contains("leaveearly late")) {
                    System.out.println("false");
                    continue;
                }
                int count = 0, noPresent = 0;
                if (info.length > 7) {
                    for (int j = 0; j + 7 < info.length; j++) {
                        //任意7次考勤
                        for (int k = j; k < 7; k++) {
                            if (info[k].equals("absent") || info[k].equals("late") || info[k].equals("leaveearly")) {
                                noPresent++;
                            }
                        }
                        count = Math.max(count, noPresent);
                    }
                } else {
                    for (String s : info) {
                        if (s.equals("absent") || s.equals("late") || s.equals("leaveearly")) {
                            count++;
                        }
                    }
                }
                if (count > 3) {
                    System.out.println("false");
                    continue;
                }
                System.out.println("true");
            }
        }
    }
}
