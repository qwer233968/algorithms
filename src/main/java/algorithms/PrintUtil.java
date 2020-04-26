package algorithms;

public class PrintUtil {

    public static String toString(int[] objs){
        StringBuilder sb = new StringBuilder();
        for (Object o : objs){
            sb.append(o).append(",");
        }
        return sb.toString();
    }
}
