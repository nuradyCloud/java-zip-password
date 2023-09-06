import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

/**
 * @author xcloud7 on 06/09/23,11.23
 */
public class GFG {

    public static void main(String[] args) {
        try {

            ZipParameters zipParameters = new ZipParameters();

            zipParameters.setCompressionMethod(CompressionMethod.DEFLATE);
            zipParameters.setCompressionLevel(CompressionLevel.FAST);
            zipParameters.setEncryptFiles(true);
            zipParameters.setEncryptionMethod(EncryptionMethod.AES);
            zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);

            ArrayList<File> filesToAdd = new ArrayList<File>();

            filesToAdd.add(new File("/Users/xcloud7/Documents/java_workspace/java-zip-password/sample_file/cobaan.xlsx"));
            filesToAdd.add(new File("/Users/xcloud7/Documents/java_workspace/java-zip-password/sample_file/cobaan.xlsx"));

            String destinationZipFilePath = "/Users/xcloud7/Documents/java_workspace/java-zip-password/sample_file/myZip_pass.zip";
            String secretKey = "kambinghitam";
            ZipFile zipFile = new ZipFile(destinationZipFilePath,secretKey.toCharArray());
            zipFile.addFiles(filesToAdd, zipParameters);

            System.out.println("Password protected Zip file"
                    + "have been created at "  + destinationZipFilePath);

        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

}
