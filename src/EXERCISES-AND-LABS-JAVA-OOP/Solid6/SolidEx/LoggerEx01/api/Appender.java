package Solid6.SolidEx.LoggerEx01.api;


import Solid6.SolidEx.LoggerEx01.enums.ReportLevel;

public interface Appender {
    void appendMessage(String dateTime, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);
}
