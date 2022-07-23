import java.util.*;

/*
2022.7.20

 磁盘的容量单位有M,G,T这三个等级
 他们之间的换算关系为
 1T=1024G
 1G=1024M
 现在给定N块磁盘的容量
 请对他们按从小到大的顺序进行稳定排序
 例如给定5块盘容量
 1T,20M,3G,10G6T,3M12G9M
 排序后的结果为20M,3G,3M12G9M,1T,10G6T
 注意单位可以重复出现
 上述3M12G9M为 3M+12G+9M和 12M12G相等

 输入描述:
 输入第一行包含一个整数N
 2<=N<=100 ,表示磁盘的个数
 接下来的N行每行一个字符串 长度 (2<l<30)
 表示磁盘的容量
 有一个或多个格式为 mv的子串组成
 其中m表示容量大小 v表示容量单位
 例如
 磁盘容量m的范围 1~1024正整数
 容量单位v的范围包含题目中提到的M,G,T
 输出描述:
 输出N行
 表示N块磁盘容量排序后的结果

 示例1:
 输入
 3
 1G
 2G
 1024M
 输出
 1G
 1024M
 2G
 说明 1G和1024M容量相等,稳定排序要求保留他们原来的相对位置
 故1G在1024M前

 示例二:
 输入
 3
 2G4M
 3M2G
 1T
 输出
 3M2G
 2G4M
 1T
 说明1T大于2G4M大于3M2G

 */
public class SSDSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int num = sc.nextInt();
            sc.nextLine();
            List<String> list = new ArrayList<>();
            for(int i = 0;i < num;i++){
                list.add(sc.nextLine());
            }
            //难点在于怎么提取出容量前的数字
            list.sort((o1,o2) -> {
               char[] arr1 = o1.toCharArray();
               char[] arr2 = o2.toCharArray();

               //转成long防止int溢出
               long total1 = 0;
               long total2 = 0;

               for(int i = 0;i < arr1.length;i++) {
                   StringBuilder num1 = new StringBuilder();
                   while (i < arr1.length && Character.isDigit(arr1[i])) {
                       num1.append(arr1[i]);
                       i++;
                   }
                   if (arr1[i] == 'M'){
                       total1 += Integer.parseInt(num1.toString());
                   }else if(arr1[i] == 'G'){
                       total1 += Integer.parseInt(num1.toString()) * 1024L;
                   }else {
                       total1 += Integer.parseInt(num1.toString()) * 1024L * 1024L;
                   }
               }

               for(int i = 0;i < arr2.length;i++){
                   StringBuilder num2 = new StringBuilder();
                   while(i < (arr2).length && Character.isDigit(arr2[i])){//提取字母前的数字，单个就循环一次，多个循环多次拼接
                       num2.append(arr2[i]);
                       i++;
                   }
                   if (arr2[i] == 'M'){
                       total2 += Integer.parseInt(num2.toString());
                   }else if(arr2[i] == 'G'){
                       total2 += Integer.parseInt(num2.toString()) * 1024L;
                   }else {
                       total2 += Integer.parseInt(num2.toString()) * 1024L * 1024L;
                   }
               }
               return Long.compare(total1,total2);
            });
            for(String s : list){
                System.out.println(s);
            }
        }
    }
}
