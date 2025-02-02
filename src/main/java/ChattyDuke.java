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
        String[] items = new String[MAX_ITEMS];
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
                for(int i = 0; i < inputCount; i++){
                    int index = i + 1;
                    System.out.println(indentation + index + ". " + items[i]);

                }
                System.out.println(indentation + line);
                System.out.println();


            } else {
                items[inputCount] = s1;
                inputCount++;

                System.out.println(indentation + "added: " + s1);
                System.out.println(indentation + line);
                System.out.println();

            }


        }

    }
}
