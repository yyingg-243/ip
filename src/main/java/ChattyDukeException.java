public class ChattyDukeException extends Exception {
    public static final String INVALID_NUMBER_MESSAGE = "Invalid task number! Please try again :(";
    public static final String ENTER_INTEGER_MESSAGE= "Please enter integers instead of strings!";
    public static final String MISSING_ITEM_TO_FIND_MESSAGE= "Please specify what to find!";


    public ChattyDukeException (String message){
        super(message);
    }

}
