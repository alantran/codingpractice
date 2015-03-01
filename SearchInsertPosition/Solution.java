public class Solution{
    public static void main(String[] args){
        int[] A = {1, 3, 5, 6};
        System.out.println(searchInsertPosition(A, 4));
        System.out.println(searchInsertPosition(A, 3));
        System.out.println(searchInsertPosition(A, 0));
        System.out.println(searchInsertPosition(A, 8));
    }
    public static int searchInsertPosition(int[] A, int target){
        return searchInsertPosition(A, target, 0, A.length - 1);
    }
    
    private static int searchInsertPosition(int[] A, int target, int start, int end){
        if(start == end){
            if(A[start] < target)
                return start + 1;
            else
                return start;
        }
        int mid = (start + end)/2;
        if(A[mid] == target)
            return mid;
        else if(start == mid && A[mid] > target)
            return start;
        else if(mid == end && A[mid] < target)
            return end + 1;
        else if(A[mid] > target)
            return searchInsertPosition(A, target, start, mid - 1);
        else 
            return searchInsertPosition(A, target, mid + 1, end);
    }
}