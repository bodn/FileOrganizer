package Service;

import Constants.FileOrganizerConstants;
import Type.CheckFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.List;



public class OrganizeFileService {
    public static void organize(File workingDirectory) throws IOException {

        List<File> retrievedFiles = new ArrayList<>();
        Files.walk(workingDirectory.toPath()).forEach(file ->{
            if(!file.toFile().isDirectory()){
                retrievedFiles.add(file.toFile());
            }

        });
        System.out.println(retrievedFiles.size()+" file(s) have been found.");
        CheckFileService checkFileService = new CheckFileService();

        List<String> logMediaFiles = new ArrayList<>();


        System.out.println("Organizing the files...");
        for(File file : retrievedFiles){

            //check the file and determine its fields and details
            //System.out.println("Getting details for -"+file.getName());
            CheckFile checkFile = checkFileService.obtainFileDetails(file);

            if(checkFile != null){
                //System.out.println("Details retrieved....");
                File newFile = checkFile.generatePath();
                if(!newFile.exists()){
                   // System.out.println("File does not already exist in destined folder - moving it to new place.");
                    Files.move(file.toPath(),
                            newFile.toPath());

                }
                else{
                   // System.out.println("File already exists in destined folder - deleting from .load.");
                    Files.delete(file.toPath());
                }
            }
        }

    }




}
