import java.util.ArrayList;

/**
 * Main class for the chatbot "ChattyDuke"
 */
public class ChattyDuke {

    public static final String LINE_SEPARATOR = "____________________________________________________________";
    public static final String INDENTATION = "    ";
    public static final String ADDED_TASK = "Got it. I've added this task:";
    public static final String EXIT_STATEMENT = "Bye. Hope to see you again soon!";


    private final Storage storage;
    private  Ui ui;
    private final TaskManager taskManager = new TaskManager();
    private ArrayList<Task> taskLists = new ArrayList<>();

    /**
     * Constructor of ChattyDuke to initialize the chatbot.
     * @param filePath File directory to save remaining task in the taskList.
     */
    public ChattyDuke(String filePath) {
        storage = new Storage(filePath);

        try {
            storage.setDirectory();
            taskLists = storage.loadToFile(taskLists);
            ui = new Ui(taskManager, taskLists, storage);

        } catch (ChattyDukeException e) {
            ui = new Ui(taskManager, taskLists, storage);
            ui.showLoadingError(e.getMessage());
        }

    }

    /**
     * Call startChat method to start accepting input from the user.
     */
    public void run(){
        ui.startChat();
    }

    /**
     * The main function of the class.
     * @param args command-line input.
     */
    public static void main(String[] args) {
        new ChattyDuke("data/tasks.txt").run();
    }
}
