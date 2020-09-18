package leetcode;

/**
 * 秋叶收藏集
 * Creat by GG
 * Date on 2020/9/12  3:50 下午
 */
public class Leaves {
    public int minimumOperations(String leaves) {
        int count = 0;
        if (leaves.startsWith("y")) {
            leaves.replaceFirst(leaves.charAt(0)+"","r");
            count++;
        }
        if (leaves.endsWith("y")){
            leaves = leaves.substring(0,leaves.length()-1)+"r";
            count++;
        }
        int isChangeLeft = 0;
        int isChangeRight = 0;
        for (int i = 1;i < leaves.length()-1;i++){
            char left = leaves.charAt(i);
            char right = leaves.charAt(leaves.length()-1-i);
            if (left == 'y' && isChangeLeft == 0){
                isChangeLeft = 1;
            }
            if (isChangeLeft == 1 ){

            }



        }
        return 0;
    }
}
