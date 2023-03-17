public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static String findNeedle(Object[] haystack) {
        int position = -1;

        for (int i = 0; i < haystack.length; i++) {
            if(haystack[i] == "needle") {
                position = i;
            }
        }
        System.out.println(haystack);
        if (position >= 0) {
            return "found the neelde at position " + position;
        } else {
            return "we haven't found the needle";
        }

    }
}