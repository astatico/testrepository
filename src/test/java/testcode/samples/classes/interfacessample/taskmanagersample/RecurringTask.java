package testcode.samples.classes.interfacessample.taskmanagersample;

public class RecurringTask extends Task {

    private int frequency;

    public RecurringTask(String name, int frequency) {
        super(name);
        this.frequency = frequency;
    }

    @Override
    public void execute() {
        System.out.println("Executing recurring task: " + name + " (Frequency: " + frequency + ")");
        completed = true;
    }
}
