package testcode.samples.classes.interfacessample.taskmanagersample;

public class Main {
    public static void main(String[] args) {
        UrgentTask urgentTask = new UrgentTask("Finish report");
        RecurringTask recurringTask = new RecurringTask("Exercise", 3);
        RegularTask regularTask = new RegularTask("Buy groceries");

        urgentTask.execute();
        recurringTask.execute();
        regularTask.execute();

        System.out.println("Is urgent task completed? " + urgentTask.isCompleted());
        System.out.println("Is recurring task completed? " + recurringTask.isCompleted());
        System.out.println("Is regular task completed? " + regularTask.isCompleted());
    }
}
