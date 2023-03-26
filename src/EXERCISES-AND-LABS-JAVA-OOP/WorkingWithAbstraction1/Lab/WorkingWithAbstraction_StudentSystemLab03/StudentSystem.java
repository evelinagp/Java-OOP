package WorkingWithAbstraction1.Lab.WorkingWithAbstraction_StudentSystemLab03;

import WorkingWithAbstraction1.Lab.WorkingWithAbstraction_StudentSystemLab03.input.Reader;

import static WorkingWithAbstraction1.Lab.WorkingWithAbstraction_StudentSystemLab03.input.ConsolePrinter.printLine;

public class StudentSystem {

    private CommandHandler handler;

    public StudentSystem() {
        this.handler = new CommandHandler();
    }

    public void start() {
        boolean isWorking = true;
        while (isWorking) {
            String result = handler.handleCommand(Reader.readStringArray("\\s+"));
            if (result != null && !result.equals("Exit")) {
             printLine(result);
            }
            isWorking = !"Exit".equals(result);
        }
    }
}
