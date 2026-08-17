import java.util.*;

class Solution {
    public String simplifyPath(String path) {

        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty parts and "."
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Go one folder back
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Normal folder
            else {
                stack.push(part);
            }
        }

        String result = "";

        // Stack is in reverse order, so build from bottom to top
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }

        if (result.equals("")) {
            return "/";
        }

        return result;
    }
}