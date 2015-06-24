import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 *
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class N90_SubSets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        result.add(tmp);
        if (nums.length > 0) {
            List<Integer> tmp2 = new ArrayList<>(tmp);
            tmp2.add(nums[0]);
            result.add(tmp2);
        } else {
            return result;
        }
        int lastNum = nums[0];
        int dupCount = 1;
        for (int i = 1; i < nums.length; i++) {
            int n = result.size();
            if (nums[i] == lastNum) {
                dupCount++;
            } else {
                dupCount = 1;
            }
            for (int j = 0; j < n; j++) {
                tmp = new ArrayList<>(result.get(j));
                if (tmp.size() == 0 || (tmp.size() != 0 && tmp.get(tmp.size() - 1) != nums[i])) {
                    for (int c = 0; c < dupCount; c++) {
                        tmp.add(nums[i]);
                    }
                    result.add(new ArrayList<>(tmp));
                }
            }
            lastNum = nums[i];
        }
        return result;
    }
}
