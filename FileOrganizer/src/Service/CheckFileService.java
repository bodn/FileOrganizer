package Service;

import Constants.FileOrganizerConstants;
import Type.CheckFile;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CheckFileService {
    private File file;

    public CheckFile obtainFileDetails(File file) throws IOException {
        if(file.isDirectory()){
            return null;
        }
        CheckFile checkFile = new CheckFile();
        this.file = file;

        checkFile.setLastModified(getFileDate());
        checkFile.setMedia(mediaFileCheck());
        checkFile.setOther(otherFileCheck());
        checkFile.setCheckFile(file);
        return checkFile;
    }

    private boolean otherFileCheck() {
        String fileName = file.getName().toUpperCase();
        if(!fileName.matches(FileOrganizerConstants.MEDIA_FILE_REGEX)) {
            return true;
        }
        else{
            return false;
        }
    }

    private boolean mediaFileCheck() {
        String fileName = file.getName().toUpperCase();
        if(fileName.matches(FileOrganizerConstants.MEDIA_FILE_REGEX)) {
            return true;
        }
        else{
            return false;
        }

    }

    private String getFileDate() throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MMMM");
        String cTime = df.format(new Date(file.lastModified()));
        return cTime != null ? cTime : "Unknown";

    }




}
