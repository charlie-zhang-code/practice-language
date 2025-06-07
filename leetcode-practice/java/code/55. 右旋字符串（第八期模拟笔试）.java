import java.util.*;

public class Main {
    public static void reverse(char[] stringChars, int start, int end) {
        while (start < end) {
            char temp = stringChars[start];
            stringChars[start] = stringChars[end];
            stringChars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        int length = s.length();
        char[] stringChars = s.toCharArray();

        reverse(stringChars, 0, length - 1);
        reverse(stringChars, 0, n - 1);
        reverse(stringChars, n, length - 1);

        System.out.println(stringChars);
    }
}
