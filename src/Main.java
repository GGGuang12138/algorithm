import sort.Sort;

/**
 * Creat by GG
 * Date on 2020/7/22  7:27 下午
 */
public class Main {
    public static void main(String[] args){
        Sort s = new Sort();
        int[] data = {1,3,1,3, 2, 5,6,7,8};
        int[] res = s.radixSort(data);
        int count = 1;
        for (int i : res){
            System.out.println(i+"            "+count++);
        }

    }


}
