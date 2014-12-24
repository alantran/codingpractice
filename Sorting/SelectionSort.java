/*
* Suman Shakya
* Selection sort algorithm implementaion
* 12-23-2014
*/

public class SelectionSort{
    public static void main(String[] args){
        int[] array = {5, 3, 1, 9, 6, 4, 12, 15, 10};
        printArray(array);
        sort(array);
        printArray(array);
    }
    
    public static void sort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int small = smallest(array,i);
            if (i != small)
                swap(array, i, small);
        }
    }
    
    // finds the index of smallest element in array
    public static int smallest(int[] array, int index){
        int smallest = index;
        for(int i = index + 1; i < array.length; i++){
            if (array[i] < array[smallest]){
                smallest = i;
            }
        }
        return smallest;
    }
    
    // swaps two elements at indices i and j of given array
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // prints the elements of an array
    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}