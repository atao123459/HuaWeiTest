import java.util.*;

public class MemoryAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int num = sc.nextInt();
            sc.nextLine();
            List<String[]> orders = new ArrayList<>();
            for(int i = 0;i < num;i++){
                orders.add(sc.nextLine().split("="));
            }
            int[] memory = new int[100];
            Arrays.fill(memory,0);
            int start = 0;
            Map<Integer,Integer> map = new HashMap<>();
            for(String[] order : orders){
                String command = order[0];
                if(command.equals("REQUEST")){
                    int resource = Integer.parseInt(order[1]);
                    if(resource == 0 || resource > memory.length - start){
                        System.out.println("error");
                        return;
                    }
                    int index = start;
                    map.put(index,resource);
                    while(index < resource){
                        if(memory[index] ==0 ){
                            memory[index] = index;
                        }
                        index++;
                    }
                    start = index;
                }else if(command.equals("RELEASE")){
                    int startR = Integer.parseInt(order[1]);
                    int release = map.get(startR);
                    if(startR < 0 || startR > memory.length){
                        System.out.println("error");
                        return;
                    }
                    for(int i = startR;i < release;i++){
                        memory[i] = 0;
                    }
                    start = 0;
                }
            }
            for(int key : map.keySet()){
                System.out.println(key);
            }
        }
    }
}
