package reflection;

import java.lang.reflect.Method;

class ThreadLogger {

    // Method to log thread details using reflection
    public static void logThreadInfo(Thread thread, String status) {
        try {
            Class<?> threadClass = thread.getClass();

            // Get thread details using reflection
            Method getNameMethod = threadClass.getMethod("getName");
            Method getIdMethod = threadClass.getMethod("getId");
            Method getPriorityMethod = threadClass.getMethod("getPriority");

            String name = (String) getNameMethod.invoke(thread);
            long id = (Long) getIdMethod.invoke(thread);
            int priority = (Integer) getPriorityMethod.invoke(thread);

            System.out.println("[" + status + "] Thread Info -> Name: " + name +
                    ", ID: " + id + ", Priority: " + priority);

        } catch (Exception e) {
            System.out.println("Error logging thread info: " + e.getMessage());
        }
    }
}

class WorkerThread extends Thread {
    public WorkerThread(String name) {
        super(name);
        ThreadLogger.logThreadInfo(this, "CREATED");
    }

    @Override
    public void run() {
        ThreadLogger.logThreadInfo(this, "STARTED");
        try {
            // Simulate work
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadLogger.logThreadInfo(this, "COMPLETED");
    }
}

public class reflection {
    public static void main(String[] args) {
        System.out.println("Main Thread Started\n");

        Thread t1 = new WorkerThread("Worker-1");
        Thread t2 = new WorkerThread("Worker-2");
        Thread t3 = new WorkerThread("Worker-3");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll threads have completed execution.");
    }
}
