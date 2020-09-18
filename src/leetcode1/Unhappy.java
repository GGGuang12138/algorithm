package leetcode;

import java.util.HashMap;
import java.util.Set;

/**
 * 逻辑较复杂的题，可以先手写思路，将一些步骤作为方法提出出来，方便逻辑的梳理
 * Creat by GG
 * Date on 2020/9/13  10:57 上午
 */

public class Unhappy {
    /**
     * 按照逻辑写即可
     * 用HashMap保存每个pair，方便取值对比
     * @param n
     * @param preferences
     * @param pairs
     * @return
     */
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        HashMap<Integer,Integer> map0 = new HashMap<>();
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for (int[] pair : pairs){
            map0.put(pair[0],pair[1]);
            map1.put(pair[1],pair[0]);
        }

        int ans = 0;
        for (int i = 0;i < n; i++){
            int friend = getFriend(map0,map1,i);//y
            // 查找匹配朋友的亲密度排行
            int l = searchLevel(preferences, i, friend);//x中y的亲密度
            if (l == 0){
                continue;
            }else {
                // 存在 xu胜过xy
                for (int u = 0; u < l; u++){
                    int friendU = preferences[i][u];//u
                    int uFriend = getFriend(map0,map1,friendU);//v
                    int xLevel = searchLevel(preferences,friendU,i); // u中x的亲密度
                    int vLevel = searchLevel(preferences,friendU,uFriend);//u中v的亲密度
                    //存在 ux胜与uv 不开心
                    if (xLevel < vLevel){
                        ans ++;
                        break;
                    }
                }
            }

        }
        return ans;
    }

    /**
     * 查找i中friend的亲密度
     * @param preferences
     * @param i
     * @param friend
     * @return
     */
    public int searchLevel(int[][] preferences, int i, int friend) {
        int l = -1;
        for (int j = 0;j < preferences[i].length; j++){
            if (preferences[i][j] == friend){
                l = j;
                break;
            }
        }
        return l;
    }

    /**
     * 获得配对的朋友数字
     * @param map0
     * @param map1
     * @param i
     * @return
     */
    private int getFriend(HashMap<Integer, Integer> map0, HashMap<Integer, Integer> map1,int i) {
        if (map0.containsKey(i)){
            return map0.get(i);
        }else{
            return map1.get(i);
        }
    }

}
