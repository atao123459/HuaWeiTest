import java.util.Scanner;

public class Picnic {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0;j < m; j++){
                maze[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for(int j = 0;j < m; j++){
                if(maze[i][j] == 2){
                    infect(maze,i,j,n,m);
                }
            }
        }
        System.out.println(count);
    }

    public static void infect(int[][] maze,int i,int j,int n,int m){
        if(i < 0 || j < 0 || i >= n || j >= m || maze[i][j] == 1){
            return;
        }
        if(maze[i][j] == 0){
            maze[i][j] = 1;
        }
        if(maze[i][j] == 3){
            count++;
            maze[i][j] = 4;
        }
        infect(maze,i + 1,j,n,m);
        infect(maze,i - 1,j,n,m);
        infect(maze,i,j + 1,n,m);
        infect(maze,i,j - 1,n,m);
    }
}
