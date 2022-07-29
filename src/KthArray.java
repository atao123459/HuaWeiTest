import java.util.*;

/*
2022.7.28

【第k个排列】

给定参数n，从1到n会有n个整数：1,2,3,…,n,这n个数字共有n!种排列。

按大小顺序升序列出所有排列的情况，并一一标记，

当n=3时,所有排列如下:

“123” “132” “213” “231” “312” “321”

给定n和k，返回第k个排列。

输入描述

输入两行，第一行为n，第二行为k，

给定n的范围是[1,9],给定k的范围是[1,n!]。

输出描述

输出排在第k位置的数字。

示例1 输入输出示例仅供调试，后台判题数据一般不包含示例

输入

3

3

输出

213

说明

3的排列有123,132,213…,那么第三位置就是213

示例2 输入输出示例仅供调试，后台判题数据一般不包含示例

输入

2

2

输出

21

说明

2的排列有12,21，那么第二位置的为21。

思路：使用回溯来对每个位置进行尝试
 */
public class KthArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = sc.nextInt();
            sc.nextLine();
            int k = sc.nextInt();
            //保存数字
            List<Integer> output = new ArrayList<>();
            //保存排列结果
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0;i < n;i++){
                output.add(i + 1);
            }
            backTrack(n,output,res,0);
           for(int i : res.get(k - 1)){
               System.out.print(i);
           }
        }
    }

    /**
     * 使用递归进行回溯
     * @param n 数字总数
     * @param output 数字集合
     * @param res 排列结果
     * @param first 排列到的位置
     *
     * 使用first将集合分为[0,first - 1]和[first,n - 1]，排序时交换第i个和第first个数，交换后得到[0,first]和[first + 1,n - 1]，前者为排好的数，后者为待排的数
     */
    public static void backTrack(int n,List<Integer> output,List<List<Integer>> res,int first){
        if(first == n){//填完了n个位置时，添加进res集合中
            res.add(new ArrayList<>(output));
        }
        for(int i = first;i < n;i++){
            //交换数字位置
            Collections.swap(output,first,i);
            //进行下一个排序
            backTrack(n,output,res,first + 1);
            //回溯
            Collections.swap(output,first,i);
        }
    }
}
