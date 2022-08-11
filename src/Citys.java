import java.util.*;

public class Citys {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n - 1; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        // 并查集
        int res = Integer.MAX_VALUE;  // 统计最小聚集度
        int[] maxArray = new int[n + 1];  // 统计每个城市的聚集度
        for (int i = 1; i <= n; i++) {  // 对于每一个城市
            City city = new City(n);
            for (int j = 0; j < n - 1; j++) {  // 判断每一条路径
                if (arr[j][0] == i || arr[j][1] == i)  {//遇到需要排除的城市
                    continue;
                } else {
                    city.union(arr[j][0], arr[j][1]);
                }
            }
            maxArray[i] = city.getMax();  // 每个城市对应的聚集度
            res = Math.min(res, maxArray[i]);  // 切掉路径后的最小聚集度
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < maxArray.length; i++) {
            //每个城市的聚集度等于最小值的时候就是符合要求的答案
            if (maxArray[i] == res) {
                sb.append(i).append(" ");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}

class City {  // 路径压缩的加权quick-union算法模板
    int count;//连通分量
    int[] id;//结点索引
    int[] sz;//并查集

    public City (int n) {
        count = n;
        id = new int[n + 1];
        sz = new int[n + 1];
        for (int i = 1; i <= n; i++) {  // 这里需要注意，城市是从1开始的，因为城市编号从1开始
            id[i] = i;
            sz[i] = 1;
        }
    }

    //这题需要找出并查集中的最大值,也就是每个城市的聚集度
    public int getMax () {  // 统计并查集的最大值
        int max = 0;
        //通过遍历得到最大值，注意下标从1开始
        for (int i = 1; i < sz.length; i++) {
            max = Math.max(max, sz[i]);
        }
        return max;
    }

    //获取并查集的个数 通常情况下使用这个方法获取
//    public int getCount(){
//        return count;
//    }

    public void union (int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        //小树的根节点连接到大树上
        if (pRoot != qRoot) {
            if (sz[pRoot] < sz[qRoot]) {
                id[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            } else {
                id[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
            count--;
        }
    }

    private int find (int p) {
        if(p == id[p]){
            return p;
        }
        id[p] = find(id[p]);
        return id[p];
    }
}
