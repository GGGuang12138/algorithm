package netease;
import java.util.Scanner;

/**
 * 牛客地址：https://www.nowcoder.com/discuss/470914?type=1&order=7&pos=7&page=2&channel=1013&source_id=discuss_center_1
 * Creat by GG
 * Date on 2020/8/8  3:25 下午
 */
public class Test {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < len; i++){
            int n = sc.nextInt();
            ans += helper(n);
        }
        System.out.println(ans);

    }
    public static int helper(int n){
        int flag;
        if (n <= 1) return  0;
        else if (n <= 3 ) return 1;
        else {
            return n/2;
        }
    }

}
