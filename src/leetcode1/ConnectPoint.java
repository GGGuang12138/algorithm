package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Creat by GG
 * Date on 2020/9/13  11:11 上午
 */
public class ConnectPoint {
    public int minCostConnectPoints(int[][] points) {
        return helper(points,1,0);
    }
    public int helper(int[][] points, int curr, int sum){
        if (curr == points.length){
            return sum;
        }
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i < curr;i++){
            dis = Math.max(Math.abs(points[curr][0] - points[i][0])
                    + Math.abs(points[curr][1] - points[i][1]),dis);
        }
        helper(points,curr+1,sum+dis);
        return sum+dis;
    }
}
