package hackerRank;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class TwilioVanityNumberSearch {
    private static final Map<Character, Character> keypadMap = initializeKeypadMap();

    private static Map<Character, Character> initializeKeypadMap() {
        Map<Character, Character> keypadMap = Arrays.stream(new Object[][] {
                {'A', '2'},
                {'B', '2'},
                {'C', '2'},
                {'D', '3'},
                {'E', '3'},
                {'F', '3'},
                {'G', '4'},
                {'H', '4'},
                {'I', '4'},
                {'J', '5'},
                {'K', '5'},
                {'L', '5'},
                {'M', '6'},
                {'N', '6'},
                {'O', '6'},
                {'P', '7'},
                {'Q', '7'},
                {'R', '7'},
                {'S', '7'},
                {'T', '8'},
                {'U', '8'},
                {'V', '8'},
                {'W', '9'},
                {'X', '9'},
                {'Y', '9'},
                {'Z', '9'}
        }).collect(Collectors.toMap(keyMapper -> (Character)keyMapper[0], valueMapper -> (Character)valueMapper[1]));
        return keypadMap;
    }

    /*
     * Complete the 'vanity' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY codes
     *  2. STRING_ARRAY numbers
     */

    public static List<String> vanity(List<String> codes, List<String> numbers) {
        Set<String> vanityPhoneNumbers = new HashSet<>();
        List<String> codeToNumberSequences = new ArrayList<>();
        for (String code : codes) {
            StringBuilder numberSequence = new StringBuilder();
            for (char character : code.toCharArray()) {
                numberSequence.append(keypadMap.get(character));
            }
            codeToNumberSequences.add(numberSequence.toString());
        }

        for (String phoneNumber : numbers) {
            for (String codeToNumber : codeToNumberSequences) {
                if (phoneNumber.contains(codeToNumber)) {
                    vanityPhoneNumbers.add(phoneNumber);
                }
            }
        }

        List<String> resultVanityPhoneNumbers = new ArrayList<>(vanityPhoneNumbers);
        Collections.sort(resultVanityPhoneNumbers);

        return resultVanityPhoneNumbers;
    }

    public static void main(String[] args) throws IOException {
        List<String> codes = new ArrayList<>();
        codes.add("TWLO");
        codes.add("CODE");
        codes.add("HTCH");

        List<String> numbers = new ArrayList<>();
        numbers.add("40006");
        numbers.add("+14157088956");
        numbers.add("+15108956333");
        numbers.add("+15109926333");
        numbers.add("+17474824380");
        numbers.add("+1415123456");
        numbers.add("+919810155555");
        numbers.add("+15109926333");
        numbers.add("+17474824380");
        numbers.add("+1415123456");
        numbers.add("+919810155555");
        numbers.add("+15109926333");
        numbers.add("+17474824380");
        numbers.add("+1415123456");
        numbers.add("+919810155555");
        numbers.add("+15109926333");
        numbers.add("17474824380");
        numbers.add("+17474824380");

        List<String> result = vanity(codes, numbers);

        /*  Output:
            [+14157088956, +15108956333, +15109926333, +17474824380, 17474824380]
         */
        System.out.println(result.toString());

        /*
        Explanation
            TWLO matches +14157088956 (+1415708-TWLO)
            CODE matches +15109926333 (+151099-CODE-3)
            HTCH matches +17474824380 (+1747-HTCH-380)
        */
    }
}