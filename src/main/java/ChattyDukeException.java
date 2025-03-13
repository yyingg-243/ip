/**
 * An exception class to handle errors.
 */
public class ChattyDukeException extends Exception {

    public static final String ENTER_INTEGER_MESSAGE = "Please enter integers instead of strings!";

    public static final String MISSING_ITEM_TO_FIND_MESSAGE = "Please specify what to find!";

    public static final String MISSING_TASK_DESCRIPTION_MESSAGE = "Hmmmm, Please include the task description";

    public static final String MISSING_TASK_TIME_DESCRIPTION_MESSAGE =
            "Oh no! You forget about the task time description!" ;

    public static final String MISSING_DEADLINE = "OOPS! Please include the deadline";

    public static final String MISSING_FROM_DESCRIPTION = "Hmmm! When do you what to start this event?";

    public static final String MISSING_TO_DESCRIPTION = "Hmm! So, when would you like this event to end?";

    public static final String MISSING_BOTH_TASK_TIME_DESCRIPTION =
            "Dang! You forget both the task description & deadline!";

    public static final String INVALID_EVENT_TASK_FORMAT = "Invalid format! Please follow the correct format:\n" +
            " event {task} /from {details} /to {details}";

    public static final String INVALID_DEADLINE_TASK_FORMAT = "OOPS! Please include '/by' followed by the deadline.";

    public static final String INVALID_FILEPATH_MESSAGE = "Invalid file path! Please provide a new file path.";

    public static final String INVALID_NUMBER_MESSAGE = "Invalid task number! Please try again :(";


    /**
     * Construct a new exception with a specific error message.
     * @param message details of the error.
     */
    public ChattyDukeException (String message){
        super(message);
    }

}
