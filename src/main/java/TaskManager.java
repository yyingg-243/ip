public class TaskManager {

    public static void eventTask (String s1, Task[] taskLists){
        String taskInfo = s1.split(" ", 2)[1];
        int index = taskInfo.indexOf("/");
        String firstPart = taskInfo.substring(0,index);
        String secondPart = taskInfo.substring(index + 6,taskInfo.length());

        int secondSlash = secondPart.indexOf("/");
        String from = secondPart.substring(0, secondSlash);
        String to = secondPart.substring(secondSlash + 4, secondPart.length());


        taskLists[ChattyDuke.inputCount] = new Event(firstPart, from, to);
        Task t = taskLists[ChattyDuke.inputCount];

        System.out.println(ChattyDuke.INDENTATION + ChattyDuke.ADDED_TASK);
        System.out.println(ChattyDuke.INDENTATION + t.toString());

        ChattyDuke.inputCount++;
        System.out.println(ChattyDuke.INDENTATION + "Now you have " + ChattyDuke.inputCount + " tasks in the list.");

    }

    public static void deadlineTask(String s1, Task[] taskLists){
        String taskInfo = s1.split(" ", 2)[1];
        int index = taskInfo.indexOf("/");
        String firstPart = taskInfo.substring(0,index);
        String secondPart = taskInfo.substring(index + 4,taskInfo.length());

        taskLists[ChattyDuke.inputCount] = new Deadline(firstPart, secondPart );
        Task t = taskLists[ChattyDuke.inputCount];

        System.out.println(ChattyDuke.INDENTATION + ChattyDuke.ADDED_TASK);
        System.out.println(ChattyDuke.INDENTATION + t.toString());

        ChattyDuke.inputCount++;
        System.out.println(ChattyDuke.INDENTATION + "Now you have " + ChattyDuke.inputCount + " tasks in the list.");

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
}
