
import java.util.ArrayList;
import java.util.List;

public class N89_GrayCode {


    //todo: not correct
    public static void main(String[] args) {
        grayCode(2);
    }

    public static List<Integer> grayCode(int n) {
        int sumCount = (int) Math.pow(2, n);
        List<Integer> list = new ArrayList<>(n);
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int diff = (int) Math.pow(2, i);
            list.add(diff);
            list.add(0 - diff);
        }
        int lastNum = 0;

        while (result.size() != sumCount) {
            for (int i = 0; i < list.size(); i++) {
                int newNum = lastNum + list.get(i);
                if(newNum <= 0 || newNum > (int)Math.pow(2, n)){
                    continue;
                }
                if (!result.contains(newNum) && isLegal(newNum, lastNum)) {
                    result.add(newNum);
                    lastNum = newNum;
                    break;
                } else {
                    if (i == list.size() - 1) {
                        result.remove(result.size() - 1);
                        lastNum = result.get(result.size() - 1);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isLegal(int newNum, int lastNum) {
        int diff = newNum ^ lastNum;
        return (diff & (diff - 1)) == 0 ? true : false;
    }
}