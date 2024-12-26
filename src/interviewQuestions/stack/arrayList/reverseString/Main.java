package interviewQuestions.stack.arrayList.reverseString;

public class Main {

    public static String reverseString(String string) {
        Stack stack = new Stack();
        String reversedString = "";

        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }

        while (!stack.isEmpty()) {
            reversedString = reversedString + stack.pop();
        }

        return reversedString;
    }

    public static void main(String[] args) {

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

    }

}

