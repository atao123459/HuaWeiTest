
//力扣323无向图中连通分量的数量
public class ConnectComponents {
    public static void main(String[] args) {

    }

    public static int countComponents(int n,int[][] edges){
        UF uf = new UF(n);
        for(int[] edge : edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.getCount();
    }
}

class UF{
    int count;
    int[] id;
    int[] size;

    public UF(int n){
        count = n;
        id = new int[n];
        size = new int[n];
        for(int i = 0;i < n;i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    public int getCount(){
        return count;
    }

    //找到结点的根节点，这里使用了路径加权压缩，时间复杂度为O(1)
    public int find(int p){
        if(p == id[p]){
            return p;
        }
        id[p] = find(id[p]);
        return id[p];
    }

    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP != rootQ){
            if(size[rootP] < size[rootQ]){
                id[rootP] = id[rootQ];
                size[rootQ] += size[rootP];
            }else {
                id[rootQ] = id[rootP];
                size[rootP] += size[rootQ];
            }
        }
        count--;
    }
}
