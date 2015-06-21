/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 */
public class N80_RemoveDuplicateFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int lastNum = nums[0];
        int i = 1;
        int count = 1;
        int index = 1;
        while (i < nums.length) {
            if (nums[i] == lastNum) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[index] = nums[i];
                lastNum = nums[i];
                index++;
            }
            i++;
        }
        return index;
    }
}
