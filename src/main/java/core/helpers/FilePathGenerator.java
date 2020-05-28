package core.helpers;

import java.io.File;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class FilePathGenerator {

    public static String generateFilePath(final String fileName) {
        final String fullFileName = addJsonToEndOfName(fileName);
        File directoryWithFiles = new File(Constants.JSON_PACKAGE_PATH);
        File foundFile = findFileInDirectory(directoryWithFiles, fullFileName);
        return foundFile.getPath();
    }

    private static String addJsonToEndOfName(final String fileName) {
        return fileName + ".json";
    }

    private static File findFileInDirectory(final File directory, final String fileName) {
        try {
            return Arrays.stream(directory.listFiles())
                    .filter(x -> x.getPath().equals(Constants.JSON_PACKAGE_PATH + fileName))
                    .findAny().get();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("No any match found in JSON directory", e);
        }
    }
}
