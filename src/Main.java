public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int balance = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int number) {
        String numStr = String.valueOf(number);
        StringBuilder reversed = new StringBuilder();
        for (int i = numStr.length() - 1; i >= 0; i--) {
            reversed.append(numStr.charAt(i));
        }
        return reversed.toString();
    }

    // 3. encryptThis
    public static String encryptThis(String message) {
        String[] words = message.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() == 1) {
                result.append((int) word.charAt(0));
            } else if (word.length() == 2) {
                result.append((int) word.charAt(0)).append(word.charAt(1));
            } else {
                result.append((int) word.charAt(0))
                        .append(word.charAt(word.length() - 1));

                if (word.length() > 3) {
                    result.append(word, 2, word.length() - 1);
                }

                result.append(word.charAt(1));
            }
            result.append(" ");
        }

        return result.toString().trim();
    }

    // 4. decipherThis
    public static String decipherThis(String message) {
        String[] words = message.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder asciiPart = new StringBuilder();
            int i = 0;

            while (i < word.length() && Character.isDigit(word.charAt(i))) {
                asciiPart.append(word.charAt(i));
                i++;
            }

            char firstChar = (char) Integer.parseInt(asciiPart.toString());
            String restOfWord = word.substring(i);

            if (restOfWord.isEmpty()) {
                result.append(firstChar);
            } else if (restOfWord.length() == 1) {
                result.append(firstChar).append(restOfWord);
            } else {
                result.append(firstChar)
                        .append(restOfWord.charAt(restOfWord.length() - 1))
                        .append(restOfWord, 1, restOfWord.length() - 1)
                        .append(restOfWord.charAt(0));
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}
