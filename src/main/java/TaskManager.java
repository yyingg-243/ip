public class TaskManager {

    public static void handleNewTask(TaskCommand taskCommand, String s1, Task[] taskLists){

        try{
            String[] taskInfo = s1.split(" ",2);

            if(taskInfo.length < 2 || taskInfo[1].trim().isEmpty()){
                throw new ChattyDukeException("Hmmmm, Please include the task description");

            }else{

                switch(taskCommand){

                case TODO:
                    todoTask(s1, taskLists);
                    break;

                case DEADLINE:
                    deadlineTask(s1, taskLists);
                    break;

                case EVENT:
                    eventTask(s1, taskLists);
                    break;
                }
            }

        }catch(ChattyDukeException e){
            System.out.println(e.getMessage());

        }

    }

    public static void eventTask (String s1, Task[] taskLists){

        try{
            String description = s1.split(" ",2)[1];
            String[] taskInfo = description.split("/from", 2);

            String firstPart = taskInfo[0].trim();
            String secondPart = taskInfo[1].trim();

            if(firstPart.length() <= 0){
                throw new ChattyDukeException("Oh no! You forget about the task description!");

            }else if(secondPart.length() <= 0){
                throw new ChattyDukeException("Oh no! You forget about the task time description!");
            }

            String[] dateDetails = secondPart.split("/to", 2);

            String fromDescription = dateDetails[0].trim();
            String toDescription = dateDetails[1].trim();

            if(fromDescription.length() <= 0 && toDescription.length() <= 0){
                throw new ChattyDukeException("Oh no! You forget about the both from & to description!");

            }else if(fromDescription.length() <= 0){
                throw new ChattyDukeException("Hmmm! When do you what to start this event?");

            }else if(toDescription.length() <= 0){
                throw new ChattyDukeException("Hmm! So, when would you like this event to end?");
            }



            taskLists[ChattyDuke.inputCount] = new Event(firstPart, fromDescription, toDescription);
            Task t = taskLists[ChattyDuke.inputCount];

            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.ADDED_TASK);
            System.out.println(ChattyDuke.INDENTATION + t.toString());

            ChattyDuke.inputCount++;
            System.out.println(ChattyDuke.INDENTATION + "Now you have " + ChattyDuke.inputCount + " tasks in the list.");



        }catch(ChattyDukeException e){
            System.out.println(e.getMessage());

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid format! Please follow the correct format:\n" +
                    " event {task} /from {details} /to {details}");

        }

    }

    public static void deadlineTask(String s1, Task[] taskLists){

        try{
            String description = s1.split(" ",2)[1];
            String[] taskInfo = description.split("/by", 2);

            String firstPart = taskInfo[0].trim();
            String secondPart = taskInfo[1].trim();

            if(firstPart.length() <= 0 && secondPart.length() <= 0) {

                throw new ChattyDukeException("Dang! You forget both the task description & deadline!");

            }else if(firstPart.length() <= 0){

                throw new ChattyDukeException("Oh no! You forget about the task description!");

            }else if (secondPart.length() <= 0){

                throw new ChattyDukeException("OOPS! Please include the deadline");

            }else{

                taskLists[ChattyDuke.inputCount] = new Deadline(firstPart, secondPart);
                Task t = taskLists[ChattyDuke.inputCount];

                System.out.println(ChattyDuke.INDENTATION + ChattyDuke.ADDED_TASK);
                System.out.println(ChattyDuke.INDENTATION + t.toString());

                ChattyDuke.inputCount++;
                System.out.println(ChattyDuke.INDENTATION + "Now you have " + ChattyDuke.inputCount + " tasks in the list.");

            }

        }catch(ChattyDukeException e){
            System.out.println(e.getMessage());

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("OOPS! Please include '/by' followed by the deadline");

        }

    }

    public static void todoTask(String s1, Task[] taskLists){


        String taskInfo = s1.split(" ", 2)[1];
        taskLists[ChattyDuke.inputCount] = new Task(taskInfo);
        Task t = taskLists[ChattyDuke.inputCount];

        System.out.println(ChattyDuke.INDENTATION + ChattyDuke.ADDED_TASK);
        System.out.println(ChattyDuke.INDENTATION + t.toString());

        ChattyDuke.inputCount++;
        System.out.println(ChattyDuke.INDENTATION + "Now you have " + ChattyDuke.inputCount + " tasks in the list.");
    }

    public static void listTask(Task[] taskLists){
        System.out.println(ChattyDuke.INDENTATION + "Here are the tasks in your list:");
        for(int i = 0; i < ChattyDuke.inputCount; i++){
            Task t = taskLists[i];
            int index = i + 1;
            System.out.println(ChattyDuke.INDENTATION + index + "." + t);

        }
        System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
        System.out.println();
    }

    public static void markTask(String s1, Task[] taskLists){
        String[] splitInput = s1.split(" ");

        try{
            int taskNumber = Integer.parseInt(splitInput[1]);
            Task t = taskLists[taskNumber - 1];
            t.markAsDone();
            System.out.println(ChattyDuke.INDENTATION + "Nice! I've marked this task as done:");
            System.out.println(ChattyDuke.INDENTATION + t);

        }catch(ArrayIndexOutOfBoundsException | NullPointerException e){
            System.out.println(ChattyDukeException.INVALID_NUMBER_MESSAGE);

        }catch(NumberFormatException e){
            System.out.println(ChattyDukeException.ENTER_INTEGER_MESSAGE);

        }finally{
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
            System.out.println();

        }

    }

    public static void unmarkTask(String s1, Task[] taskLists){
        String[] splitInput = s1.split(" ");

        try{
            int taskNumber = Integer.parseInt(splitInput[1]);
            Task t = taskLists[taskNumber - 1];
            t.unmark();
            System.out.println(ChattyDuke.INDENTATION + "OK, I've marked this task as not done yet:");
            System.out.println(ChattyDuke.INDENTATION + t);


        }catch(ArrayIndexOutOfBoundsException | NullPointerException e){
            System.out.println(ChattyDukeException.INVALID_NUMBER_MESSAGE);

        }catch(NumberFormatException e){
            System.out.println(ChattyDukeException.ENTER_INTEGER_MESSAGE);

        }finally{
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
            System.out.println();

        }


    }



}
