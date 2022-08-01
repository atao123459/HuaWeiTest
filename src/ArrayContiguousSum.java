import java.util.*;

public class ArrayContiguousSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int target = Integer.parseInt(str[1]);
            String[] s = sc.nextLine().split(" ");
            int[] nums = new int[n];
            for(int i = 0;i < s.length;i++){
                nums[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            LinkedList<Integer> list = new LinkedList<>();
            backTrack(0,list,target,res,n,nums);
            System.out.println(res);
        }
    }

    public static void backTrack(int first,LinkedList<Integer> list,int target,List<List<Integer>> res,int k,int[] nums){
        if(target == 0){
            return;
        }
        for(int i = first;i < k;i++){
            if(target - nums[i] < 0){
                break;
            }
            if(list.size() > 0){
                int sum = 0;
                for(int num : list){
                    sum += num;
                }
                if(sum >= target){
                    res.add(new ArrayList<>(list));
                }
            }
            list.addLast(nums[i]);
            backTrack(i + 1,list,target - nums[i],res,k,nums);
            list.removeLast();
        }
    }
}
