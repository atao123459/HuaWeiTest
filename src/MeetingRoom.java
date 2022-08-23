import java.util.Arrays;

/*
力扣253 会议室2
 */
public class MeetingRoom {
    public static void main(String[] args) {
//        int[][] meeting = new int[][]{{0,30},{5,10},{15,20}};
//        System.out.println(leastMeetingRoom(meeting));
        System.out.println(step(5));
    }

    public static int leastMeetingRoom(int[][] meetings){
        int n = meetings.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0;i < n;i++){
            start[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0,j = 0,max = 0,count = 0;
        while(i < start.length && j < end.length){
            if(start[i] < end[j]){
                count++;
                i++;
            }else {
                count--;
                j++;
            }
            max = Math.max(max,count);
        }
        return max;
    }

    /*
    走楼梯，一次可以走1级，2级，3级
     */
    public static int step(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
//        return switch (n) {
//            case 1 -> 1;
//            case 2 -> 2;
//            case 3 -> 4;
//            default -> step(n - 1) + step(n - 2) + step(n - 3);
//        };
    }
}
