package level_1.braille_translation_2;

import java.util.HashMap;
import java.util.Map;

public class solution {

    private static final String ONE_LETTER_CAPITAL = "000001";
    private static final String ENTIRE_WORD_CAPITAL = "000001000001";
    private static Map<Character, String> BRAILLE_MAP = new HashMap<>();

    public static void main(String[] args) {
        setupBrailleMap();

        System.out.println(answer("A"));

    }

    public static String answer(String plaintext) {

        StringBuilder stringBuffer = new StringBuilder("");

        // check entire word is capital & only spaces
//        if (plaintext.equals(plaintext.toUpperCase()) && plaintext.trim().length() > 0) {
//
//            // add entire word capital value
//            stringBuffer.append(ENTIRE_WORD_CAPITAL);
//
//            for (int i = 0; i < plaintext.length(); i++) {
//                char c = plaintext.charAt(i);
//
//                // add alphabet value to buffer
//                stringBuffer.append(BRAILLE_MAP.get(Character.toLowerCase(c)));
//            }
//        } else {
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isUpperCase(c)) {
                // one letter upper case
                stringBuffer.append(ONE_LETTER_CAPITAL);
            }

            // add alphabet value to buffer
            stringBuffer.append(BRAILLE_MAP.get(Character.toLowerCase(c)));
        }
//        }
        return stringBuffer.toString();
    }

    private static void setupBrailleMap() {
        String alphabets = "abcdefghijklmnopqrstuvwxyz ";
        String[] brailleArray = new String[]
                {"100000", "110000", "100100", "100110", "100010", "110100", "110110", "110010", "010100",
                        "010110", "101000", "111000", "101100", "101110", "101010", "111100", "111110", "111010",
                        "011100", "011110", "101001", "111001", "010111", "101101", "101111", "101011", "000000"};

        // set map values
        for (int i = 0; i < alphabets.length(); i++) {
            BRAILLE_MAP.put(alphabets.charAt(i), brailleArray[i]);
        }
    }

}