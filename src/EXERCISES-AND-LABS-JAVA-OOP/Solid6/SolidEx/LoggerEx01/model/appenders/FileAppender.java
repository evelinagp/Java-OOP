package LoggerSOLIDEx01.model.appenders;

import LoggerSOLIDEx01.api.File;
import LoggerSOLIDEx01.api.Layout;
import LoggerSOLIDEx01.model.files.LogFile;


public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.setFile(new LogFile());
    }

    public void setFile(File file) {
        this.file = file;
    }


    @Override
    public void append(String message) {
        this.file.write(message);
    }

    @Override
    public String toString() {
        return String.format("%s, File size: %d", super.toString(), this.file.getSize());
    }
}
