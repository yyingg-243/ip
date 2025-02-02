import java.util.Scanner;

public class ChattyDuke {
    public static void main(String[] args) {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/

        String line = "____________________________________________________________";
        String indentation = "    ";

        System.out.println(line);
        System.out.println("Hello! I'm ChattyDuke");
        System.out.println("What can I do for you?");
        System.out.println(line);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        Boolean isBye = false;

        while(!isBye){
            String s1 = scanner.nextLine();
            System.out.println(indentation + line);

            if(s1.equalsIgnoreCase("bye")){
                isBye = true;
                System.out.println(indentation + "Bye. Hope to see you again soon!");
                System.out.println(indentation + line);
            }else{
                System.out.println(indentation + s1);
                System.out.println(indentation + line);
                System.out.println();

            }


        }

    }
}
