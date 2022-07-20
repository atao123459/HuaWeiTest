import java.util.*;

public class ArrayToMinNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        PriorityQueue<Integer> heap = new PriorityQueue<>(Integer::compareTo);
        int[] nums = new int[str.length];
        for (int i = 0;i < str.length;i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        for(int num : nums){
            heap.offer(num);
        }
        String res = "";
        if (heap.size() < 3) {
            for (int i = 0; i < heap.size(); i++) {
                res += heap.poll();
            }
        } else {
            for (int i = 0; i < 3; i++) {
                res += heap.peek();
            }
        }
        System.out.println(res);
    }
}
