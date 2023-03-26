package WorkingWithAbstraction1.Lab.WorkingWithAbstraction_StudentSystemLab03;

public class CommandHandler {
    private StudentRepository repository;

    public CommandHandler( ) {
        this.repository = new StudentRepository();
    }

    public String handleCommand(String[] tokens) {
        if (tokens[0].equals("Create")) {
            String name = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double grade = Double.parseDouble(tokens[3]);
            Student student = new Student(name, age, grade);
            this.repository.add(student);
            return null;
//            if (!studentsByName.containsKey(name)) {
//                var student = new Student(name, age, grade);
//                studentsByName.put(name, student);
//            }
        } else if (tokens[0].equals("Show")) {
            String name = tokens[1];
            return repository.get(name).getInfo();
//            if (studentsByName.containsKey(name)) {
//                var student = studentsByName.get(name);
//                String view = String.format("%s is %s years old.", student.getName(), student.getAge());
//
//                if (student.getGrade() >= 5.00) {
//                    view += " Excellent student.";
//                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
//                    view += " Average student.";
//                } else {
//                    view += " Very nice person.";
//                }
//
//                System.out.println(view);
//            }
        }
        return tokens[0];
    }
}
