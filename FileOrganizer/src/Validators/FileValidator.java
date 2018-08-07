package Validators;

import java.io.File;

/**
 * Class to perform validation on the given file
 * and make sure the file passes requirements
 * @author Steven Bodnar
 */
public class FileValidator {
    private File file;
    private boolean isValid;
    private boolean isDirectory;
    private boolean isNotEmpty;
    private boolean canReadAndWrite;

    public FileValidator(File file) {
        this.file = file;
        isValid = performValidation();
    }

    private boolean performValidation() {
        if (file.canRead() && file.canWrite()) {
            canReadAndWrite = true;
            if (file.isDirectory()) {

                isDirectory = true;

                if (file.listFiles().length > 0) {

                    isNotEmpty = true;

                }

            }
        }
        if (canReadAndWrite && isDirectory & isNotEmpty) {
            return true;
        }
        else{
            return true;
        }
    }

    public boolean getIsValid(){
        return isValid;
    }
}

