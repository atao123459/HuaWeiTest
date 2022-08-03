import java.util.*;

/*
2022.8.2

小华和小为是很要好的朋友，他们约定周末一起吃饭。

通过手机交流，他们在地图上选择了多个聚餐地点（由于自然地形等原因，部分聚餐地点不可达），求小华和小为都能到达的聚餐地点有多少个？

输入描述

第一行输入m和n，m代表地图的长度，n代表地图的宽度。

第二行开始具体输入地图信息，地图信息包含：

0 为通畅的道路

1 为障碍物（且仅1为障碍物）

2 为小华或者小为，地图中必定有且仅有2个 （非障碍物）

3 为被选中的聚餐地点（非障碍物）

输出描述

可以被两方都到达的聚餐地点数量，行末无空格。

示例1  输入输出示例仅供调试，后台判题数据一般不包含示例

输入

4 4

2 1 0 3

0 1 2 1

0 3 0 0

0 0 0 0

输出

2

说明

第一行输入地图的长宽为3和4。

第二行开始为具体的地图，其中：3代表小华和小明选择的聚餐地点；2代表小华或者小明（确保有2个）；0代表可以通行的位置；1代表不可以通行的位置。

此时两者能都能到达的聚餐位置有2处。

示例2  输入输出示例仅供调试，后台判题数据一般不包含示例

输入

4 4

2 1 2 3

0 1 0 0

0 1 0 0

0 1 0 0

输出

0

说明

第一行输入地图的长宽为4和4。

第二行开始为具体的地图，其中：3代表小华和小明选择的聚餐地点；2代表小华或者小明（确保有2个）；0代表可以通行的位置；1代表不可以通行的位置。

由于图中小华和小为之间有个阻隔，此时，没有两人都能到达的聚餐地址，故而返回0。

备注:

地图的长宽为m和n，其中：

4 <= m <= 100

4 <= n <= 100

聚餐的地点数量为 k，则

1< k <= 100


 */
public class HappyWeekend {
    static Map<String,Integer> map1 = new HashMap<>(),map2 = new HashMap<>();
    static int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] maze = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    maze[i][j] = sc.nextInt();
                }
            }
            int count = 0;
            int[] pos = new int[4];
            for (int i = 0,k = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (maze[i][j] == 2) {
                        pos[k++] = i;
                        pos[k--] = j;
                    }
                }
            }
            infect(map1,pos[0],pos[1],m,n,maze);
            infect(map2,pos[2],pos[3],m,n,maze);
            if(map1.size() == 0 || map2.size() == 0){
                System.out.println(0);
            }else {
                for(Map.Entry<String,Integer> entry : map1.entrySet()){
                    String key = entry.getKey();
                    if(map2.containsKey(key)){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void infect(Map<String,Integer> map, int i, int j,int m,int n,int[][] maze) {
        if(maze[i][j] == 3){
            String key = i + "+" + j;
            map.put(key,map.getOrDefault(map.get(key) ,0) + 1);
            return;
        }
        int k = maze[i][j];
        maze[i][j] = -1;
        for(int c = 0;c < 4;c++){
            int a = dx[c] + i;
            int b = dy[c] + j;
            if(a >= 0 && b >= 0 && a < m && b < n && maze[a][b] != 1 && maze[a][b] != -1 && !map.containsKey(a + "+" + b)){
                infect(map,a,b,m,n,maze);
            }
        }
        maze[i][j] = k;
    }
}
