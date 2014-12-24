/*
* Suman Shakya
* Insertion sort algorithm implementaion
* 12-23-2014
*/

public class InsertionSort{

    public static void main(String[] args){
        int[] array = {5, 3, 1, 9, 6, 4, 12, 15, 10};
        printArray(array);
        sort(array);
        //recursiveSort(array, array.length);
        printArray(array);
    }
    
    // iterative implementation of insertion sort
    public static void sort(int[] array){
        for(int j = 1; j < array.length; j++){
            int key = array[j];
            int i = j - 1;
            while(i >= 0 && array[i] > key){
                array[i+1] = array[i];
                i = i - 1;
            }
            array[i+1] = key;
        }
    }
    
    // recursive implementation of insertion sort
    public static void recursiveSort(int[] array, int n){
        if (n == 1)
            return;
        recursiveSort(array, n-1);
        int key = array[n-1];
        int i = n - 2;
        while(i >= 0 && array[i] > key){
            array[i + 1] = array[i];
            i = i - 1;
        }
        array[i+1] = key;
    }
    
    // prints the elements of an array
    private static void printArray(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println(array[array.length -1]);
    }
    
}