package netease;

import java.util.Scanner;

/**
 * 牛客链接：https://www.nowcoder.com/questionTerminal/e3a4a6f88e8b4b6ba20c4e25215b897b
 * 参考博客：https://blog.csdn.net/qq_40918495/article/details/107044409
 * int、String、Integer之间的转换：
 * String -> int        Integer.parseInt(str)
 * int -> String        String.valueOf(int)
 *
 * Integer -> String    String.valueOf(Integer)
 * String -> Integer    Integer.valueOf(str)
 *
 * int -> Integer       Integer.valueOf(int) 包装类装箱
 * Integer -> int       Integer.intValue()  包装类拆箱
 *
 * char 0～65535
 * short类型范围：负2的15次方～2的15次方-1（-32768～32767）3万多
 * int类型范围：负2的31次方～2的31次方-1（-2147483648～2147 483 647）10位数 21亿
 * long类型范围 负2的63次方～2的63次方-1（-9223372036854775808 ～ 9 223 372 036 854 775 807）19位数
 * * Creat by GG
 * Date on 2020/8/7  4:44 下午
 */
public class Doubled {
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine(); //跳过int所在的那一行
        for (int i = 0; i < count; i++){
            String[] str = scanner.nextLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int p = Integer.parseInt(str[2]);
            int q = Integer.parseInt(str[3]);
            System.out.println(helper(a,b,p,q,0));
        }
    }
    public static int helper(long a, long b, long p, long q,int num){
        while(a+p < b){
            p*=q;
            num+=1;
        }
        return num+1;

    }

}

