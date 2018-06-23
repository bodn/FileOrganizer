package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


/**Service that retrieves all files in the provided directory
 * Created by steve on 6/23/2018.
 */
public class RetrieveFileService {
    public static List<File> obtainFiles(String filePath){

        List<File> retrievedFiles = new ArrayList<>();
        File workingDirectory = new File(filePath);

        if(!workingDirectory.isDirectory() || !workingDirectory.canRead()){
            System.out.println("ERROR: Working directory is invalid.");
            return null;
        }

        System.out.println("\nWorking directory is a valid directory.");
        try {
            Files.walk(workingDirectory.toPath()).forEach(f->retrievedFiles.add(f.toFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return retrievedFiles;
    }

}
