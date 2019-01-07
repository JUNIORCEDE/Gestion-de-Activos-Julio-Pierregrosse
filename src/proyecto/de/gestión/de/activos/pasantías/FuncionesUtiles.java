/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.de.gestión.de.activos.pasantías;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author JUNIORCEDE
 */
public class FuncionesUtiles {

    public String Encriptar(String texto) {

            String secretKey = "qualityinfosolutions"; //llave para encriptar datos
            String base64EncryptedString = "";

            try {

                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
                byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

                SecretKey key = new SecretKeySpec(keyBytes, "DESede");
                Cipher cipher = Cipher.getInstance("DESede");
                cipher.init(Cipher.ENCRYPT_MODE, key);

                byte[] plainTextBytes = texto.getBytes("utf-8");
                byte[] buf = cipher.doFinal(plainTextBytes);
                base64EncryptedString = Base64.encode(buf);

            } catch (Exception ex) {
            }
            return base64EncryptedString;
    }
    
    public String Desencriptar(String textoEncriptado) throws Exception {
 
        String secretKey = "qualityinfosolutions"; //llave para desenciptar datos
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decode(textoEncriptado);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
    
    public int CountResultSet(ResultSet R) throws SQLException{
       int i = 0;
       while(R.next()){
           i++;
       }
       return i;
   }
}
