import java.util.ArrayList;

/**
 * A class to parse the input from user.
 */
public class Parser {

    /**
     * Method to determine the type of command input by the user.
     * @param taskCommand Command type from the user input.
     * @param taskManager a reference to the TaskManager instance.
     * @param taskLists an arraylist that stores all the tasks.
     * @param userInput a sentence entered by the user in the command-line terminal.
     * @param storage a reference to the Storage instance.
     */
    public void handleUserInput(TaskCommand taskCommand, TaskManager taskManager, ArrayList<Task> taskLists, String userInput, Storage storage){

        switch (taskCommand) {
        case LIST:
            taskManager.listTask(taskLists);
            break;

        case UNMARK:
            taskManager.unmarkTask(userInput, taskLists);
            break;

        case MARK:
            taskManager.markTask(userInput, taskLists);
            break;

        case DELETE:
            taskManager.deleteTask(userInput, taskLists);
            break;

        case FIND:
            taskManager.findTask(userInput, taskLists);
            break;

        default:
            handleNewTask(taskManager, taskCommand, userInput, taskLists, storage);
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
            System.out.println();

        }

    }

    /**
     * Method to create new task according to the command type.
     * @param taskManager a reference to the TaskManager instance.
     * @param taskCommand Command type from the user input.
     * @param userInput a sentence entered by the user in the command-line terminal.
     * @param taskLists an arraylist that stores all the tasks.
     * @param storage a reference to the Storage instance.
     */
    public void handleNewTask(TaskManager taskManager, TaskCommand taskCommand, String userInput, ArrayList<Task> taskLists, Storage storage){
        try{
            String[] taskInfo = userInput.split(" ",2);
            if(taskInfo.length < 2 || taskInfo[1].trim().isEmpty()){
                throw new ChattyDukeException("Hmmmm, Please include the task description");
            }

            switch(taskCommand){
            case TODO:
                taskManager.createTodo(userInput, taskLists);
                break;

            case DEADLINE:
                taskManager.createDeadline(userInput, taskLists);
                break;

            case EVENT:
                taskManager.createEvent(userInput, taskLists);
                break;
            }

            storage.saveToFile(taskLists);

        }catch(ChattyDukeException e){
            System.out.println(e.getMessage());
        }
    }
}
