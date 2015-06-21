/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class N34_SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int[] found = { low, high };
        int[] notFound = { -1, -1 };
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid;
            } else if (nums[mid] == target) {
                int i = 0;
                while (mid - i - 1 >= 0 && nums[mid - i - 1] == target) {
                    i++;
                }
                found[0] = mid - i;
                i = 0;
                while (mid + i + 1 < nums.length && nums[mid + i + 1] == target) {
                    i++;
                }
                found[1] = mid + i;
                return found;
            }
        }

        if (high == low && nums[high] != target) {
            return notFound;
        }
        if (nums[high] == target && nums[low] == target) {
            return found;
        } else if (nums[high] == target) {
            found[0] = high;
        } else if (nums[low] == target) {
            found[1] = low;
        } else {
            return notFound;
        }
        return found;
    }
}

