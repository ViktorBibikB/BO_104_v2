package utils.helpers;

import org.apache.commons.codec.binary.Base64;

public class Helper {
    public static String receiveDecodedJWTAsString(String jwtBody){
        String[] split_string = jwtBody.split("\\.");
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        String jwt = new String(base64Url.decode(base64EncodedBody));
        return jwt;
    }
}
