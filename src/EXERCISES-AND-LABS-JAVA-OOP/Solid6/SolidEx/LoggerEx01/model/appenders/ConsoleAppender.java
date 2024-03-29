package Solid6.SolidEx.LoggerEx01.model.appenders;


import Solid6.SolidEx.LoggerEx01.api.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
