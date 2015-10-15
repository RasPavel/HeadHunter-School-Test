import java.util.Scanner;

/**
 * Created by Pavel on 13.10.2015.
 */
public class SubstringPos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        System.out.println(Searcher.getPos(s));
    }

    static class Searcher {

        public static int getPos(String subString) {
            if (subString.matches("0+")) {
                int n = Integer.parseInt("1" + subString);
                return index(n) + 1;
            }

            int bestPos;
            for (int len = 1; len <= subString.length(); len++) {
                bestPos = Integer.MAX_VALUE;
                for (int start = 0; start < len; start++) {
                    int firstNumber = getFirstNumber(subString, start, len);
                    if (firstNumber == -1) {
                        continue;
                    }
                    String generatedString = generateString(subString, start, firstNumber);
                    if (subString.equals(generatedString)) {
                        //position found for current len, start
                        int pos =  index(firstNumber) - start;
                        if (pos < bestPos) bestPos = pos;
                    }
                }

                if (bestPos < Integer.MAX_VALUE)  {
                    return bestPos;
                }
            }
            return -1;
        }

        private static int getFirstNumber(String subString, int start, int len) {
            String firstNumberStr;
            if (start + len <= subString.length()) {
                //there is a full number in subString
                firstNumberStr = subString.substring(start, start + len);
            } else {
                //create full number combining end of previous number and beginning of next number
                String prevNumberEnd = subString.substring(0, start);
                String prevNumberEndPlus = String.valueOf(Integer.parseInt(prevNumberEnd) + 1);
                while (prevNumberEndPlus.length() < prevNumberEnd.length()) {
                    prevNumberEndPlus = "0" + prevNumberEndPlus;
                }

                String a = subString.substring(start, subString.length());
                String b = prevNumberEndPlus.substring(prevNumberEndPlus.length() - (len - a.length()));
                firstNumberStr = a + b;
            }
            if (firstNumberStr.charAt(0) == '0') {
                return -1;
            }

            return Integer.parseInt(firstNumberStr);
        }

        private static String generateString(String subString, int start, int firstNumber) {
            StringBuilder sb = new StringBuilder("" + firstNumber);
            String prevNumber = String.valueOf(firstNumber - 1);
            String prevNumberEnding = prevNumber.substring(prevNumber.length() - start);
            sb.insert(0, prevNumberEnding);

            while (sb.length() < subString.length()) {
                firstNumber++;
                sb.append(firstNumber);
            }
            sb.setLength(subString.length());

            return sb.toString();
        }

        private static int index(int n) {
            int x = 1;
            int m = 0;
            int xIndex = 1;
            while (n > x) {
                m++;
                xIndex += 9 * x * m;
                x *= 10;
            }
            return xIndex - (x - n) * m;
        }
    }


}


