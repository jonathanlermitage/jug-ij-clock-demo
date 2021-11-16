package jug;

import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.StatusBarWidget;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class ClockStatusBarWidget implements StatusBarWidget {
    @Override
    public @NonNls @NotNull String ID() {
        return Globals.WIDGET_ID;
    }

    @Override
    public @Nullable WidgetPresentation getPresentation() {
        return new ClockWidgetPresentation();
    }

    @Override
    public void install(@NotNull StatusBar statusBar) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                statusBar.updateWidget(Globals.WIDGET_ID);
            }
        }, 0, 1000);

    }

    @Override
    public void dispose() {

    }
}
