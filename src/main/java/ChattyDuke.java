import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ChattyDuke {

    public static final String LINE_SEPARATOR = "____________________________________________________________";
    public static final int MAX_ITEMS = 100;
    public static final String INDENTATION = "    ";
    public static final String ADDED_TASK = "Got it. I've added this task:";
    public static final String EXIT_STATEMENT = "Bye. Hope to see you again soon!";




    public static void main(String[] args) {

        String folderName = "saved_data";
        String fileName = "data.txt";
        String currentDirectory = System.getProperty("user.dir");
        String folderDirectory = currentDirectory + File.separator + folderName;
        String finalDirectory = folderDirectory + File.separator + fileName;


        System.out.println(LINE_SEPARATOR);
        System.out.println("Hello! I'm ChattyDuke");
        System.out.println("What can I do for you?");
        System.out.println(LINE_SEPARATOR);
        System.out.println();


        TaskManager taskManager = new TaskManager();
        ArrayList<Task> taskLists = new ArrayList<>();
        taskLists = taskManager.loadToFile(finalDirectory);

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
                    taskManager.handleNewTask(taskCommand, s1, taskLists, finalDirectory, folderDirectory);
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
