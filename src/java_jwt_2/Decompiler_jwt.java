/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jwt_2;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

/**
 *
 * @author fidel.villero
 */
public class Decompiler_jwt {
    
    
    public static void decompiler(String token) throws NoSuchAlgorithmException,
            InvalidKeyException, IOException, JWTVerifyException, SignatureException {
        Map<String, Object> decodedData = null;
        try {
            decodedData = new JWTVerifier("17secret").verify(token);
        //} catch (IllegalStateException illegalStateException) {
        } catch (Exception illegalStateException) {
            System.err.println("Invalid Token! " + illegalStateException);
        }
        System.out.println("Data del token:"+decodedData);
        
    }
    
}
