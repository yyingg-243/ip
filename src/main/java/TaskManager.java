import java.util.ArrayList;

public class TaskManager {


    public void createEvent (String s1, ArrayList<Task> taskLists){

        try{
            String description = s1.split(" ",2)[1];
            String[] taskInfo = description.split("/from", 2);

            String taskDetail = taskInfo[0].trim();
            String timeline = taskInfo[1].trim();

            if(taskDetail.length() <= 0){
                throw new ChattyDukeException("Oh no! You forget about the task description!");

            }else if(timeline.length() <= 0){
                throw new ChattyDukeException("Oh no! You forget about the task time description!");
            }

            String[] dateDetails = timeline.split("/to", 2);

            String fromDescription = dateDetails[0].trim();
            String toDescription = dateDetails[1].trim();

            if(fromDescription.length() <= 0 && toDescription.length() <= 0){
                throw new ChattyDukeException("Oh no! You forget about the both from & to description!");

            }else if(fromDescription.length() <= 0){
                throw new ChattyDukeException("Hmmm! When do you what to start this event?");

            }else if(toDescription.length() <= 0){
                throw new ChattyDukeException("Hmm! So, when would you like this event to end?");
            }



            taskLists.add(new Event(taskDetail, fromDescription, toDescription));
            Task task = taskLists.get(taskLists.size() - 1);

            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.ADDED_TASK);
            System.out.println(ChattyDuke.INDENTATION + task.toString());

            System.out.println(ChattyDuke.INDENTATION + "Now you have " + taskLists.size() + " tasks in the list.");



        }catch(ChattyDukeException e){
            System.out.println(e.getMessage());

        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid format! Please follow the correct format:\n" +
                    " event {task} /from {details} /to {details}");


        }

    }

    public void createDeadline(String s1, ArrayList<Task> taskLists){

        try{
            String description = s1.split(" ",2)[1];
            String[] taskInfo = description.split("/by", 2);

            String taskDetail = taskInfo[0].trim();
            String timeline = taskInfo[1].trim();

            if(taskDetail.length() <= 0 && timeline.length() <= 0) {

                throw new ChattyDukeException("Dang! You forget both the task description & deadline!");

            }else if(taskDetail.length() <= 0){

                throw new ChattyDukeException("Oh no! You forget about the task description!");

            }else if (timeline.length() <= 0){

                throw new ChattyDukeException("OOPS! Please include the deadline");

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
            System.out.println("OOPS! Please include '/by' followed by the deadline");

        }

    }

    public void createTodo(String s1, ArrayList<Task> taskLists){


        String taskInfo = s1.split(" ", 2)[1];
        taskLists.add(new Task(taskInfo));
        Task task = taskLists.get(taskLists.size() - 1);

        System.out.println(ChattyDuke.INDENTATION + ChattyDuke.ADDED_TASK);
        System.out.println(ChattyDuke.INDENTATION + task.toString());


        System.out.println(ChattyDuke.INDENTATION + "Now you have " + taskLists.size() + " tasks in the list.");
    }

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

    public void markTask(String s1, ArrayList<Task> taskLists){
        String[] splitInput = s1.split(" ");

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

    public void unmarkTask(String s1, ArrayList<Task> taskLists){
        String[] splitInput = s1.split(" ");

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

    public void deleteTask(String s1, ArrayList<Task> taskLists){
        String[] splitInput = s1.split(" ");

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

    public void findTask(String s1, ArrayList<Task> taskLists){

        int index = 1;
        boolean itemFound = false;
        try{
            String itemToFind = s1.split(" ")[1];
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
