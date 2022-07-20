import java.util.*;

/*
2022.7.12

2012 伦敦奥运会即将到来，大家都非常关注奖牌榜的情况，现在我们假设奖牌榜的排名规则如下：
1、首先 gold medal 数量多的排在前面；
2、其次 silver medal 数量多的排在前面；
3、然后 bronzemedal 数量多的排在前面；
4、若以上三个条件仍无法区分名次，则以国家名称的字典序排定。
**输入描述：**
第一行输入一个整数 N(0<N<21)，代表国家数量;然后接下来的 N 行，每行包含一个字符串 Namei 表示每个国家的名称，和三个整数 Gi、 Si、
Bi 表示每个获得的 gold medal、
silver medal、 bronze medal 的数量，以空格隔开，如(China 51 20 21)，具体见样例输入。

**输出描述：**
输出奖牌榜的依次顺序，只输出国家名称，各占一行，具体见样例输出。

示例 1：
输入：
输出： China American Japan

输入：
    3
    China 51 20 21
    American 50 1 1
    Japan 0 0 0
  *

  输出：
    China
    American
    Japan
*
#
 */
public class OlympicGames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<Country> list = new ArrayList<>();
        for(int i = 0;i < num;i++){
            String[] s = sc.nextLine().split(" ");
            Country country = new Country();
            country.name = s[0];
            country.gold = Integer.parseInt(s[1]);
            country.sliver = Integer.parseInt(s[2]);
            country.bronze = Integer.parseInt(s[3]);
            list.add(country);
        }
        list.sort((o1,o2) -> {
            if(o1.gold == o2.gold && o1.sliver != o2.sliver){
                return o2.sliver - o1.sliver;
            }
            if(o1.gold == o2.gold && o1.sliver == o2.sliver){
                return o2.bronze - o1.bronze;
            }
            return o2.gold - o1.gold;
        });
        for (Country country : list){
            System.out.println(country.name);
        }
    }
}

class Country{
    String name;
    int gold;
    int sliver;
    int bronze;
}
