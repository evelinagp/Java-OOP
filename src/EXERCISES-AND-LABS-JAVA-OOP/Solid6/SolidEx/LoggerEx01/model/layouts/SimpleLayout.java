package LoggerSOLIDEx01.model.layouts;

import LoggerSOLIDEx01.api.Layout;

public class SimpleLayout  implements Layout {
    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
