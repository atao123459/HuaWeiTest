import java.util.*;

public class StreetLight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            int[] lights = new int[num];
            for(int i = 0;i < num;i++){
                lights[i] = sc.nextInt();
            }
            int index = 0,length = 0;
            while(index < lights.length - 1){
                boolean jump = false;

                if(lights[index] + lights[index + 1] >= 100){//照明范围出现重叠，不计算
                    index++;
                    continue;
                }

                int leftLight = lights[index];
                int rightLight = lights[index + 1];

                int left = index - 1;
                while(left >= 0){
                    if (lights[left] <= 100){
                        left--;
                        continue;
                    }

                    int n = lights[left] % 100;
                    if(n >= index - left){
                        if(n >= index - left + 1){
                            index += n - (index - left);
                            jump = true;
                            break;
                        }

                        int l = lights[left] - (index - left) * 100;
                        if(l > leftLight){
                            leftLight = l;
                        }
                    }
                }//左循环

                if(jump){
                    continue;
                }

                if(leftLight + lights[index + 1] >= 100){
                    index++;
                    continue;
                }

                int right = index + 2;
                while(right < num){
                    if(lights[right] <= 100){
                        right++;
                        continue;
                    }

                    int n = lights[right] % 100;
                    if(n >= right - (index + 1)){
                        if(n >= right - (index + 1) + 1){
                            index += 2 * n;
                            jump = true;
                            break;
                        }

                        int r = lights[right] - (right - (index + 1)) * 100;
                        if(r > rightLight){
                            rightLight = r;
                        }
                    }
                }//右循环

                if(jump){
                    continue;
                }

                if(leftLight + rightLight >= 100){
                    index++;
                    continue;
                }

                length += 100 - leftLight - rightLight;
                index++;
            }
            System.out.println(length);
        }
    }
}
