class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if((c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9')){
                sb.append(Character.toLowerCase(c));
            }
        }

        String text = sb.toString();
        int n = text.length();

        for(int i = 0; i < n / 2; i++){
            if(text.charAt(i) != text.charAt(n - 1 - i)){
                return false;
            }
        }

        return true;
    }
}