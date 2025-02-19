import java.util.ArrayList;
import java.util.Scanner;

public class ChattyDuke {

    public static final String LINE_SEPARATOR = "____________________________________________________________";
    public static final int MAX_ITEMS = 100;
    public static final String INDENTATION = "    ";
    public static final String ADDED_TASK = "Got it. I've added this task:";
    public static final String EXIT_STATEMENT = "Bye. Hope to see you again soon!";
    public static int inputCount = 0;



    public static void main(String[] args) {

        ArrayList<Task> taskLists = new ArrayList<>();

        TaskManager taskManager = new TaskManager();
        taskManager.loadToFile(taskLists);

        System.out.println(LINE_SEPARATOR);
        System.out.println("Hello! I'm ChattyDuke");
        System.out.println("What can I do for you?");
        System.out.println(LINE_SEPARATOR);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        Boolean isBye = false;

        while(!isBye) {


            String s1 = scanner.nextLine();
            String command = s1.split(" ")[0].toUpperCase();
            System.out.println(INDENTATION + LINE_SEPARATOR);

            try{
                TaskCommand taskCommand = TaskCommand.valueOf(command);

                switch(taskCommand){
                case BYE:
                    isBye = true;
                    System.out.println(INDENTATION + EXIT_STATEMENT);
                    System.out.println(INDENTATION + LINE_SEPARATOR);
                    break;

                case LIST:
                    taskManager.listTask(taskLists);
                    break;

                case UNMARK:
                    taskManager.unmarkTask(s1, taskLists);
                    break;

                case MARK:
                    taskManager.markTask(s1, taskLists);
                    break;

                case DELETE:
                    taskManager.deleteTask(s1, taskLists);

                default:
                    taskManager.handleNewTask(taskCommand, s1, taskLists);
                    System.out.println(INDENTATION + LINE_SEPARATOR);
                    System.out.println();

                }

            }catch(IllegalArgumentException e){
                System.out.println("Please input valid command :)");
                System.out.println(INDENTATION + LINE_SEPARATOR);
                System.out.println();
            }

        }
    }
}
