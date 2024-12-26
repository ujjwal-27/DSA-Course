package interviewQuestions.stack.arrayList.reverseString;

public class Main {

    public static String reverseString(String string) {
        StringBuilder reversedString = new StringBuilder();

        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString.append(string.charAt(i));
        }

        return reversedString.toString();
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

