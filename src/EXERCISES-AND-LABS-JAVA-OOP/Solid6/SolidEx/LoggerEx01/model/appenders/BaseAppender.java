package Solid6.SolidEx.LoggerEx01.model.appenders;


import Solid6.SolidEx.LoggerEx01.api.*;
import Solid6.SolidEx.LoggerEx01.enums.ReportLevel;

public abstract class BaseAppender implements Appender {
    private final Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppendedCount;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
        this.messagesAppendedCount = 0;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public void appendMessage(String dateTime, ReportLevel reportLevel, String message) {
        if (reportLevel.ordinal() >= this.reportLevel.ordinal()) {
            String result = String.format(this.layout.getLayout(), dateTime, reportLevel, message);
            this.append(result);
            this.messagesAppendedCount++;
        }
    }

    protected abstract void append(String result);

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d", this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(), this.reportLevel.name(), this.messagesAppendedCount);
    }
}

