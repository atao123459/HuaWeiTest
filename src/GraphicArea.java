import java.util.*;

/*
2022.8.3

绘图机器的绘图笔初始位置在原点(0,0) 机器启动后按照以下规则来进行绘制直线

尝试沿着横线坐标正向绘制直线 直到给定的终点E
期间可以通过指令在纵坐标轴方向进行偏移 offsetY为正数表示正向偏移,为负数表示负向偏移
给定的横坐标终点值E 以及若干条绘制指令 请计算绘制的直线和横坐标轴以及x=E的直线组成的图形面积

输入描述:
首行为两个整数N 和 E 表示有N条指令, 机器运行的横坐标终点值E

接下来N行 每行两个整数表示一条绘制指令x offsetY

用例保证横坐标x以递增排序的方式出现 且不会出现相同横坐标x

取值范围: 0<N<=10000

0<=x<=E<=20000

-10000<=offsetY<=10000

输出描述：
一个整数表示计算得到的面积 用例保证结果范围在0到4294967295之内

示例 1：

输入
4 10
1 1
2 1
3 1
4 -2
输出
12
1
说明
通过操作机器最后绘制了如下图形（蓝色为绘制笔绘制的直线）

计算图中阴影部分面积，其值为

1*1+2*1+3*1+1*6=12
1
示例 2：

输入
2 4
0 1
2 -2
输出
4
思路分析：
简单的模拟题，模拟计算所围矩形的面积。
————————————————
版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_44052055/article/details/123973198
 */
public class GraphicArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            int e = Integer.parseInt(str1[1]);
            List<Integer> listX = new ArrayList<>();
            List<Integer> listY = new ArrayList<>();
            for(int i = 0;i < n;i++){
                String[] str2 = sc.nextLine().split(" ");
                listX.add(Integer.parseInt(str2[0]));
                listY.add(Integer.parseInt(str2[1]));
            }
            int res = 0,area = 0;
            int sumY = 0;
            for(int i = 0;i < n;i++){
                if(i == n - 1){
                    sumY += listY.get(i);
                    //最后一个点的宽等于e - x坐标
                    area = (e - listX.get(i)) * Math.abs(sumY);
                }else {
                    sumY += listY.get(i);
                    area = (listX.get(i + 1) - listX.get(i)) * Math.abs(sumY);
                }
                res += area;
            }
            System.out.println(res);
        }
    }
}
