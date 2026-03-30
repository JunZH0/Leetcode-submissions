class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String st : strs) {
            sb.append(st.length()).append("#").append(st);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) return new ArrayList<>();
        
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
