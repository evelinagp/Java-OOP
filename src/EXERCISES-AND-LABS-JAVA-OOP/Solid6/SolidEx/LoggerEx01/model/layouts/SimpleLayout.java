package Solid6.SolidEx.LoggerEx01.model.layouts;


import Solid6.SolidEx.LoggerEx01.api.Layout;

public class SimpleLayout  implements Layout {
    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
