import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
  Stack stack = new Stack();
    stack.push(s.charAt(0));
    char peek;
    char charAt;

    for (int i = 1; i < s.length(); i++) {
        try {
            peek = (char) stack.peek();
            charAt = s.charAt(i);
            if(!stack.empty()) {
            if ((charAt == '}' && peek == '{') || (charAt == ')' && peek == '(')
                    || (charAt == ']' && peek == '[')) {
                stack.pop();
            } else
                stack.push(charAt);
            }
            else
                stack.push(i);
        } catch (Exception e) {
            //i++;
            charAt = s.charAt(i);
            stack.push(charAt);
        }
    }
    if (stack.empty())
        return "YES";
    else
        return "NO";

}
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
