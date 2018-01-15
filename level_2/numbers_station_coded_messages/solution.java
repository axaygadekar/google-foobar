package level_2.numbers_station_coded_messages;

public class solution {
    public static void main(String[] args) {
        int[] temp = {4, 3, 10, 2, 8};
        int[] ans = answer(temp, 12);
        System.out.println(ans.length);
    }
    public static int[] answer(int[] l, int t) {
        int[] ans = {-1, -1};
        int sum;
        for (int i = 0; i < l.length; i++) {
            sum = 0;
            for (int j = i; j < l.length; j++) {
                sum += l[j];
                if (sum > t) break;
                if (sum == t) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}