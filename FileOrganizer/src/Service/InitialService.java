package Service;

import Constants.FileOrganizerConstants;
import Validators.FileValidator;

import java.io.File;


/**
 * Setup the working directory if not already, for correct execution
 * @author Steven Bodnar
 */
public class InitialService {
    public static void init() {
        System.out.println("INITIALIZE:: Checking if working directories have been created..");
        File workingDirectory = new File(FileOrganizerConstants.DIRECTORY_PATH);

        //Validate the file against rules
        FileValidator fileValidator = new FileValidator(workingDirectory);
        //Once we validated create the required working directories
        if (fileValidator.getIsValid()) {

            File loadDirectoryFile = new File(FileOrganizerConstants.LOAD_DIRECTORY_PATH);
            boolean loadDirectory = loadDirectoryFile.mkdirs();

            File mediaDirectoryFile = new File(FileOrganizerConstants.MEDIA_DIRECTORY_PATH);
            boolean mediaDirectory = mediaDirectoryFile.mkdirs();

            File otherDirectoryFile = new File(FileOrganizerConstants.OTHER_DIRECTORY_PATH);
            boolean otherDirectory = otherDirectoryFile.mkdirs();

            checkIfExists(loadDirectory, FileOrganizerConstants.LOAD_DIRECTORY_NAME);
            checkIfExists(mediaDirectory, FileOrganizerConstants.MEDIA_DIRECTORY_NAME);
            checkIfExists(otherDirectory, FileOrganizerConstants.OTHER_DIRECTORY_NAME);

            System.out.println("INITIALIZE:: Directories validation complete - starting main application..\n");

            return;
        }

        System.out.println("INITIALIZE:: INITIALIZATION FAILED - CANNOT WORK WITH THIS FILE.");



    }

    private static void checkIfExists(boolean newDirectory, String directoryName) {
        if(newDirectory){
            System.out.println(directoryName+" - directory has been created.");
        }
        else {
            System.out.println(directoryName+" - directory already exists.");
        }
    }
}