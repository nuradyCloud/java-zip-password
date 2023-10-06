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

import static utils.security.*;

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
            String secretKey = "1234567890asdfghjklmnopqrstupxyz";
            String saltKey = "ayomaju";
            String secretKeyZip = "kambinghitam";

            System.out.println("File input: " + "sample_file/Microsite-20230826-00-46.csv");

            //encryptedFile
//            encryptedFile(secretKey,"sample_file/Microsite-20230826-00-46.csv", "sample_file/Microsite-20230826-00-46_encrypt.csv");
            encryptedFileWithRandomIv(secretKey,"sample_file/Microsite-20230826-00-46.csv", "sample_file/Microsite-20230826-00-46_encrypted.csv");
//            encryptedFileWithIv(secretKey, saltKey, "sample_file/cobaan.xlsx", "sample_file/cobaan.enc");

            //decryptedFile
//            decryptedFile(secretKey,"sample_file/Microsite-20230925-14-25.csv", "sample_file/Microsite-20230925-14-25_decrypt.csv");
            decryptCSVFile(secretKey,"sample_file/Microsite-20230826-00-46_encrypted.csv","sample_file/Microsite-20230826-00-46_decrypted.csv");
//            decryptedFileWithRandomIv(secretKey,"sample_file/Microsite-20231002-23-35_encrypted.csv", "sample_file/Microsite-20231002-23-35_decrypted.csv");
//            decryptedFileWithIv(secretKey, saltKey,"sample_file/cobaan.enc", "sample_file/cobaan-decrypt.xlsx");

//            filesToAdd.add(new File("sample_file/Microsite-20230826-00-48.xlsx"));
//            filesToAdd.add(new File("sample_file/Microsite-20230826-00-48.enc"));
//            filesToAdd.add(new File("sample_file/Microsite-20230826-00-48-decrypt.xlsx"));
//
//            String destinationZipFilePath = "sample_file/myZip_pass.zip";
//            ZipFile zipFile = new ZipFile(destinationZipFilePath,secretKeyZip.toCharArray());
//            zipFile.addFiles(filesToAdd, zipParameters);
//
//            System.out.println("Password protected Zip file"
//                    + "have been created at "  + destinationZipFilePath);

        } catch (ZipException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
