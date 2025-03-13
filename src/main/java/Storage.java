import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class that manages the saving and loading process of the arraylist.
 */
public class Storage {

    private String filePath;
    private String folderDirectory;
    private String finalDirectory;

    private final static String TODO_TASK = "T";
    private final static String DEADLINE_TASK = "D";
    private final static String EVENT_TASK = "E";


    /**
     * Constructor of the storage class.
     * @param filePath File directory to save remaining task in the taskList.
     */
    public Storage(String filePath){
        this.filePath = filePath;
    }

    /**
     * Check and create new directory if the file path given does not exist.
     */
    public void setDirectory(){

        String[] pathSplit = filePath.split("/");
        if(pathSplit.length < 2){
            throw new IllegalArgumentException(ChattyDukeException.INVALID_FILEPATH_MESSAGE);
        }

        String folderName = pathSplit[0].trim();
        String fileName = pathSplit[1].trim();
        String currentDirectory = System.getProperty("user.dir");
        folderDirectory = currentDirectory + File.separator + folderName;
        finalDirectory = folderDirectory + File.separator + fileName;

        File folder = new File(folderDirectory);
        if(!folder.exists()){
            boolean isCreate = folder.mkdirs();
            if(!isCreate){
                throw new RuntimeException("Failed to create directory!" );
            }
        }

    }

    /**
     * Save remaining tasks in the taskList into the file path given.
     * @param taskLists an arraylist that store all the tasks.
     */
    public void saveToFile(ArrayList<Task> taskLists){

        try{
            File file = new File(finalDirectory);
            FileWriter writer = new FileWriter(file);

            for(Task lines: taskLists){
                writer.write(lines + "\n");
            }

            writer.close();

        }catch(IOException e){
            System.out.println("OOPS! Error in saving changes");

        }finally{
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
            System.out.println();
        }
    }

    /**
     * Return an arraylist by loading tasks saved in the hard disk into the arraylist.
     * @param taskLists an arraylist that store all the tasks.
     * @return a new arraylist to store tasks.
     * @throws ChattyDukeException if the directory does not exist.
     */
    public ArrayList<Task> loadToFile(ArrayList<Task> taskLists) throws ChattyDukeException {

        File file = new File(finalDirectory);

        if(!file.exists()){
            throw new ChattyDukeException("File not found, no previous saved data!");
        }

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){

                String taskCommand = Character.toString(line.charAt(1));
                saveAccordingTaskType(taskCommand,line, taskLists);
            }

        }catch(IOException e){
            System.out.println("OOPS! Error in printing saved tasks.");
        }finally{
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
            System.out.println();
        }
        return taskLists;
    }

    /**
     * Save the data according to the command type.
     * @param taskCommand command type entered by user.
     * @param inputString a sentence that describe the task.
     * @param taskLists an arraylist that stores all the tasks.
     */
    public void saveAccordingTaskType(String taskCommand, String inputString, ArrayList<Task> taskLists){
        boolean isDone;
        String description;
        Task task;

        if(inputString.charAt(4) == 'X'){
            isDone = true;
            description = inputString.split(" ", 2)[1];
        }else{
            isDone = false;
            description = inputString.split(" ", 3)[2];
        }

        if(taskCommand.equalsIgnoreCase( TODO_TASK)){
            taskLists.add(new Task(description));
            task = taskLists.get(taskLists.size() - 1);

            if(isDone){
                task.markAsDone();
            }else{
                task.unmark();
            }

        }else if (taskCommand.equalsIgnoreCase( DEADLINE_TASK)){
            String[] taskInfo = description.split("\\(by:", 2);
            String taskDetail = taskInfo[0].trim();
            String timeline = taskInfo[1].substring(0, taskInfo[1].length() - 1).trim();
            taskLists.add(new Deadline(taskDetail, timeline));
            task = taskLists.get(taskLists.size() - 1);

            if(isDone){
                task.markAsDone();
            }else{
                task.unmark();
            }


        }else if (taskCommand.equalsIgnoreCase(EVENT_TASK)){

            String[] taskInfo = description.split("\\(from:", 2);
            String taskDetail = taskInfo[0].trim();
            String timeline = taskInfo[1].trim();

            String[] dateDetails = timeline.split("to:", 2);

            String fromDescription = dateDetails[0].trim();
            String toDescription = dateDetails[1].substring(0, dateDetails[1].length() - 1).trim();

            taskLists.add(new Event(taskDetail, fromDescription, toDescription));
            task = taskLists.get(taskLists.size() - 1);

            if(isDone){
                task.markAsDone();
            }else{
                task.unmark();
            }
        }



    }
}
