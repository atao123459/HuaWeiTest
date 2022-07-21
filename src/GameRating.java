import java.util.*;

/*
2022.7.11
一个有N个选手参加比赛，选手编号为1~N（3<=N<=100），有M（3<=M<=10）个评委对选手进行打分。打分规则为每个评委对选手打分，最高分10分，最低分1分。
请计算得分最多的3位选手的编号。如果得分相同，则得分高分值最多的选手排名靠前(10分数量相同，则比较9分的数量，以此类推，用例中不会出现多个选手得分完全相同的情况)。
输入描述:
第一行为半角逗号分割的两个正整数，第一个数字表示M（3<=M<=10）个评委，第二个数字表示N（3<=N<=100）个选手。
第2到M+1行是半角逗号分割的整数序列，表示评委为每个选手的打分，0号下标数字表示1号选手分数，1号下标数字表示2号选手分数，依次类推。
输出描述:
选手前3名的编号。
注：若输入为异常，输出-1，如M、N、打分不在范围内。
示例1：
输入
4,5
10,6,9,7,6
9,10,6,7,5
8,10,6,5,10
9,10,8,4,9
输出
2,1,5
说明
第一行代表有4个评委，5个选手参加比赛
矩阵代表是4*5，每个数字是选手的编号，每一行代表一个评委对选手的打分排序，
2号选手得分36分排第1，1号选手36分排第2，5号选手30分(2号10分值有3个，1号10分值只有1个，所以2号排第一)
示例2：
输入
2,5
7,3,5,4,2
8,5,4,4,3
输出
-1
说明：只有2个评委，要求最少为3个评委
示例3：
输入
4,2
8,5
5,6
10,4
8,9
输出
-1
说明：只有2名选手参加，要求最少为3名
示例4：
输入
4,5
11,6,9,7,8
9,10,6,7,8
8,10,6,9,7
9,10,8,6,7
输出
-1
说明：第一个评委给第一个选手打分11，无效分数
 */
public class GameRating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(",");
        int m = Integer.parseInt(nums[0]);//评委
        int n = Integer.parseInt(nums[1]);//选手
        List<String[]> scoreList = new ArrayList<>();
        List<Player> playerList = new ArrayList<>();
        if(m < 3 || m > 10 || n < 3 || n > 100){
            System.out.println(-1);
            return;
        }
        for(int i = 0;i < m;i++){
            scoreList.add(sc.nextLine().split(","));
        }
        for (int i = 0; i < n; i++) {
            int total = 0;
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j < m;j++){
                String[] str = scoreList.get(j);
                int score = Integer.parseInt(str[i]);
                if(score < 0 || score > 10){
                    System.out.println(-1);
                    return;
                }else{
                    list.add(score);
                    total += score;
                }
            }
            playerList.add(new Player(i + 1,total,list));
        }
        playerList.sort((o1, o2) -> {
            //分数相同通过单个评分个数决定先后
            if (o1.total == o2.total) {
                List<Integer> list1 = o1.score;
                List<Integer> list2 = o2.score;
                int count1 = 0, count2 = 0;
                //比较评分里的个数
                for (int i = 10; i > 0; i--) {
                    for (int j = 0; j < list1.size(); j++) {
                        if (list1.get(j) == i) {
                            count1++;
                        }
                    }
                    for (int j = 0; j < list2.size(); j++) {
                        if (list2.get(j) == i) {
                            count2++;
                        }
                    }
                }
                if (count1 > count2) {
                    return 1;
                } else {
                    return -1;
                }
            }
            //分数不相等直接降序排序
            return o2.total - o1.total;
        });
        for (int i = 0; i < 3; i++) {
            if(i == 2){
                System.out.println(playerList.get(i).code);
            }else {
                System.out.print(playerList.get(i).code + ",");
            }
        }
    }
}

class Player{
     int code;
     int total;
     List<Integer> score;

    public Player(int code, int total, List<Integer> score) {
        this.code = code;
        this.total = total;
        this.score = score;
    }
}
