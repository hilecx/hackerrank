
import java.util.*;

public class Anagrams {

//    static boolean isAnagram(String a, String b) {
//        // Complete the function
//        if(a.length() != b.length()){
//            return false;
//        }
//
//        char[] ca = a.toLowerCase().toCharArray();
//        char[] cb = b.toLowerCase().toCharArray();
//        System.out.println(Arrays.toString(ca));
//        System.out.println(Arrays.toString(cb));
//        Map<Character,Integer> mapa = new TreeMap<>();
//        Map<Character,Integer> mapb = new TreeMap<>();
//        for (int i = 0; i < a.length(); i++) {
//            addMapValue(mapa,ca[i]);
//            addMapValue(mapb,cb[i]);
//        }
//        System.out.println("--------");
//        System.out.println(Arrays.toString(mapa.keySet().toArray()));
//        System.out.println(Arrays.toString(mapb.keySet().toArray()));
//        for(Character c : mapa.keySet()){
//            if(mapa.get(c) != mapb.get(c)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    static void addMapValue(Map<Character,Integer> map, Character key){
//        Integer value = map.get(key);
//        if(value == null){
//            value = 0;
//        }
//        {
//            value++;
//        }
//        map.put(key,value);
//    }

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if(a.length() != b.length()){
            return false;
        }

        char[] ca = Anagrams.quickSort1(a.toLowerCase().toCharArray(),0,a.length()-1);
        char[] cb = Anagrams.quickSort1(b.toLowerCase().toCharArray(),0,b.length()-1);
        System.out.println(Arrays.toString(ca));
        System.out.println(Arrays.toString(cb));
        for (int i = 0; i < a.length(); i++) {
            if(ca[i] != cb[i]){
                return false;
            }
        }
        return true;
    }

//    static char[] quickSort(char[] chars, int begin, int end){
//        System.out.println("input "+Arrays.toString(chars)+" "+begin+" "+end);
//        if(chars.length<2 || end-begin<=1){
//            return chars;
//        }else{
//            int pivotIndex = begin;
//            char pivot = chars[pivotIndex];
//            System.out.println("pivot:"+" "+pivot);
//            for (int i = begin; i < end; i++) {
//                System.out.println("loop "+i);
//                if(chars[i] < pivot && i>pivotIndex){
//                    System.out.println("swap"+i+" "+pivotIndex);
//                    char tmp = chars[pivotIndex];
//                    chars[pivotIndex]=chars[i];
//                    chars[i]=tmp;
//                    pivotIndex = i;
//                }
//                if(chars[i] > pivot && i<pivotIndex){
//                    System.out.println("swap"+i+" "+pivotIndex);
//                    char tmp = chars[pivotIndex];
//                    chars[pivotIndex]=chars[i];
//                    chars[i]=tmp;
//                    pivotIndex = i;
//                }
//                System.out.println(Arrays.toString(chars)+" start ");
//            }
//            chars = quickSort(chars,begin,pivotIndex+1);
//            System.out.println(Arrays.toString(chars)+"  less "+ pivotIndex);
//            chars = quickSort(chars,pivotIndex+1,end);
//            System.out.println(Arrays.toString(chars)+"  more "+ pivotIndex);
//            return chars;
//        }
//
//    }

    static char[] quickSort1(char[] array, int start, int end) {
        // i相当于助手1的位置，j相当于助手2的位置
        int i = start, j = end;
        char pivot = array[i]; // 取第1个元素为基准元素
        int emptyIndex = i; // 表示空位的位置索引，默认为被取出的基准元素的位置
        // 如果需要排序的元素个数不止1个，就进入快速排序(只要i和j不同，就表明至少有2个数组元素需要排序)
        while (i < j) {
            // 助手2开始从右向左一个个地查找小于基准元素的元素
            while (i < j && pivot <= array[j])
                j--;
            if (i < j) {
                // 如果助手2在遇到助手1之前就找到了对应的元素，就将该元素给助手1的"空位"，j成了空位
                array[emptyIndex] = array[emptyIndex = j];
            }

            // 助手1开始从左向右一个个地查找大于基准元素的元素
            while (i < j && array[i] <= pivot)
                i++;
            if (i < j) {
                // 如果助手1在遇到助手2之前就找到了对应的元素，就将该元素给助手2的"空位"，i成了空位
                array[emptyIndex] = array[emptyIndex = i];
            }
        }
        // 助手1和助手2相遇后会停止循环，将最初取出的基准值给最后的空位
        array[emptyIndex] = pivot;

        // =====本轮快速排序完成=====

        // 如果分割点i左侧有2个以上的元素，递归调用继续对其进行快速排序
        if (i - start > 1) {
            quickSort1(array, 0, i - 1);
        }
        // 如果分割点j右侧有2个以上的元素，递归调用继续对其进行快速排序
        if (end - j > 1) {
            quickSort1(array, j + 1, end);
        }
        return array;
    }

    public static void main(String[] args) {
//        anagram
//        char[] chars = "margana".toCharArray();
//        System.out.println(Arrays.toString(chars));
//        chars = Anagrams.quickSort1(chars,0,chars.length-1);
//        System.out.println(Arrays.toString(chars));

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
