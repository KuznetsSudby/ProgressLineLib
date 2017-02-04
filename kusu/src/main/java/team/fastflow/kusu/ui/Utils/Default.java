package team.fastflow.kusu.ui.Utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

import team.fastflow.kusu.R;
import team.fastflow.kusu.ui.Models.Settings;

/**
 * Created by KuSu on 02.02.2017.
 */

public class Default {
    public final static int type = Settings.TIME_STEP;
    public final static int layout = R.layout.def_progress_line;

    public final static int timeMax = 25;
    public final static int stepMax = 6;
    public final static int timeRed = 10;

    public final static int duration = 300;

    public final static int background = R.color.backgroundColor;
    public final static int progress = R.color.progressColor;
    public final static int divider = R.color.dividerColor;
    public final static int current = R.color.currentColor;
    public final static int timeEnd = android.R.color.holo_red_light;

    public final static int dividerHeight = 1;

    public final static boolean stepVisible = true;
    public final static int stepPadding = 1;

    public final static int stepEmpty = R.drawable.ic_empty;
    public final static int stepGood = R.drawable.ic_good;
    public final static int stepBad = R.drawable.ic_bad;

    public final static boolean drawTime = true;
    public final static boolean drawArrow = true;
}
