package leetcode;

/**
 * 速算机器人
 * Creat by GG
 * Date on 2020/9/12  3:06 下午
 */
public class Calculate {
    public static int calculate(String s) {
        int x = 1, y = 0;
        char[] str = s.toCharArray();
        for (char c: str){
            if (c == 'A') x = 2*x + y;
            else if (c == 'B') y = 2*y +x;
        }
        return x + y;
    }

    public static void main(String[] args) {
        System.out.println(calculate(""));
    }
}
