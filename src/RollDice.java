import java.util.*;

/*
2022.8.1

【转骰子】

骰子是一个立方体，每个面一个数字，初始为左1，右2，前3(观察者方向)，后4，上5，下6，用123456表示这个状态，放置在平面上，

可以向左翻转(用L表示向左翻转1次)，

可以向右翻转(用R表示向右翻转1次)，

可以向前翻转(用F表示向前翻转1次)，

可以向后翻转(用B表示向后翻转1次)，

可以逆时针旋转(用A表示逆时针旋转90度)，

可以顺时针旋转(用C表示顺时针旋转90度)，

现从123456这个初始状态开始，根据输入的动作序列，计算得到最终的状态。

骰子的初始状态和初始状态转动后的状态如图所示。
 */
public class RollDice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            List<Integer> list = Arrays.asList(1,2,3,4,5,6);
            for(char c : str.toCharArray()){
                switch (c) {
                    case 'L' -> {
                        swap(list, 0, 5);
                        swap(list, 1, 4);
                        swap(list, 0, 1);
                    }
                    case 'R' -> {
                        swap(list, 0, 4);
                        swap(list, 1, 5);
                        swap(list, 0, 1);
                    }
                    case 'F' -> {
                        swap(list, 2, 5);
                        swap(list, 3, 4);
                        swap(list, 2, 3);
                    }
                    case 'B' -> {
                        swap(list, 3, 5);
                        swap(list, 2, 4);
                        swap(list, 2, 3);
                    }
                    case 'A' -> {
                        swap(list, 0, 3);
                        swap(list, 1, 2);
                        swap(list, 2, 3);
                    }
                    case 'C' -> {
                        swap(list, 0, 3);
                        swap(list, 1, 2);
                        swap(list, 0, 1);
                    }
                    default -> {
                    }
                }
            }
            System.out.println(list);
        }
    }

    public static void swap(List<Integer> list,int i,int j){
        Collections.swap(list,i,j);
    }
}
