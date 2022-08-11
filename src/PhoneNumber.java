import java.util.*;

/*
力扣379
 */
public class PhoneNumber {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory(3);
        phoneDirectory.get();
        int num1 = phoneDirectory.get();
        boolean res = phoneDirectory.check(2);
        int num2 = phoneDirectory.get();
        boolean res2 = phoneDirectory.check(2);
        phoneDirectory.release(2);
        boolean res3 = phoneDirectory.check(2);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
    }
}

class PhoneDirectory {
    List<Boolean> list = new ArrayList<>();

    public PhoneDirectory(int n){
        for(int i = 0;i < n;i++){
            list.add(true);
        }
    }

    public int get(){
        for(int i = 0;i < list.size();i++){
            if(list.get(i)){
                list.set(i,false);
                return i;
            }
        }
        return -1;
    }

    public boolean check(int num){
        return list.get(num);
    }

    public void release(int num){
        list.set(num,true);
    }
}
