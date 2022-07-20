import java.util.*;

/*
2022.7.20

奖牌榜的排名算法要求如下，首先是按照金牌🏅总数排序的，如果是同等金牌的情况下，再根据银牌🥈的总数进行排序，同样在金牌跟银牌数量相等的情况下，在根据铜牌🥉的数量进行排名。
在遇到金牌🏅、银牌🥈跟铜牌🥉数量一样的情况下，根据国家的名称首字母序排序。
 */
public class MedalSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int num = sc.nextInt();
            sc.nextLine();
            List<Country2> list = new ArrayList<>();
            for(int i = 0;i < num;i++) {
                String[] info = sc.nextLine().split(" ");
                String name = info[0];
                int gold = Integer.parseInt(info[1]);
                int sliver = Integer.parseInt(info[2]);
                int bronze = Integer.parseInt(info[3]);
                Country2 country = new Country2(name,gold,sliver,bronze);
                list.add(country);
            }
            list.sort((o1,o2) -> {
                if(o1.gold == o2.gold && o1.sliver == o2.sliver && o1.bronze == o2.bronze){
                    return o1.name.compareTo(o2.name);
                }else if(o1.gold == o2.gold && o1.sliver == o2.sliver){
                    return o2.bronze - o1.bronze;
                }else if(o1.gold == o2.gold){
                    return o2.sliver - o1.sliver;
                }
                return o2.gold - o1.gold;
            });
            for(Country2 country : list){
                System.out.println(country.name + " " + country.gold + " "+ country.sliver + " " + country.bronze);
            }
        }
    }
}

class Country2{
    String name;
    int gold;
    int sliver;
    int bronze;

    public Country2(String name,int gold,int sliver,int bronze){
        this.name = name;
        this.gold = gold;
        this.sliver = sliver;
        this.bronze =  bronze;
    }
}
