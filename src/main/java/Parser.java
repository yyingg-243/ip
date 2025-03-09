import java.util.ArrayList;

public class Parser {

    public void handleUserInput(TaskCommand taskCommand, TaskManager taskManager, ArrayList<Task> taskLists, String s1, Storage storage){

        switch (taskCommand) {
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
            break;

        case FIND:
            taskManager.findTask(s1, taskLists);
            break;

        default:
            handleNewTask(taskManager, taskCommand, s1, taskLists, storage);
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
            System.out.println();

        }

    }

    public void handleNewTask(TaskManager taskManager, TaskCommand taskCommand, String s1, ArrayList<Task> taskLists, Storage storage){
        try{
            String[] taskInfo = s1.split(" ",2);

            if(taskInfo.length < 2 || taskInfo[1].trim().isEmpty()){
                throw new ChattyDukeException("Hmmmm, Please include the task description");
            }

            switch(taskCommand){

            case TODO:
                taskManager.createTodo(s1, taskLists);
                break;

            case DEADLINE:
                taskManager.createDeadline(s1, taskLists);
                break;

            case EVENT:
                taskManager.createEvent(s1, taskLists);
                break;
            }

            storage.saveToFile(taskLists);

        }catch(ChattyDukeException e){
            System.out.println(e.getMessage());

        }

    }



}
