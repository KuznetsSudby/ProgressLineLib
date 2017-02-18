package kusu.ui.progressline.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import kusu.ui.progressline.Models.Settings;

/**
 * Created by KuSu on 28.01.2017.
 */
public class Line extends View {
    private ProgressLine progressLine;

    public Line(Context context) {
        super(context);
    }

    public Line(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setProgressLine(ProgressLine progressLine) {
        this.progressLine = progressLine;
    }

    @Override
    public void draw(Canvas canvas) {
        if (isInEditMode())
            return;
        if (progressLine == null)
            return;
        int width = 0;
        Paint paint = new Paint();
        paint.setColor(progressLine.getSettings().getBackgroundColor());
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setColor(progressLine.getSettings().getProgressColor());
        switch (progressLine.getSettings().getType()) {
            case Settings.TIMER:
                width = (int) (canvas.getWidth() * (
                        progressLine.getState().getCurrentTime() * 1.0 / progressLine.getSettings().getTimeMax()
                ));
                canvas.drawRect(0, 0, width, getHeight(), paint);
                if (progressLine.getSettings().isDrawArrow()) {
                    drawArrow(canvas, width, getHeight(), paint);
                }
                break;
            case Settings.STEP:
            case Settings.TIME_STEP:
                int forStep = getWidth() / progressLine.getSettings().getStepMax();
                int delta = getWidth() - forStep * progressLine.getSettings().getStepMax();
                int left = delta / 2;
                int right = delta - left;
                canvas.drawRect(left, 0, left + forStep * progressLine.getState().getCurrentStep(), getHeight(), paint);

                paint.setColor(progressLine.getSettings().getCurrentColor());
                canvas.drawRect(left + forStep * progressLine.getState().getCurrentStep(), 0, left + forStep * (progressLine.getState().getCurrentStep() + 1), getHeight(), paint);

                paint.setColor(progressLine.getSettings().getDividerColor());
                if (progressLine.getSettings().isStepVisible()) {
                    int lDiv = progressLine.getSettings().getDividerHeight() / 2;
                    int rDiv = progressLine.getSettings().getDividerHeight() - lDiv;
                    int position;
                    for (int i = 1; i < progressLine.getSettings().getStepMax(); i++) {
                        position = left + forStep * i;
                        canvas.drawRect(position - lDiv, 0, position + rDiv, getHeight(), paint);
                    }
                    int p = progressLine.getSettings().getStepPadding();
                    for (int i = 0; i < progressLine.getSettings().getStepMax(); i++) {
                        drawDrawable(canvas, new Rect(left + p + forStep * i, p, left + forStep * (i + 1) - p, getHeight() - p),
                                progressLine.getSettings().getDrawable(progressLine.getState().getResult(i)));
                    }
                }
                canvas.drawRect(0, 0, left, getHeight(), paint);
                canvas.drawRect(getWidth() - right, 0, getWidth(), getHeight(), paint);
                break;
        }
    }

    private void drawDrawable(Canvas canvas, Rect rect, Drawable drawable) {
        drawable.setBounds(rect);
        if (drawable.getMinimumWidth() * 1.0 / drawable.getMinimumHeight() > rect.width() * 1.0 / rect.height()) {
            int real_height = (int) (rect.width() * drawable.getMinimumHeight() * 1.0 / drawable.getMinimumWidth());
            int delta = rect.height() - real_height;
            delta /= 2;
            rect.top += delta;
            rect.bottom -= delta;
        } else {
            int real_width = (int) (rect.height() * drawable.getMinimumWidth() * 1.0 / drawable.getMinimumHeight());
            int delta = rect.width() - real_width;
            delta /= 2;
            rect.left += delta;
            rect.right -= delta;
        }
        drawable.setBounds(rect);
        if (rect.height() > 0 && rect.width() > 0)
            drawable.draw(canvas);
    }

    private void drawArrow(Canvas canvas, int w, int h, Paint paint) {
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(w, 0);
        path.lineTo(w + h / 2, h / 2);
        path.lineTo(w + h / 2, h / 2);
        path.lineTo(w, h);
        path.lineTo(w, h);
        path.lineTo(w - h / 2, h / 2);
        path.lineTo(w - h / 2, h / 2);
        path.lineTo(w, 0);
        canvas.drawPath(path, paint);
    }
}
