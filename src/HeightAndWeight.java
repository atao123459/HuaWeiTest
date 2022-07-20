import java.util.*;

/*
 * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列；对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。
 * 输入描述:
 * 两个序列，每个序列由n个正整数组成（0 < n <= 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。
 * 输出描述:
 * 排列结果，每个数值都是原始序列中的学生编号，编号从1开始
 * 示例1：
 * 输入
 * 4
 * 100 100 120 130
 * 40 30 60 50
 * 输出
 * 2 1 3 4
 * 说明
 * 输出的第一个数字2表示此人原始编号为2，即身高为100，体重为30的这个人。由于他和编号为1的人身高一样，但体重更轻，因此要排在1前面。
 * 示例2：
 * 输入
 * 3
 * 90 110 90
 * 45 60 45
 * 输出
 * 1 3 2
 * 说明
 * 1和3的身高体重都相同，需要按照原有位置关系让1排在3前面，而不是3 1 2
 */
public class HeightAndWeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> list = new ArrayList<>();
        int num = sc.nextInt();
        int[] heights = new int[num];
        int[] weights = new int[num];
        for(int i = 0;i < num;i++){
            heights[i] = sc.nextInt();
        }
        for(int i = 0;i < num;i++){
            weights[i] = sc.nextInt();
        }
        for(int i = 0;i < num;i++){
            int height = heights[i];
            int weight = weights[i];
            Student student = new Student(height,weight,i);
            list.add(student);
        }

        Collections.sort(list,(o1,o2) ->{
            if(o1.height == o2.height){
                return o1.weight - o2.weight;
            }
            return o1.height - o2.height;
        });
        for(Student student : list){
            System.out.print(student.code + 1 + "  ");
        }
    }
}

class Student{
    int height = 0;
    int weight = 0;
    int code = 0;

    public Student(int height, int weight,int code) {
        this.height = height;
        this.weight = weight;
        this.code = code;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int coe) {
        this.code = coe;
    }
}
