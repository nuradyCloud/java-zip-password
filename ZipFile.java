import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author xcloud7 on 06/09/23,11.07
 */
public class ZipFile {

    private static void zipFile(String filePath){
        try {

            File file = new File(filePath);
            String zipFileName = file.getName().concat(".zip");
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);

            zos.putNextEntry(new ZipEntry(file.getName()));
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
            zos.close();
        }
        catch (FileNotFoundException ex) {
            System.err.format("The file does not exist", filePath);
        }
        catch (IOException ex){
            System.err.println("Error: " + ex);
        }
    }

    public static void main(String[] args) {

        String filePath = args[0];

        zipFile(filePath);

    }
}
