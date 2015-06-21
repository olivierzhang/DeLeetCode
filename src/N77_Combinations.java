import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */

public class N77_Combinations {

    private static List<List<Integer>> gen(int n, int k) {
        List<List<Integer>> tmpResult;
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0) return result;
        int count = 1;
        for (int i = 1; i <= n; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            result.add(tmp);
        }
        while (count < k) {
            tmpResult = new ArrayList<>(result);
            result = new ArrayList<>();
            count++;
            for (List<Integer> sorted : tmpResult) {
                if (sorted.get(sorted.size() - 1) + 1 > n) continue;
                List<List<Integer>> result2 = new ArrayList<>();
                for (int i = sorted.get(sorted.size() - 1) + 1; i <= n; i++) {
                    List<Integer> tmp = new ArrayList<>(sorted);
                    tmp.add(i);
                    result2.add(tmp);
                }
                result.addAll(result2);
            }
        }
        return result;
    }
}
