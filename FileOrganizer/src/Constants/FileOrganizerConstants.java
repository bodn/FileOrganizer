package Constants;

/**
 * Class to hold all the programs constants
 * Created by steve on 7/8/2018.
 */
public class FileOrganizerConstants {
    /**
     * The file path for the working directory the program is in <br>
     */
    public static final String DIRECTORY_PATH       = System.getProperty("user.dir");

    public static final String LOAD_DIRECTORY_NAME  = ".load";
    public static final String LOAD_DIRECTORY_PATH  = DIRECTORY_PATH +"\\.load";

    public static final String MEDIA_DIRECTORY_NAME = "Media";
    public static final String MEDIA_DIRECTORY_PATH = DIRECTORY_PATH +"\\Media";

    public static final String OTHER_DIRECTORY_NAME = "Other";
    public static final String OTHER_DIRECTORY_PATH = DIRECTORY_PATH +"\\Other";

    public static final String MEDIA_FILE_REGEX     = ".+\\.JPG||.+\\.CR2||.+\\.PNG||.+\\.JPEG||.+\\.GIF||.+\\.MOV||.+\\.MPG4";

    public static final String BANNER_TEXT          ="  ______  _  _          ____                             _                 \n |  ____|(_)| |        / __ \\                           (_)                \n | |__    _ | |  ___  | |  | | _ __  __ _   __ _  _ __   _  ____ ___  _ __ \n |  __|  | || | / _ \\ | |  | || '__|/ _` | / _` || '_ \\ | ||_  // _ \\| '__|\n | |     | || ||  __/ | |__| || |  | (_| || (_| || | | || | / /|  __/| |   \n |_|     |_||_| \\___|  \\____/ |_|   \\__, | \\__,_||_| |_||_|/___|\\___||_|   \n                                     __/ |                                \n\nAuthor: Steven Bodnar\nVersion: 0.1\nDate: July 2018\n";
}
