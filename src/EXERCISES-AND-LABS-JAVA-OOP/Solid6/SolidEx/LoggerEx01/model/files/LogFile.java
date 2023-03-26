package Solid6.SolidEx.LoggerEx01.model.files;

import Solid6.SolidEx.LoggerEx01.api.*;

public class LogFile implements File {
    private int size;
    private StringBuilder content;
    public LogFile(){
        this.content = new StringBuilder();
    }
    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void write(String message) {
        content.append(message);
        this.size += this.getMessageSize(message);
    }

    private int getMessageSize(String message) {
        return message.chars().filter(c -> Character.isAlphabetic(c)).sum();
    }
}
