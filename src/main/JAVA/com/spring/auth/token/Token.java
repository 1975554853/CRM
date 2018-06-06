package com.spring.auth.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Token {

    private static final String SECRET = "secret";

    private Map<String , Object> createHeader(){
        Map<String , Object> map = new HashMap<>();
        map.put("type" , "jwt");
        //设置加密方式
        map.put("alg" , "HS256");
        return map;
    }

    Gson gson = new Gson();

    //进行token加密
    public String createToken(Object t , long maxTimeWait) throws UnsupportedEncodingException {
        JWTCreator.Builder builder = JWT.create();

        builder.withHeader(createHeader());
        builder.withSubject(gson.toJson(t));

        if (maxTimeWait > 1){
            Long starTime = System.currentTimeMillis();
            Long endTime = starTime + maxTimeWait;
            Date date = new Date(endTime);
            //设置token的失效时间
            builder.withExpiresAt(date);
        }
        //设置加密方式
        return builder.sign(Algorithm.HMAC256(SECRET));
    }

    public <T> T uncreateToken(Class<T> tClass , String token) throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();

        DecodedJWT decodedJWT = verifier.verify(token);
        Date date = decodedJWT.getExpiresAt();

        if (date != null && date.after(new Date())){
            String subject = decodedJWT.getSubject();
            return gson.fromJson(subject , tClass);
        }
        return null;
    }

}
