package level_2.ion_flux_relabeling;

import java.util.Arrays;

public class solution {

    public static void main(String[] args) {
        testRun(3, new int[]{7, 3, 5, 1}, new int[]{-1, 7, 6, 3});
        testRun(5, new int[]{19, 14, 28}, new int[]{21, 15, 29});
    }

    private static void testRun(int height, int[] input, int[] output) {
        int[] ans = answer(height, input);
        System.out.printf("Input height %d and nodes %s:\n%s\n%s\n", height, Arrays.toString(input),
                Arrays.toString(ans), Arrays.toString(output));
    }

    public static final int[] answer(int h, int[] q) {
        int head = (int) Math.pow(2, h) - 1;
        int[] result = new int[q.length];

        for (int i = 0; i < q.length; i++) {
            if (q[i] < head && q[i] >= 1)
                result[i] = locate(head, q[i], head - 1);
            else
                result[i] = -1;
        }

        return result;
    }

    public static int locate(int head, int target, int under) {

        under /= 2;
        int right = head - 1;            // right = head - 1
        int left = head - 1 - under--; // left = head - 1 - under/2

        if (right == target || left == target)
            return head;
        else {
            if (target <= left)
                return locate(left, target, under);
            else
                return locate(right, target, under);
        }
    }

}
