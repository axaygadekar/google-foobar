package level_3.find_the_access_codes;

public class solution {

    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4, 5, 6};
        System.out.println(answer2(temp));
    }

    public static int answer(int[] l) {

        int number = 0;

        for (int i1 = 0; i1 < l.length; i1++) {
            for (int i2 = i1 + 1; i2 < l.length; i2++) {
                if (l[i2] % l[i1] != 0) {
                    continue;
                }

                for (int i3 = i2 + 1; i3 < l.length; i3++) {
                    if ((l[i3] % l[i2] == 0)) {
                        number++;
                    }
                }
            }
        }

        return number;

    }

    public static int answer2(int[] l) {

        int noOfCombinations = 0;
        int[] noOfDoubles = new int[l.length];


        // count lucky doubles for each item in the array
        // select the first and last items
        for (int i = 1; i < l.length - 1; ++i) {
            for (int j = 0; j < i; ++j) {
                if (l[i] % l[j] == 0)
                    ++noOfDoubles[i];
            }
        }

        // Count lucky triples
        for (int i = 2; i < l.length; i++) {
            for (int j = 1; j < i; ++j) {
                if (l[i] % l[j] == 0)
                    noOfCombinations += noOfDoubles[j];
            }
        }
        return noOfCombinations;

    }
}
