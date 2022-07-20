import java.util.*;

public class Team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(n < 1 || m > 100000){
            System.out.println("da pian zi");
        }
        int[][] msg = new int[m][3];
        for(int i = 0;i < m;i++){
            for (int j = 0; j < 3; j++) {
                msg[i][j] = sc.nextInt();
            }
        }
        List<Set<Integer>> teams = new ArrayList<>();
        List<int[]> cache = new ArrayList<>();
        boolean flag = false;
        for(int i = 0;i < m;i++){
            if(msg[i][2] != 0){
                int[] arr = new int[]{msg[i][0],msg[i][1],msg[i][2]};
                cache.add(arr);
            }else {
                for (int j = 0; j < teams.size(); j++) {
                    Set<Integer> set = teams.get(j);
                    if(set.contains(msg[i][0]) || set.contains(msg[i][1])){
                        set.add(msg[i][0]);
                        set.add(msg[i][1]);
                        flag = true;
                        break;
                    }
                    if(!flag){
                        Set<Integer> team = new HashSet<>();
                        team.add(msg[i][0]);
                        team.add(msg[i][1]);
                        teams.add(team);
                    }
                }
            }
        }
        for (int[] ints : cache) {
            if(ints[2] != 1){
                System.out.println("da pian zi");
                continue;
            }
            for(Set<Integer> set : teams){
                if(set.contains(ints[0]) && set.contains(ints[1])){
                    System.out.println("we ara a team");
                }else {
                    System.out.println("we are not a team");
                }
            }
        }
    }
}
