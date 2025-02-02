import java.util.Scanner;

public class ChattyDuke {

    private static final int MAX_ITEMS = 100;

    public static void main(String[] args) {

        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/

        String line = "____________________________________________________________";
        String indentation = "    ";
        Task[] items = new Task[MAX_ITEMS];
        int inputCount = 0;

        System.out.println(line);
        System.out.println("Hello! I'm ChattyDuke");
        System.out.println("What can I do for you?");
        System.out.println(line);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        Boolean isBye = false;

        while(!isBye) {
            String s1 = scanner.nextLine();
            System.out.println(indentation + line);

            if(s1.equalsIgnoreCase("bye")) {
                isBye = true;
                System.out.println(indentation + "Bye. Hope to see you again soon!");
                System.out.println(indentation + line);
            } else if (s1.equalsIgnoreCase("list")) {
                System.out.println(indentation + "Here are the tasks in your list:");
                for(int i = 0; i < inputCount; i++){
                    Task t = items[i];
                    int index = i + 1;
                    System.out.println(indentation + index + ". [" + t.getStatusIcon() + "] " + t.getDescription());

                }
                System.out.println(indentation + line);
                System.out.println();


            } else if (s1.toLowerCase().contains("unmark")) {
                String[] splitedInput = s1.split(" ");

                int taskNumber = Integer.parseInt(splitedInput[1]);
                Task t = items[taskNumber - 1];
                t.unmark();

                System.out.println(indentation + "OK, I've marked this task as not done yet:");
                System.out.println(indentation + "  [" + t.getStatusIcon() + "] " + t.getDescription());
                System.out.println(indentation + line);
                System.out.println();


            } else if (s1.toLowerCase().contains("mark")) {
                String[] splitedInput = s1.split(" ");

                int taskNumber = Integer.parseInt(splitedInput[1]);
                Task t = items[taskNumber - 1];
                t.markAsDone();

                System.out.println(indentation + "Nice! I've marked this task as done:");
                System.out.println(indentation + "  [" + t.getStatusIcon() + "] " + t.getDescription());
                System.out.println(indentation + line);
                System.out.println();


            } else {
                items[inputCount] = new Task(s1);
                inputCount++;

                System.out.println(indentation + "added: " + s1);
                System.out.println(indentation + line);
                System.out.println();

            }


        }

    }
}
