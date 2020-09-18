package leetcode;

import java.util.Arrays;

import static java.util.Arrays.binarySearch;

/**
 * 早餐组合
 * Creat by GG
 * Date on 2020/9/12  3:16 下午
 */
public class Breakfast {

    /**
     * 双指针法
     * @param staple
     * @param drinks
     * @param x
     * @return
     */
    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(drinks);
        Arrays.sort(staple);
        int ans = 0;
        int i = 0, j = drinks.length-1;
        while (i < staple.length && j >= 0){
            int s = staple[i], d = drinks[j];
            if (s >= x) {
                i ++;
                continue;
            }
            if (d >= x){
                j --;
                continue;
            }
            if (s + d <= x){
                ans = (ans+j+1)%1000000007;
                i ++;
            }else{
                j --; //过大，j向左移，和才会减小
            }
        }

        return ans%1000000007;
    }

    /**
     * 二分法
     * @param staple
     * @param drinks
     * @param x
     * @return
     */
    public static int breakfastNumber2(int[] staple, int[] drinks, int x){
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int ans = 0;
        for (int i = 0; i < staple.length; i++){
            int temp = x - staple[i];
            int idx = searchHelper(drinks,temp);
            if (idx == 0) break; // drinks遍历到最小值，价格已经超过x
            ans = (ans+idx)%1000000007;
        }
        return ans%1000000007;
    }

    /**
     * 二分查找，找到大于target的最小值
     * @param nums
     * @param target
     * @return
     */
    private static int searchHelper(int[] nums, int target) {
        int i = 0,j = nums.length;
        while(i <j){
            int mid = i+(j-i)/2;
            if (nums[mid] > target){
                j = mid;
            }else{
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(breakfastNumber2(new int[]{2,1,1},new int[]{8,9,5,1},9));
        System.out.println(searchHelper(new int[]{1,2,2,3,4,5,6,},2));

    }
}
