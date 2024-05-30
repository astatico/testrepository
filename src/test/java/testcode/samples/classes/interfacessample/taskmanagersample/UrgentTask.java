package testcode.samples.classes.interfacessample.taskmanagersample;

public class UrgentTask extends Task {

    public UrgentTask(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("Executing urgent task: " + name);
        completed = true;
    }
}
