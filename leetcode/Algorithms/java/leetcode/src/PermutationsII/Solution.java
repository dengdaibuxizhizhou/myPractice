package PermutationsII;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        trackback(res, nums, used, len, path);

        return res;
    }

    private void trackback(List<List<Integer>> res, int[] nums, boolean[] used, int len, Stack<Integer> path) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            if (!used[i]) {
                path.push(nums[i]);
                used[i] = true;
                trackback(res, nums, used, len, path);
                path.pop();
                used[i] = false;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 1};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res.toString());
    }
}
