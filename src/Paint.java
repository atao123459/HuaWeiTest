import com.sun.source.tree.UsesTree;

import java.util.*;

/*
疫情过后，希望小学终于又重新开学了，三年二班开学第一天的任务是将后面的黑板报重新制作。黑板上已经写了N个正整数，同学们需要给每个数分别上一种颜色。
为了让黑板报即没关又有学习意义，老师要求同种颜色的所有数都可以被这种颜色中最小的那个数整除。现在请你帮帮小朋友们，算算最少需要多少种颜色才能给这N个数进行上色。

第一行有一个正整数N，其中1<=N<=100。

第二行有N个int型数（保证输入数据在[1,100]范围中），表示黑板上各个正整数的值。

输入只有一个整数，为最少需要的颜色种数。
 */
public class Paint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int count = 0;
        int[] s = new int[num];
        for(int i = 0;i < nums.length;i++){
            if(s[i] > 0){
                continue;
            }else {
                for (int j = i; j < nums.length; j++) {
                    if(nums[i] % nums[j] == 0){
                        s[j]++;
                    }
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
