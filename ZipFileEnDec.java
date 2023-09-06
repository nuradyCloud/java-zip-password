import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import static utils.security.decryptedFile;
import static utils.security.encryptedFile;

/**
 * @author xcloud7 on 06/09/23,14.03
 */
public class ZipFileEnDec {
    public static void main(String[] args) {
        try {

            ZipParameters zipParameters = new ZipParameters();

            zipParameters.setCompressionMethod(CompressionMethod.DEFLATE);
            zipParameters.setCompressionLevel(CompressionLevel.FAST);
            zipParameters.setEncryptFiles(true);
            zipParameters.setEncryptionMethod(EncryptionMethod.AES);
            zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);

            ArrayList<File> filesToAdd = new ArrayList<File>();
            String secretKey = "H!B4nk";
            String saltKey = "ayomaju";
            String secretKeyZip = "kambinghitam";

            System.out.println("File input: " + "sample_file/cobaan.xlsx");

            //encryptedFile
            encryptedFile(secretKey, saltKey, "sample_file/cobaan.xlsx", "sample_file/cobaan.enc");

            //decryptedFile
            decryptedFile(secretKey, saltKey,"sample_file/cobaan.enc", "sample_file/cobaan-decrypt.xlsx");

            filesToAdd.add(new File("sample_file/cobaan.xlsx"));
            filesToAdd.add(new File("sample_file/cobaan.enc"));
            filesToAdd.add(new File("sample_file/cobaan-decrypt.xlsx"));

            String destinationZipFilePath = "sample_file/myZip_pass.zip";
            ZipFile zipFile = new ZipFile(destinationZipFilePath,secretKeyZip.toCharArray());
            zipFile.addFiles(filesToAdd, zipParameters);

            System.out.println("Password protected Zip file"
                    + "have been created at "  + destinationZipFilePath);

        } catch (ZipException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
