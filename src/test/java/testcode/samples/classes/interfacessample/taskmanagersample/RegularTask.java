package testcode.samples.classes.interfacessample.taskmanagersample;

public class RegularTask extends Task {

    public RegularTask(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("Executing regular task: " + name);
        completed = true;
    }
}
