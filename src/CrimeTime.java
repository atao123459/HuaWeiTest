import java.util.*;

/*
2022.8.4

【解密犯罪时间】

警察在侦破一个案件时，得到了线人给出的可能犯罪时间，形如 “HH:MM” 表示的时刻。

根据警察和线人的约定，为了隐蔽，该时间是修改过的，

解密规则为：利用当前出现过的数字，构造下一个距离当前时间最近的时刻，则该时间为可能的犯罪时间。

每个出现数字都可以被无限次使用。

输入描述

形如HH:SS字符串，表示原始输入。

输出描述

形如HH:SS的字符串，表示推理处理的犯罪时间。

备注

1.可以保证现任给定的字符串一定是合法的。

例如，“01:35”和“11:08”是合法的，“1:35”和“11:8”是不合法的。

2.最近的时刻可能在第二天。

示例

20:12得到20:20

23:59得到22:22

12:58得到15:11

18:52得到18:55

23:52得到23:53

09:17得到09:19

07:08得到08:00
 */
public class CrimeTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String res = getTime(str);
            System.out.println(res);
        }
    }

    public static String getTime(String str){
        String[] time = str.split(":");
        List<Integer> nums=  new ArrayList<>();
        for(char c : str.toCharArray()){
            if(c != ':') {
                nums.add(c - '0');
            }
        }
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            for(int j : nums){
                if(i <= 5) {
                    list.add(i * 10 + j);
                }
            }
        }
        //list作为替换的小时或者分钟使用
        Collections.sort(list);
        //直接替换分钟
        for(int num : list){
            if(num <= min){
                continue;
            }
            return format(hour + ":" + num);
        }
        //小时不为23时替换小时
        if(hour != 23){
            for(int num : list){
                if(num <= hour){
                    continue;
                }
                return format(num + ":" + list.get(0));
            }
        }
        //无法替换直接去第一个元素
        return format(list.get(0) + ":" + list.get(0));
    }

    //时间格式矫正，将8改为08
    public static String format(String s){
        String[] str = s.split(":");
        String hour = str[0];
        String min = str[1];
        hour = hour.length() == 2 ? hour : "0" + hour;
        min = min.length() == 2 ? min : "0" + min;
        return hour + ":" + min;
    }
}
