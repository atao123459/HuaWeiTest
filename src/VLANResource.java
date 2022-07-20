import java.util.*;

public class VLANResource {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] resources = sc.nextLine().split(",");
        int request = sc.nextInt();
        List<Integer> pool = new ArrayList<>();
        for(String resource : resources){
            if(resource.contains("-")){
                String[] strs = resource.split("-");
                int start = Integer.parseInt(strs[0]);
                int end = Integer.parseInt(strs[1]);
                for (int i = start; i < end + 1; i++) {
                    pool.add(i);
                }
            }else {
                pool.add(Integer.parseInt(resource));
            }
        }
        Collections.sort(pool);
        pool.remove((Object)request);

        int index = 0;
        int start = 0;//含有-的元素的起始值
        int temp = 1;
        StringBuilder sb = new StringBuilder();
        while(index < pool.size()){
            if(start == 0){//开始输出时取出start
                start = pool.get(index);
            }
            if(index + 1 == pool.size()){//保证不越界，下一位一定存在
                sb.append(start);
                break;
            }
            if(pool.get(index + 1) == start + temp){//下一个元素与当前相等，向后查找
                index++;
                temp++;
                continue;
            }else if(start == pool.get(index)){//输出当前值
                sb.append(start).append(",");
                start = 0;
                temp = 1;
            }else {
                sb.append(start).append("-").append(pool.get(index));
                start = 0;
                temp = 1;
                if(index + 1 < pool.size()){
                    sb.append(",");
                }
            }
            index++;
        }
        System.out.println(sb);
    }
}
