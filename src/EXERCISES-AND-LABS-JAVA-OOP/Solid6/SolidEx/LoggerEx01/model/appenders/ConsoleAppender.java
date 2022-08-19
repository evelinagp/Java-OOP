package LoggerSOLIDEx01.model.appenders;

import LoggerSOLIDEx01.api.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
