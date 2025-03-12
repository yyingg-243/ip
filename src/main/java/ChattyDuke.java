import java.util.ArrayList;

public class ChattyDuke {

    public static final String LINE_SEPARATOR = "____________________________________________________________";
    public static final String INDENTATION = "    ";
    public static final String ADDED_TASK = "Got it. I've added this task:";
    public static final String EXIT_STATEMENT = "Bye. Hope to see you again soon!";


    private final Storage storage;
    private  Ui ui;
    private final TaskManager taskManager = new TaskManager();
    private ArrayList<Task> taskLists = new ArrayList<>();


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
     *
     */
    public void run(){
        ui.startChat();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        new ChattyDuke("data/tasks.txt").run();
    }
}
