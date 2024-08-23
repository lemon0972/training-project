public class Main {
    public static void main(String[] args) {
        String s = "aaabbccdddjjkklmnef";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    result.append(s.charAt(i));
                }

            } else if (i == s.length() - 1) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    result.append(s.charAt(i));
                }
            } else {
                if (s.charAt(i - 1) != s.charAt(i)
                        && s.charAt(i + 1) != s.charAt(i)) {
                    result.append(s.charAt(i));
                } else {
                    if (result.length() != 0) {
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}