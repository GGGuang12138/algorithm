import sort.Sort;
import sort.Sort1;

/**
 * Creat by GG
 * Date on 2020/7/22  7:27 下午
 */
public class Main {
    public static void main(String[] args){
        Sort1 s = new Sort1();
        int[] data = {5,1,1,2,0,0};
        int[] arr = s.quickSort(data);
        for (int i= 0; i<data.length; i++){
            System.out.println(arr[i]);
        }

    }


}
