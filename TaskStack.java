import java.util.Arrays;

public class TaskStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] tasks;
    private int size;

    public TaskStack() {
        tasks = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void addTask(T task) {
        ensureCapacity();
        tasks[size++] = task;
    }

    public T processLastTask() {
        if (size == 0) {
            throw new IllegalStateException("Task stack is empty");
        }
        T lastTask = tasks[--size];
        tasks[size] = null; // Remove reference to the processed task
        return lastTask;
    }

    public void displayPendingTasks() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(tasks[i]);
        }
    }

    private void ensureCapacity() {
        if (size == tasks.length) {
            tasks = Arrays.copyOf(tasks, size * 2);
        }
    }

    public static void main(String[] args) {
        TaskStack<String> taskStack = new TaskStack<>();
        taskStack.addTask("Task 1");
        taskStack.addTask("Task 2");
        taskStack.addTask("Task 3");

        System.out.println("Pending tasks:");
        taskStack.displayPendingTasks();

        System.out.println("Processing last task: " + taskStack.processLastTask());

        System.out.println("Pending tasks after processing:");
        taskStack.displayPendingTasks();
    }
}
