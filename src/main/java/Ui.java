import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    Boolean isBye = false;
    Scanner scanner = new Scanner(System.in);
    private final TaskManager taskManager;
    private final Parser parser;
    private final Storage storage;

    ArrayList<Task> taskLists;

    public Ui(TaskManager taskManager, ArrayList<Task> taskLists, Storage storage){
        this.taskManager = taskManager;
        this.taskLists = taskLists;
        this.storage = storage;
        parser = new Parser();
    }

    public void startChat(){
        System.out.println(ChattyDuke.LINE_SEPARATOR);
        System.out.println("Hello! I'm ChattyDuke");
        System.out.println("What can I do for you?");
        System.out.println(ChattyDuke.LINE_SEPARATOR);
        System.out.println();
        chatSession();
    }

    public void showLoadingError(String message){
        System.out.println("Error: " + message);
    }

    public void chatSession() {

        while (!isBye) {

            String s1 = scanner.nextLine();
            String command = s1.split(" ")[0].toUpperCase();
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);

            try {
                TaskCommand taskCommand = TaskCommand.valueOf(command);

                if(taskCommand == TaskCommand.BYE){
                    isBye = true;
                    System.out.println(ChattyDuke.INDENTATION + ChattyDuke.EXIT_STATEMENT);
                    System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);

                }else{
                    parser.handleUserInput(taskCommand, taskManager, taskLists, s1, storage);
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Please input valid command :)");
                System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
                System.out.println();
            }
        }
    }

}
