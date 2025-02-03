import java.util.Scanner;

public class ChattyDuke {

    public static final String LINE_SEPARATOR = "____________________________________________________________";
    public static final int MAX_ITEMS = 100;
    public static final String INDENTATION = "    ";

    public static void main(String[] args) {

        Task[] items = new Task[MAX_ITEMS];
        int inputCount = 0;

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
                System.out.println(INDENTATION + "Bye. Hope to see you again soon!");
                System.out.println(INDENTATION + LINE_SEPARATOR);
            } else if (s1.equalsIgnoreCase("list")) {
                System.out.println(INDENTATION + "Here are the tasks in your list:");
                for(int i = 0; i < inputCount; i++){
                    Task t = items[i];
                    int index = i + 1;
                    System.out.println(INDENTATION + index + ". [" + t.getStatusIcon() + "] " + t.getDescription());

                }
                System.out.println(INDENTATION + LINE_SEPARATOR);
                System.out.println();


            } else if (s1.toLowerCase().contains("unmark")) {
                String[] splitedInput = s1.split(" ");

                int taskNumber = Integer.parseInt(splitedInput[1]);
                Task t = items[taskNumber - 1];
                t.unmark();

                System.out.println(INDENTATION + "OK, I've marked this task as not done yet:");
                System.out.println(INDENTATION + "  [" + t.getStatusIcon() + "] " + t.getDescription());
                System.out.println(INDENTATION + LINE_SEPARATOR);
                System.out.println();


            } else if (s1.toLowerCase().contains("mark")) {
                String[] splitedInput = s1.split(" ");

                int taskNumber = Integer.parseInt(splitedInput[1]);
                Task t = items[taskNumber - 1];
                t.markAsDone();

                System.out.println(INDENTATION + "Nice! I've marked this task as done:");
                System.out.println(INDENTATION + "  [" + t.getStatusIcon() + "] " + t.getDescription());
                System.out.println(INDENTATION + LINE_SEPARATOR);
                System.out.println();


            } else {
                items[inputCount] = new Task(s1);
                inputCount++;

                System.out.println(INDENTATION + "added: " + s1);
                System.out.println(INDENTATION + LINE_SEPARATOR);
                System.out.println();

            }


        }

    }
}
