import java.util.ArrayList;

/**
 * A class that handle the command type entered by user.
 */
public class TaskManager {

    /**
     * Method to create new event task and save it to the arraylist.
     * @param userInput a sentence entered by the user.
     * @param taskLists an arraylist that stores all the tasks.
     */
    public void createEvent (String userInput, ArrayList<Task> taskLists){

        try{
            String description = userInput.split(" ",2)[1];
            String[] taskInfo = description.split("/from", 2);

            String taskDetail = taskInfo[0].trim();
            String timeline = taskInfo[1].trim();

            if(taskDetail.length() <= 0){
                throw new ChattyDukeException(ChattyDukeException.MISSING_TASK_DESCRIPTION_MESSAGE);

            }else if(timeline.length() <= 0){
                throw new ChattyDukeException(ChattyDukeException.MISSING_TASK_TIME_DESCRIPTION_MESSAGE);
            }

            String[] dateDetails = timeline.split("/to", 2);
            String fromDescription = dateDetails[0].trim();
            String toDescription = dateDetails[1].trim();

            if(fromDescription.length() <= 0 && toDescription.length() <= 0){
                throw new ChattyDukeException(ChattyDukeException.MISSING_BOTH_TASK_TIME_DESCRIPTION);

            }else if(fromDescription.length() <= 0){
                throw new ChattyDukeException(ChattyDukeException.MISSING_FROM_DESCRIPTION);

            }else if(toDescription.length() <= 0){
                throw new ChattyDukeException(ChattyDukeException.MISSING_TO_DESCRIPTION);
            }

            taskLists.add(new Event(taskDetail, fromDescription, toDescription));
            Task task = taskLists.get(taskLists.size() - 1);

            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.ADDED_TASK);
            System.out.println(ChattyDuke.INDENTATION + task.toString());
            System.out.println(ChattyDuke.INDENTATION + "Now you have " + taskLists.size() + " tasks in the list.");

        }catch(ChattyDukeException e){
            System.out.println(e.getMessage());

        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(ChattyDukeException.INVALID_EVENT_TASK_FORMAT);

        }

    }

    /**
     * Method to create new deadline tasks and save it to the arraylist.
     * @param userInput a sentence entered by the user.
     * @param taskLists an arraylist that stores all the tasks.
     */
    public void createDeadline(String userInput, ArrayList<Task> taskLists){

        try{
            String description = userInput.split(" ",2)[1];
            String[] taskInfo = description.split("/by", 2);

            String taskDetail = taskInfo[0].trim();
            String timeline = taskInfo[1].trim();

            if(taskDetail.length() <= 0 && timeline.length() <= 0) {

                throw new ChattyDukeException(ChattyDukeException.MISSING_BOTH_TASK_TIME_DESCRIPTION);

            }else if(taskDetail.length() <= 0){

                throw new ChattyDukeException(ChattyDukeException.MISSING_TASK_DESCRIPTION_MESSAGE);

            }else if (timeline.length() <= 0){

                throw new ChattyDukeException(ChattyDukeException.MISSING_DEADLINE);

            }else{

                taskLists.add(new Deadline(taskDetail, timeline));
                Task task = taskLists.get(taskLists.size() - 1);

                System.out.println(ChattyDuke.INDENTATION + ChattyDuke.ADDED_TASK);
                System.out.println(ChattyDuke.INDENTATION + task.toString());
                System.out.println(ChattyDuke.INDENTATION + "Now you have " + taskLists.size() + " tasks in the list.");
            }
        }catch(ChattyDukeException e){
            System.out.println(e.getMessage());

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(ChattyDukeException.INVALID_DEADLINE_TASK_FORMAT);

        }
    }

    /**
     * Method to create new todo tasks and save it to the arraylist.
     * @param userInput a sentence entered by the user.
     * @param taskLists an arraylist that stores all the tasks.
     */
    public void createTodo(String userInput, ArrayList<Task> taskLists){


        String taskInfo = userInput.split(" ", 2)[1];
        taskLists.add(new Task(taskInfo));
        Task task = taskLists.get(taskLists.size() - 1);

        System.out.println(ChattyDuke.INDENTATION + ChattyDuke.ADDED_TASK);
        System.out.println(ChattyDuke.INDENTATION + task.toString());


        System.out.println(ChattyDuke.INDENTATION + "Now you have " + taskLists.size() + " tasks in the list.");
    }

    /**
     * Method to list all the tasks stores in the taskLists.
     * @param taskLists an arraylist that stores all the tasks.
     */
    public void listTask(ArrayList<Task> taskLists){
        System.out.println(ChattyDuke.INDENTATION + "Here are the tasks in your list:");


        for(int i = 0; i < taskLists.size(); i++){
            Task task = taskLists.get(i);
            int index = i + 1;
            System.out.println(ChattyDuke.INDENTATION + index + "." + task);

        }
        System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
        System.out.println();
    }

    /**
     * Mark specific task as done.
     * @param userInput a sentence entered by the user.
     * @param taskLists an arraylist that stores all the tasks.
     */
    public void markTask(String userInput, ArrayList<Task> taskLists){
        String[] splitInput = userInput.split(" ");

        try{
            int taskNumber = Integer.parseInt(splitInput[1]);
            Task task = taskLists.get(taskNumber - 1);
            task.markAsDone();
            System.out.println(ChattyDuke.INDENTATION + "Nice! I've marked this task as done:");
            System.out.println(ChattyDuke.INDENTATION + task);

        }catch(IndexOutOfBoundsException | NullPointerException e){
            System.out.println(ChattyDukeException.INVALID_NUMBER_MESSAGE);

        }catch(NumberFormatException e){
            System.out.println(ChattyDukeException.ENTER_INTEGER_MESSAGE);

        }finally{
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
            System.out.println();

        }
    }

    /**
     * Mark specific task as undone.
     * @param userInput a sentence entered by the user.
     * @param taskLists an arraylist that stores all the tasks.
     */
    public void unmarkTask(String userInput, ArrayList<Task> taskLists){
        String[] splitInput = userInput.split(" ");

        try{
            int taskNumber = Integer.parseInt(splitInput[1]);
            Task task = taskLists.get(taskNumber - 1);
            task.unmark();
            System.out.println(ChattyDuke.INDENTATION + "OK, I've marked this task as not done yet:");
            System.out.println(ChattyDuke.INDENTATION + task);

        }catch(IndexOutOfBoundsException | NullPointerException e){
            System.out.println(ChattyDukeException.INVALID_NUMBER_MESSAGE);

        }catch(NumberFormatException e){
            System.out.println(ChattyDukeException.ENTER_INTEGER_MESSAGE);

        }finally{
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
            System.out.println();
        }
    }

    /**
     * Delete specific task from the taskLists.
     * @param userInput a sentence entered by user.
     * @param taskLists an arraylist that stores all the tasks.
     */
    public void deleteTask(String userInput, ArrayList<Task> taskLists){
        String[] splitInput = userInput.split(" ");

        try{
            int taskNumber = Integer.parseInt(splitInput[1]);
            Task task = taskLists.remove(taskNumber - 1);

            System.out.println(ChattyDuke.INDENTATION + "Noted. I've removed this task:");
            System.out.println(ChattyDuke.INDENTATION + task);
            System.out.println(ChattyDuke.INDENTATION + "Now you have " + taskLists.size() + " tasks in the list.");

        }catch(IndexOutOfBoundsException | NullPointerException e){
            System.out.println(ChattyDukeException.INVALID_NUMBER_MESSAGE);

        }catch(NumberFormatException e){
            System.out.println(ChattyDukeException.ENTER_INTEGER_MESSAGE);

        }finally{
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
            System.out.println();

        }

    }

    /**
     * Search for tasks according to the keyword given by user.
     * @param userInput a sentence entered by user.
     * @param taskLists an arraylist that stores all the tasks.
     */
    public void findTask(String userInput, ArrayList<Task> taskLists){

        int index = 1;
        boolean itemFound = false;
        try{
            String itemToFind = userInput.split(" ")[1];
            System.out.println(ChattyDuke.INDENTATION + "Here are the matching tasks in your list: ");

            for (Task task: taskLists){
                if(task.getDescription().contains(itemToFind)){
                    itemFound = true;
                    System.out.println(index + ". " + task);
                    index++;
                }
            }

            if(!itemFound){
                System.out.println(ChattyDuke.INDENTATION + "No matching tasks found!");
                System.out.println(ChattyDuke.INDENTATION + "** Find function is case sensitive **");
            }

        }catch(IndexOutOfBoundsException e){
            System.out.println(ChattyDukeException.MISSING_ITEM_TO_FIND_MESSAGE);

        }finally{
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
            System.out.println();

        }
    }
}
