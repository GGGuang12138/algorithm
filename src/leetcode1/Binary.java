package leetcode;

/**
 * 5511
 * Creat by GG
 * Date on 2020/9/13  10:34 上午
 */
public class Binary {
    /**
     * 暴力遍历O(n^3)
     * @param mat
     * @return
     */
    public static int numSpecial(int[][] mat) {
        int count = 0;
        for(int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length;j++){
                if (mat[i][j] == 1){
                    int ischange = 0;
                    for (int p = 0; p < mat[i].length; p++){
                        if (mat[i][p] == 1 && p!= j) {
                            ischange = 1;
                            break;
                        }
                    }
                    for (int p = 0;p < mat.length;p++){
                        if (mat[p][j] == 1 && p!=j) {
                            ischange = 1;
                            break;
                        }
                    }
                    if (ischange == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 暴力优化，两次遍历每汉每列为1进行统计
     * 查看结果
     * @param mat
     * @return
     */
    public static int numSpecial2(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] rows = new int[n],cols = new int[m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                rows[i] += mat[i][j];
                cols[j] += mat[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            if (rows[i] != 1) continue;
            for (int j = 0; j < m; j++){
                if (cols[j] != 1) continue;
                    if(mat[i][j] == 1){
                        ans++;
                        break;
                    }
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        int i = numSpecial2(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}});
        System.out.println(i);
    }
}
