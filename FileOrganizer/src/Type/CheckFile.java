package Type;

import Constants.FileOrganizerConstants;

import java.io.File;

/**
 * Object used to contain all the details of the check file
 * Created by steve on 7/8/2018.
 */
public class CheckFile {

    private File checkFile;
    private boolean isMedia;
    private boolean isOther;
    private String lastModified;



    public File generatePath(){
        File newFile;
        if(isMedia()){

            new File(FileOrganizerConstants.MEDIA_DIRECTORY_PATH+"\\"+lastModified+"\\").mkdir();
            newFile = new File(FileOrganizerConstants.MEDIA_DIRECTORY_PATH+"\\"+lastModified+"\\"+checkFile.getName());
            return newFile;
        }
        if(isOther){
            new File(FileOrganizerConstants.OTHER_DIRECTORY_PATH+"\\"+lastModified+"\\").mkdir();
            newFile = new File(FileOrganizerConstants.OTHER_DIRECTORY_PATH+"\\"+lastModified+"\\"+checkFile.getName());
            return newFile;
        }

        return null;
    }

    public File getCheckFile() {
        return checkFile;
    }

    public void setCheckFile(File checkFile) {
        this.checkFile = checkFile;
    }

    public boolean isMedia() {
        return isMedia;
    }

    public void setMedia(boolean media) {
        isMedia = media;
    }

    public boolean isOther() {
        return isOther;
    }

    public void setOther(boolean other) {
        isOther = other;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

}
