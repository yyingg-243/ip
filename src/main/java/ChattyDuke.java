import java.util.Scanner;

public class ChattyDuke {

    public static final String LINE_SEPARATOR = "____________________________________________________________";
    public static final int MAX_ITEMS = 100;
    public static final String INDENTATION = "    ";
    public static final String ADDED_TASK = "Got it. I've added this task:";
    public static final String EXIT_STATEMENT = "Bye. Hope to see you again soon!";
    public static int inputCount = 0;


    public static void markTask(String s1, Task[] taskLists){
        String[] splitedInput = s1.split(" ");
        int taskNumber = Integer.parseInt(splitedInput[1]);

        if (taskNumber <= 0 || taskNumber > inputCount){
            System.out.println("Invalid number, please try again!");

        }else{
            Task t = taskLists[taskNumber - 1];
            t.markAsDone();
            System.out.println(INDENTATION + "Nice! I've marked this task as done:");
            System.out.println(INDENTATION + t);

        }

        System.out.println(INDENTATION + LINE_SEPARATOR);
        System.out.println();
    }

    public static void unmarkTask(String s1, Task[] taskLists){
        String[] splitedInput = s1.split(" ");

        int taskNumber = Integer.parseInt(splitedInput[1]);

        if (taskNumber <= 0 || taskNumber > inputCount){
            System.out.println("Invalid number, please try again!");

        }else{
            Task t = taskLists[taskNumber - 1];
            t.unmark();
            System.out.println(INDENTATION + "OK, I've marked this task as not done yet:");
            System.out.println(INDENTATION + t);

        }

        System.out.println(INDENTATION + LINE_SEPARATOR);
        System.out.println();
    }

    public static void listTask(Task[] taskLists){
        System.out.println(INDENTATION + "Here are the tasks in your list:");
        for(int i = 0; i < inputCount; i++){
            Task t = taskLists[i];
            int index = i + 1;
            System.out.println(INDENTATION + index + "." + t);

        }
        System.out.println(INDENTATION + LINE_SEPARATOR);
        System.out.println();
    }


    public static void main(String[] args) {

        Task[] taskLists = new Task[MAX_ITEMS];

        System.out.println(LINE_SEPARATOR);
        System.out.println("Hello! I'm ChattyDuke");
        System.out.println("What can I do for you?");
        System.out.println(LINE_SEPARATOR);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        Boolean isBye = false;

        while(!isBye) {
            String s1 = scanner.nextLine();
            System.out.println(INDENTATION + LINE_SEPARATOR);

            if(s1.equalsIgnoreCase("bye")) {
                isBye = true;
                System.out.println(INDENTATION + EXIT_STATEMENT);
                System.out.println(INDENTATION + LINE_SEPARATOR);

            } else if (s1.equalsIgnoreCase("list")) {
                listTask(taskLists);

            } else if (s1.toLowerCase().contains("unmark")) {
                unmarkTask(s1, taskLists);

            } else if (s1.toLowerCase().contains("mark")) {
                markTask(s1, taskLists);

            } else {

                TaskManager taskManager = new TaskManager();
                if(s1.toLowerCase().startsWith("todo")){
                    taskManager.todoTask(s1, taskLists);

                }else if (s1.toLowerCase().startsWith("deadline")){
                    taskManager.deadlineTask(s1, taskLists);

                }else if(s1.toLowerCase().startsWith("event")){
                    taskManager.eventTask(s1, taskLists);

                }

                System.out.println(INDENTATION + LINE_SEPARATOR);
                System.out.println();
            }
        }
    }
}
