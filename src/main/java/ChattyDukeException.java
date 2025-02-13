public class ChattyDukeException extends Exception {
    public static final String INVALID_NUMBER_MESSAGE = "Invalid task number! Please try again :(";
    public static final String ENTER_INTEGER_MESSAGE= "Please enter integers instead of strings!";

    public ChattyDukeException (String message){
        super(message);
    }

}
