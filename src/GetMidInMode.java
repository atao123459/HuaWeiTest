import java.util.HashMap;
import java.util.Map;
import java.util.*;

/*
2022.7.19

 1.众数是指一组数据中出现次数多的数
  众数可以是多个
  2.中位数是指把一组数据从小到大排列，最中间的那个数，
  如果这组数据的个数是奇数，那最中间那个就是中位数
  如果这组数据的个数为偶数，那就把中间的两个数之和除以2就是中位数
  3.查找整型数组中元素的众数并组成一个新的数组
  求新数组的中位数

  输入描述
  输入一个一维整型数组，数组大小取值范围   0<n<1000
  数组中每个元素取值范围，  0<e<1000

  输出描述
  输出众数组成的新数组的中位数

  示例一
  输入：
  10 11 21 19 21 17 21 16 21 18 16
  输出
  21

  示例二
  输入
  2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4
  输出
  3

  示例三
  输入
  5 1 5 3 5 2 5 5 7 6 7 3 7 11 7 55 7 9 98 9 17 9 15 9 9 1 39
  输出
  7

 */
public class GetMidInMode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            Map<Integer,Integer> map = new HashMap<>();
            for(String s : str){//使用map存储数字和相应的出现次数
                int num = Integer.parseInt(s);
                map.put(num,map.getOrDefault(num,0) + 1);
            }
            int max = Integer.MIN_VALUE;
            List<Integer> list = new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){//找到众数出现的次数
                max = Math.max(max,map.get(entry.getKey()));
            }
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){//找到对应的众数后加入到list中
               int key = entry.getKey();
               int value = entry.getValue();
               if(value == max){
                   list.add(key);
               }
            }
            Collections.sort(list);
            if(list.size() % 2 == 0){
                int left = list.get((list.size() / 2) - 1);
                int right = list.get((list.size() / 2));
                System.out.println((left + right) / 2);
            }else {
                System.out.println(list.get(list.size() / 2));
            }
        }
    }
}
