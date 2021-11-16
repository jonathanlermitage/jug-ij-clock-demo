package jug;

import com.intellij.openapi.ui.popup.ListPopup;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.wm.StatusBarWidget;
import com.intellij.util.Consumer;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ClockWidgetPresentation implements StatusBarWidget.MultipleTextValuesPresentation {

    private static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("E hh:mm:ss a");

    @Override
    public @Nullable("null means the widget is unable to show the popup") ListPopup getPopupStep() {
        return null;
    }

    @Override
    public @Nullable @NlsContexts.StatusBarText String getSelectedValue() {
        return DATETIME_FORMAT.format(LocalDateTime.now(ZoneId.of("America/Montreal")));
    }

    @Override
    public @Nullable Icon getIcon() {
        return IconLoader.getIcon("/clock/canada.svg", this.getClass());
    }

    @Override
    public @Nullable @NlsContexts.Tooltip String getTooltipText() {
        return "L'heure à Montréal";
    }

    @Override
    public @Nullable Consumer<MouseEvent> getClickConsumer() {
        return null;
    }
}
