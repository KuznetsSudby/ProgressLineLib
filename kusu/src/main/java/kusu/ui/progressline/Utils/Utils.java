package kusu.ui.progressline.Utils;

/**
 * Created by KuSu on 02.02.2017.
 */

public class Utils {
    public static String getTime(int currentTime) {
        return get00Text(currentTime / 60) + ":" + get00Text(currentTime % 60);
    }

    public static String get00Text(int i) {
        return i < 10 ? "0" + i : "" + i;
    }
}
