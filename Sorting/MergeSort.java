/*
* Suman Shakya
* Merge sort algorithm implementaion
* 12-23-2014
*/

public class MergeSort{
    public static void main(String[] args){
        int[] array = {5, 3, 1, 9, 6, 4, 12, 15, 10};
        printArray(array);
        sort(array, 0, array.length - 1);
        printArray(array);
    }
    
    public static void sort(int[] array, int l, int r){
        if(l < r){
            int m = (l + r)/2;
            sort(array,l,m);
            sort(array,m+1,r);
            merge(array, l, m, r);
        }
    }
    
    // merge procedure
    public static void merge(int[] array, int l, int m, int r){
        int left = l;
        int right = m + 1;
        int k = l;
        int[] B = new int[array.length];
        
        while(left <= m && right <= r){
            if(array[left] < array[right])
                B[k++] = array[left++];
            else
                B[k++] = array[right++];
        }
        
        while(left<=m)
            B[k++] = array[left++];
        
        while(right <= r)
            B[k++] = array[right++];
        
        for(int i = l; i <= r; i++){
            array[i] = B[i];
        }
    }
    
    // prints the elements of an array
    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}