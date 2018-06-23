package service;

import entity.MediaFile;

import java.io.File;
import java.util.List;

/**
 * Created by steve on 6/23/2018.
 */
public class BaseService {

    private List<MediaFile> mediaFiles;

    public static void init(String filePath, String outputPath){
        List<File> retrievedFile = RetrieveFileService.obtainFiles(filePath);

        if(retrievedFile != null){
            SortFileService.sortFiles(retrievedFile);
        }
    }


}
