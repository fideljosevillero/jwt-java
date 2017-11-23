/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jwt_2;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
//***
import com.google.gson.Gson;


/**
 *
 * @author fidel.villero
 */
public class Decompiler_jwt {
    
    
    public static void decompiler(String token) throws NoSuchAlgorithmException,
            InvalidKeyException, IOException, JWTVerifyException, SignatureException {
        Map<String, Object> decodedData = null;
        try {
            String KEY = "bm%^Y3UFKt2?@78w";
            decodedData = new JWTVerifier(KEY).verify(token);
        //} catch (IllegalStateException illegalStateException) {
        } catch (Exception illegalStateException) {
            System.err.println("Invalid Token! " + illegalStateException);
        }
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        String json = new ObjectMapper().writeValueAsString(decodedData);
        System.out.println(json);
        
//        //** convertir a obj java
        generatedObjectJava(json);
//        Gson gson = new Gson();
//        ObjJson objJava = gson.fromJson(json, ObjJson.class);
        
        System.out.println("Data del token:"+decodedData);
        //***
//        generatedObjectJava(decodedData);
    }
    
    private static ObjJson generatedObjectJava(String json){
        //** convertir a obj java
        Gson gson = new Gson();
        ObjJson objJava = gson.fromJson(json, ObjJson.class);
        System.out.println("Objeto java 1 "+objJava.getPersona().getNombre());
        System.out.println("Objeto java 2 "+objJava.getPersona().getDireccion());
        System.out.println("Objeto java 3 "+objJava.getSub());
        System.out.println("Objeto java 4 "+objJava.getExp());
        System.out.println("Objeto java 5 "+objJava.getIat());
        return objJava;
        
    }
    
}
