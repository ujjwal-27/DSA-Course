package interviewQuestions.stack.arrayList.parenthesesBalanced;

public class Main {

    public static boolean isBalancedParentheses(String testStr) {
        if (testStr.isEmpty()) return true;

        if (testStr.charAt(0) == ')') return false;

        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < testStr.length(); i++) {
            if (testStr.charAt(i) == '(') {
                leftCount++;

            } else {
                rightCount++;
            }
        }

        if (leftCount != rightCount) return false;

        return true;
    }

    public static void main(String[] args) {
        testAndPrint("()", true);
        testAndPrint("()()", true);
        testAndPrint("(())", true);
        testAndPrint("()()()", true);
        testAndPrint("(()())", true);
        testAndPrint(")()(", false);
        testAndPrint(")(", false);
        testAndPrint("(()", false);
        testAndPrint("))", false);
        testAndPrint("(", false);
        testAndPrint(")", false);
    }

    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);

        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        // Print a separator for better readability
        System.out.println("--------------");
    }

}

