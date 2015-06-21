import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 *
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class N78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        if (nums.length == 1) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(nums[0]);
            result.add(new ArrayList<Integer>());
            result.add(list1);
            return result;
        }
        int[] subRes1 = { nums[nums.length - 1] };
        int[] subRes2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            subRes2[i] = nums[i];
        }

        List<List<Integer>> result1 = subsets(subRes1);
        List<List<Integer>> result2 = subsets(subRes2);
        for (List<Integer> list1 : result1) {
            for (List<Integer> list2 : result2) {
                List<Integer> list3 = new ArrayList<>(list2);
                list3.addAll(list1);
                Collections.sort(list3);
                result.add(list3);
            }
        }
        return result;
    }

    //by: zjuzhanxf
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        result.add(tmp); // add empty set
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int n = result.size();
            for (int j = 0; j < n; j++) {
                // NOTE: must create a new tmp object, and add element to it.
                tmp = new ArrayList<Integer>(result.get(j));
                tmp.add(nums[i]);
                result.add(new ArrayList<Integer>(tmp));
            }
        }
        return result;
    }
}
