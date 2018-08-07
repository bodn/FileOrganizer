package FileOrganizer;

import Constants.FileOrganizerConstants;
import Service.CleanFileService;
import Service.InitialService;
import Service.OrganizeFileService;

import java.io.IOException;
import java.io.File;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;


/**
 * Class to perform initial start of the main application
 * Created by steve on 7/8/2018.
 */
public class MainApplication {

    public static void main(String args[]) throws IOException {
        System.out.println(FileOrganizerConstants.BANNER_TEXT);
        System.out.println("Setting up File Organizer in the following directory "+ FileOrganizerConstants.DIRECTORY_PATH);
        InitialService.init();
        startApplication();
    }

    /**
     * Walk the load file, if there are files remove from retrieved list and perform operation
     * @throws IOException
     */
    public static void startApplication() throws IOException{

        File workingDirectory = new File(FileOrganizerConstants.LOAD_DIRECTORY_PATH);

        OrganizeFileService.organize(workingDirectory);
        CleanFileService.cleanLoad(workingDirectory);

        //WatchService is used to determine when the directory has any modifications
        WatchService watchService = FileSystems.getDefault().newWatchService();
        WatchKey key = workingDirectory.toPath().register(watchService,
                ENTRY_CREATE);



        while (true){
            for (WatchEvent<?> event: key.pollEvents()){
                System.out.println("Changes have been detected in .load - Organizing the files.");
                OrganizeFileService.organize(workingDirectory);
                System.out.println("OrganizeFiles service is now complete - checking for next modification.");
                CleanFileService.cleanLoad(workingDirectory);
            }
        }
    }
}
