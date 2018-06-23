package service;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve on 6/23/2018.
 */
public class SortFileService {

    public static void sortFiles(List<File> retrievedFiles) {
        List<File> mediaFiles = new ArrayList<>();
        List<File> otherFiles = new ArrayList<>();
        for (File file : retrievedFiles) {
            if (isMediaFile(file)){
                mediaFiles.add(file);
            }
            else{
                otherFiles.add(file);
            }

        }

    }




    private static boolean isMediaFile(File file) {
        //BasicFileAttributes attr = Files.readAttributes(file.getPath(), BasicFileAttributes.class);
        if (file.isFile()) {
            String fileName = file.getName().toLowerCase();
            if(fileName.matches(".*\\.jpg||.*\\.png||.*\\.jpeg||.*\\.cr2||.*\\.mov||.*\\.mpg4")){
               return true;
            }
        }
        return false;
    }
}
