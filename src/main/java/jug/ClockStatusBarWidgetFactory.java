package jug;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.StatusBarWidget;
import com.intellij.openapi.wm.StatusBarWidgetFactory;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ClockStatusBarWidgetFactory implements StatusBarWidgetFactory {
    @Override
    public @NonNls @NotNull String getId() {
        return Globals.WIDGET_ID;
    }

    @Override
    public @Nls @NotNull String getDisplayName() {
        return "jug clock";
    }

    @Override
    public boolean isAvailable(@NotNull Project project) {
        return true;
    }

    @Override
    public @NotNull StatusBarWidget createWidget(@NotNull Project project) {
        return new ClockStatusBarWidget();
    }

    @Override
    public void disposeWidget(@NotNull StatusBarWidget widget) {

    }

    @Override
    public boolean canBeEnabledOn(@NotNull StatusBar statusBar) {
        return true;
    }
}
