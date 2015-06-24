import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used
 * and each combination should be a unique set of numbers.
 *
 * Ensure that numbers within the set are sorted in ascending order.
 *
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 *
 * Output:
 *
 * [[1,2,4]]
 *
 * Example 2:
 *
 * Input: k = 3, n = 9
 *
 * Output:
 *
 * [[1,2,6], [1,3,5], [2,3,4]]
 */
public class N216_CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        cal(k, n, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void cal(int k, int target, int last, List<Integer> list, List<List<Integer>> result) {
        if (k == 0 && target == 0) {
            result.add(list);
        } else if (k == 0 || target == 0) {
            return;
        }
        for (int i = last + 1; i < 10; i++) {
            if (i <= target) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i);
                cal(k - 1, target - i, i, newList, result);
            }
        }
    }
}
