package testcode.samples.classes.interfacessample.taskmanagersample;

public abstract class Task implements TaskManager {

    protected String name;
    protected boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }
}
