
/*
快速排序partition实现
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{11,24,5,32,50,34,54,76};
        quickSort(arr,0,arr.length - 1);
        System.out.println("结果:");
        for (int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr,int index1,int index2){
        if(index1 > index2){
            return;
        }
        int p = partition(arr,index1,index2);
        quickSort(arr,index1,p - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        quickSort(arr,p + 1,index2);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int partition(int[] arr,int index1,int index2){
        while(index1 < index2){
            while(index1 < index2){
                if(arr[index1] < arr[index2]){
                    index1++;
                }else {
                    swap(arr,index1,index2);
                    index2--;
                    break;
                }
            }

            while(index1 < index2){
                if(arr[index1] < arr[index2]){
                    index2--;
                }else {
                    swap(arr,index1,index2);
                    index1++;
                    break;
                }
            }
        }
        return index1;
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
