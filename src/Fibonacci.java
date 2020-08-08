/**
 * Creat by GG
 * Date on 2020/8/5  10:38 上午
 */
public class Fibonacci {

    /**
     * 傻递归recursion
     * 时间O(2^n)
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N < 2) return N;
        return fib(N-1) + fib(N-2);
    }

    /**
     * 迭代
     * O(n)
     * @param N
     * @return
     */
    public int fib2(int N) {
        if (N < 2) return N;
        int a = 0, b = 1, temp;
        for (int i = 1; i < N; i++){  //等于 while（ N-- > 1 ）
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * 优化递归
     */
    int[] cache = new int[31];
    public int fib3(int N) {
        if (N < 2) return N;
        if (cache[N] != 0) {
            return cache[N];
        } else {
            return cache[N] = fib3(N - 1) + fib3(N - 2);
        }
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib(3));

    }

}






