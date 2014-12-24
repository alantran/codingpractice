/*
* Suman Shakya
* Quick sort algorithm implementaion
* 12-23-2014
*/

public class QuickSort{
    public static void main(String[] args){
        int[] array = {5, 3, 1, 9, 6, 4, 12, 15, 10};
        printArray(array);
        sort(array, 0, array.length - 1);
        printArray(array);
    }
    
    public static void sort(int[] array, int l, int r){
        if(l < r){
            int q = partition(array, l, r);
            sort(array,l,q-1);
            sort(array,q+1,r);
        }
    }
    
    // creates partition of given array and returns the pivot index
    public static int partition(int[] array, int l, int r){
        int left = l + 1;
        int right = r;
        int pivot = l;
        while(left <= right){
            while(array[left] < array[pivot]) left++;
            while(array[right] > array[pivot]) right--;
            if(left < right){
                swap(array, left, right);
            }
        }
        swap(array,pivot,right);
        return right;
    }
    
    // swaps elements at index i and j of given array
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // prints the elements of an array
    private static void printArray(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println(array[array.length - 1]);
    }
}