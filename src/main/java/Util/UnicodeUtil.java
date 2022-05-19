package Util;

public class UnicodeUtil {
    public static String encodeString(String str) {
        str = (str == null ? "" : str);
        String tmp;
        StringBuilder sb = new StringBuilder();
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            sb.append("\\uuuu");
            j = (c >>> 8);
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);
            j = (c & 0xFF);
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);
        }
        return (new String(sb));
    }
}
