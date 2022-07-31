import java.util.*;

/*
寻找身高相近的小朋友

小明今年升学到小学一年级，来到新班级后发现其他小朋友们身高参差不齐，然后就想基于各小朋友和自己的身高差对他们进行排序，请帮他实现排序。
输入描述:
第一行为正整数H和N，0<H<200，为小明的身高，0<N<50，为新班级其他小朋友个数。
第二行为N个正整数H1-HN，分别是其他小朋友的身高，取值范围0<Hi<200（1<=i<=N），且N个正整数各不相同。
输出描述:
输出排序结果，各正整数以空格分割。和小明身高差绝对值最小的小朋友排在前面，和小明身高差绝对值最大的小朋友排在最后，如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面。
示例1
输入
100 10
95 96 97 98 99 101 102 103 104 105
输出
99 101 98 102 97 103 96 104 95 105
说明
小明身高100，班级学生10个，身高分别为95 96 97 98 99 101 102 103 104 105，按身高差排序后结果为：99 101 98 102 97 103 96 104 95 105。
 */
public class NearHeight {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int height = sc.nextInt();
//        int num = sc.nextInt();
//        List<Integer> list = new ArrayList<>();
//        Map<Integer,Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < num; i++) {
//            list.add(sc.nextInt());
//        }
//        for(int i : list){
//            //key是身高，value是绝对值
//            map.put(i,Math.abs(height - i));
//        }
//        //可以通过这个操作把map里的元素保存到list中,然后排序
//        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
//        entryList.sort((o1, o2) -> {
//            //身高相同时用绝对值排序
//            if (o1.getKey() - o2.getKey() == 0) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//            //按身高升序
//            return o1.getValue() - o2.getValue();
//        });
//        //对结果再排一次序，保证较小的元素在前面
//        entryList.sort((o1,o2) -> {
//           if(o1.getValue().equals(o2.getValue())){
//               if(o1.getKey() > o2.getKey()){
//                   return 1;
//               }else {
//                   return -1;
//               }
//           }
//           return 0;
//        });
//        for (Map.Entry<Integer, Integer> entry : entryList) {
//            System.out.print(entry.getKey() + " ");
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
//            String[] height = sc.nextLine().split(" ");
//            sc.nextLine();
//            int h = Integer.parseInt(height[0]);
//            int num = Integer.parseInt(height[1]);
            int h = sc.nextInt();
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < num;i++){
                list.add(sc.nextInt());
            }
            sc.nextLine();
            list.sort((o1,o2) -> {
                int h1 = Math.abs(h - o1);
                int h2 = Math.abs(h - o2);
               if(h1 == h2){
                   return o1 - o2;
               }
               return h1 - h2;
            });
            for(int i : list){
                System.out.print(i + " ");
            }
        }
    }
}
