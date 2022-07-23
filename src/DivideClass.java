import java.util.*;

/*
2022.7.14

幼儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友是否同班，请你帮忙把同班的小朋友找出来。
小朋友的编号为整数，与前一位小朋友同班用Y表示，不同班用N表示。
输入描述:
输入为空格分开的小朋友编号和是否同班标志。
比如：6/N 2/Y 3/N 4/Y，表示共4位小朋友，2和6同班，3和2不同班，4和3同班。
其中，小朋友总数不超过999，每个小朋友编号大于0，小于等于999。
不考虑输入格式错误问题。
输出描述:
输出为两行，每一行记录一个班小朋友的编号，编号用空格分开。且：
1、编号需要按照大小升序排列，分班记录中第一个编号小的排在第一行。
2、若只有一个班的小朋友，第二行为空行。
3、若输入不符合要求，则直接输出字符串ERROR。
示例1：
输入
1/N 2/Y 3/N 4/Y
输出
1 2
3 4
说明
2的同班标记为Y，因此和1同班。
3的同班标记为N，因此和1、2不同班。
4的同班标记为Y，因此和3同班。
所以1、2同班，3、4同班，输出为
1 2
3 4
————————————————
版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/csfun1/article/details/124390802
 */
public class DivideClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String[] students = sc.nextLine().split(" ");
        int classNum = 0;
        for(int i = 0;i < students.length;i++){
            String[] student = students[i].split("/");
            if(i == 0){
                list1.add(student[0]);
                classNum = 1;
                continue;
            }
            if(classNum == 1){
                if(student[1].equals("Y")) {
                    list1.add(student[0]);
                }else {
                    list2.add(student[0]);
                    classNum = 2;
                }
            }else {
                if(student[1].equals("Y")){
                    list2.add(student[0]);
                }else {
                    list1.add(student[0]);
                    classNum = 1;
                }
            }
        }
        list1.sort(String::compareTo);
        list2.sort(String::compareTo);
        for (String s : list1) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : list2) {
            System.out.print(s + " ");
        }
    }
}
