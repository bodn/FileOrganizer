package Service;
import Constants.FileOrganizerConstants;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve on 7/13/2018.
 */
public class CleanFileService {
    public static void cleanLoad(File workingDir) throws IOException {
        List<File> retrievedDir = new ArrayList<>();
        Files.walk(workingDir.toPath()).forEach(file ->{
            if(!file.toFile().isDirectory()){
                return;
            }
            else {
                retrievedDir.add(file.toFile());
            }

        });
        retrievedDir.remove(0);
        System.out.println("Removing the " + retrievedDir.size() +" empty folder(s).");
        if(retrievedDir.size() > 0){
            checkContents(retrievedDir.get(0));
        }

    }

    /**
     * Recursive function to parse the contents of the folders and delete any
     * subfolders that may exist inside
     * If the folder contains any files other than
     * @param file
     * @throws IOException
     */
    private static void checkContents(File file) throws IOException {

        if(file == null){
            return;
        }
        if(file.listFiles().length != 0){
            for (File f : file.listFiles()){
                if(f.isDirectory()){
                    checkContents(f);
                }
                else{
                    throw new FileSystemException(f.getName() +" is not empty!");
                }

            }
        }
        Files.delete(file.toPath());
    }
}
