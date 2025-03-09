import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {

    private String filePath;
    private String folderDirectory;
    private String finalDirectory;

    public Storage(String filePath){
        this.filePath = filePath;
    }

    public void setDirectory(){
        System.out.println(filePath);

        String folderName = filePath.split("/")[0];
        String fileName = filePath.split("/")[1];
        String currentDirectory = System.getProperty("user.dir");
        folderDirectory = currentDirectory + File.separator + folderName;
        finalDirectory = folderDirectory + File.separator + fileName;

        File folder = new File(folderDirectory);
        if(!folder.exists()){
            folder.mkdirs();
        }

    }

    public void saveToFile(ArrayList<Task> taskLists){

        try{
            File file = new File(finalDirectory);
            FileWriter writer = new FileWriter(file);

            for( Task lines: taskLists){
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

                //String description = line.split(" ", 3)[2];

                //taskLists.add(new Task(description));
            }

        }catch(IOException e){
            System.out.println("OOPS! Error in printing saved tasks.");
        }finally{
            System.out.println(ChattyDuke.INDENTATION + ChattyDuke.LINE_SEPARATOR);
            System.out.println();

        }
        return taskLists;

    }

    public void saveAccordingTaskType(String taskCommand, String inputString, ArrayList<Task> taskLists){
        String description = inputString.split(" ", 3)[2];
        if(taskCommand.equalsIgnoreCase( "T")){
            taskLists.add(new Task(description));

        }else if (taskCommand.equalsIgnoreCase( "D")){
            String[] taskInfo = description.split("\\(by:", 2);
            String taskDetail = taskInfo[0].trim();
            String timeline = taskInfo[1].substring(0, taskInfo[1].length() - 1).trim();
            taskLists.add(new Deadline(taskDetail, timeline));

        }else if (taskCommand.equalsIgnoreCase("E")){

            String[] taskInfo = description.split("\\(from:", 2);
            String taskDetail = taskInfo[0].trim();
            String timeline = taskInfo[1].trim();

            String[] dateDetails = timeline.split("to:", 2);

            String fromDescription = dateDetails[0].trim();
            String toDescription = dateDetails[1].substring(0, dateDetails[1].length() - 1).trim();

            taskLists.add(new Event(taskDetail, fromDescription, toDescription));

        }

    }
}
