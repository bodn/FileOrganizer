package application;


import service.BaseService;
import service.RetrieveFileService;

import java.util.List;

public class FileOrganizer {
    public static void main(String args[]){

        System.out.println("Starting main application...");

        //file path is the path to the directory that needs to be organized
        final String filePath = "C:\\Users\\steve\\Desktop\\FileDump";
        System.out.println("Working directory: "+filePath);

        //output path is the new directory containing the organized files
        final String outputPath = "C:\\Users\\steve\\Desktop\\SortedDump";
        System.out.println("Output path: "+outputPath);

        BaseService.init(filePath, outputPath);


    }
}
