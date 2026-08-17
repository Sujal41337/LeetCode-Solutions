import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String current = "";
        int number = 0;

        for (char ch : s.toCharArray()) {

            // If it is a number
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            // Opening bracket
            else if (ch == '[') {
                numStack.push(number);
                stringStack.push(current);

                number = 0;
                current = "";
            }

            // Closing bracket
            else if (ch == ']') {

                int times = numStack.pop();
                String previous = stringStack.pop();

                String temp = "";

                for (int i = 0; i < times; i++) {
                    temp = temp + current;
                }

                current = previous + temp;
            }

            // Normal character
            else {
                current = current + ch;
            }
        }

        return current;
    }
}