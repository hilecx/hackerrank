package quicksort;

import java.util.Arrays;

public class Test01 {
    public void quickSort(int array[], int top, int tail) {
        if (top >= tail) {
            return;
        }
        int left = top, right = tail;
        int temp = array[left];// 数组的第一作为中轴
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];// 比中轴小的记录移动到低端
            if(left!=right){
                System.out.println("1");
            }
            while (left < right && array[left] < temp) {
                left++;
            }
            array[right] = array[left];
            if(left!=right){
                System.out.println("2");
            }
        }
        if (left == right) {
            array[left] = temp;
        }
        if (left != top) {
            quickSort(array, 0, left - 1);
        }
        if (right != tail) {
            quickSort(array, right + 1, array.length - 1);
        }
        System.out.println(Arrays.toString(array));
    }


    public void quickSort2(int a[], int top, int tail) {
        int p = a[top];
        int i=top;
        int j=tail;
        while(i<j){
            System.out.println(Arrays.toString(a));
            while (a[j] >= p && i<j){
                j--;
            }
            a[i]=a[j];
            while (a[i]<=p && i<j){
                i++;
            }
            a[j]=a[i];
            if(i==j){
                a[i]=p;
            }
        }
        if(i-top>=2){
            quickSort2(a,top,i-1);
            quickSort2(a,i+1,tail);
        }
        if(tail-i>=2){
            quickSort2(a,i+1,tail);
            quickSort2(a,top,i-1);
        }
    }
    public static void main(String[] args) {
        int a[] = new int[]{1, 3, 5, 2, 4, 6, 7};
//        int a[] = new int[]{3, 1, 5, 2, 4, 9, 7};
        new Test01().quickSort(a,0,6);
        System.out.println(Arrays.toString(a));
    }
}
