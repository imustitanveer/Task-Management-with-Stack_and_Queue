import java.util.Arrays;
import java.util.LinkedList;

public class TaskQueue<T> {
    private LinkedList<T> tasks;

    public TaskQueue() {
        tasks = new LinkedList<>();
    }

    public void addTask(T task) {
        tasks.addLast(task);
    }

    public T processEarliestTask() {
        if (tasks.isEmpty()) {
            throw new IllegalStateException("Task queue is empty");
        }
        return tasks.removeFirst();
    }

    public void displayPendingTasks() {
        for (T task : tasks) {
            System.out.println(task);
        }
    }

    public static void main(String[] args) {
        TaskQueue<String> taskQueue = new TaskQueue<>();
        taskQueue.addTask("Task 1");
        taskQueue.addTask("Task 2");
        taskQueue.addTask("Task 3");

        System.out.println("Pending tasks:");
        taskQueue.displayPendingTasks();

        System.out.println("Processing earliest task: " + taskQueue.processEarliestTask());

        System.out.println("Pending tasks after processing:");
        taskQueue.displayPendingTasks();
    }
}

/* A queue is suitable for managing tasks beause it uses a FIFO principle */