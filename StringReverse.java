public class StringReverse{

     public static void main(String []args){
        System.out.println("Hello World");
        String str = "suman";
    
        System.out.println(reverse(str));
     }
     
     public static String reverse(String str){
        char []array = str.toCharArray();
        int l = 0;
        int r = array.length - 1;
        while(l <=r){
            swap(array,l++,r--);
        }
        return String.valueOf(array);
     }
     
     public static void swap(char[] array, int i, int j){
         char temp = array[i];
         array[i] = array[j];
         array[j] = temp;
     }
}