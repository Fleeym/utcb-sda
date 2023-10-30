package utcb.sda_data;

public class SDAArrayUtil {
    public static <T> String toString(T[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T j : arr) {
            sb.append(j.toString());
            sb.append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "");
        sb.append("]");
        return sb.toString();
    }
}
