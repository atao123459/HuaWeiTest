import java.util.*;

/*
第一行输入一串由逗号隔开的数字，第二行输入一个整数。若该整数可以由第一行的连续数字的和表示，输出连续数字的最大数量；若不能表示，输出-1
如输入：
2,1,3,4,2,3,1,5,7
12
输出：5
解释：第一行的连续数字中：2+1+3+4+2=12，个数为5；3+4+2+3=12，个数为4；5+7=12，个数为2。其中5最大，输出5。
输入：
1,2,3,4
20
输出：-1
 */
public class LongestSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int num = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            int n = Integer.parseInt(str[i]);
            list.add(n);
        }
        int count = -1;
        for (int i = 0;i < list.size();i++) {
            if (list.get(i) == num) {
                count = 1;
            } else {
                int sum = 0;
                int index = i;
                while(index < list.size()){
                    sum += list.get(index);
                    if(sum == num){
                        count = Math.max(count,index + 1 - i);
                        break;
                    }else if(sum > num){
                        break;
                    }else {
                        index++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
