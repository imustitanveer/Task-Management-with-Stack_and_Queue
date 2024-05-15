Here's a combined `README.md` file for both the `TaskStack` and `TaskQueue` Java classes:

```markdown
# Task Management with Stacks and Queues

This repository contains two Java programs for managing tasks using different data structures: a stack and a queue. The `TaskStack` class uses a Last-In-First-Out (LIFO) approach, while the `TaskQueue` class uses a First-In-First-Out (FIFO) approach.

## Features

- **TaskStack**:
  - Add tasks to a stack.
  - Process the last added task.
  - Display all pending tasks.

- **TaskQueue**:
  - Add tasks to a queue.
  - Process the earliest added task.
  - Display all pending tasks.

## Usage

### TaskStack

1. **Compile the program:**
   ```sh
   javac TaskStack.java
   ```

2. **Run the program:**
   ```sh
   java TaskStack
   ```

3. **Example usage:**
   - Add tasks: `Task 1`, `Task 2`, `Task 3`
   - Display pending tasks
   - Process the last added task
   - Display pending tasks again

### TaskQueue

1. **Compile the program:**
   ```sh
   javac TaskQueue.java
   ```

2. **Run the program:**
   ```sh
   java TaskQueue
   ```

3. **Example usage:**
   - Add tasks: `Task 1`, `Task 2`, `Task 3`
   - Display pending tasks
   - Process the earliest added task
   - Display pending tasks again

## Code Overview

### TaskStack Class

The `TaskStack` class manages tasks using a stack data structure.

#### Methods

- `public void addTask(T task)`: Adds a task to the stack.
- `public T processLastTask()`: Processes and removes the last added task.
- `public void displayPendingTasks()`: Displays all pending tasks.
- `private void ensureCapacity()`: Ensures the stack has enough capacity to add new tasks.

#### Example

```java
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
```

### TaskQueue Class

The `TaskQueue` class manages tasks using a queue data structure.

#### Methods

- `public void addTask(T task)`: Adds a task to the queue.
- `public T processEarliestTask()`: Processes and removes the earliest added task.
- `public void displayPendingTasks()`: Displays all pending tasks.

#### Example

```java
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
```

## Explanation

- **TaskStack**:
  - A stack is suitable for managing tasks when the last added task needs to be processed first (LIFO).
  - The stack dynamically increases its capacity as more tasks are added.

- **TaskQueue**:
  - A queue is suitable for managing tasks when the earliest added task needs to be processed first (FIFO).
