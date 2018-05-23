package com.ng.howlongapi.util;

import com.ng.howlongapi.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {

    @Value("${apikey.secret}")
    private String apiKey;

    /**
     * 构建jwt
     * */
    public String createJwt(JwtUser jwtUser){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

        Date now = new Date();
        // sign jwt with apikey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey);
        Key singingKey = new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder().setSubject(jwtUser.getUsername()).setIssuedAt(now).
                signWith(signatureAlgorithm,singingKey);
        return builder.compact();
    }

    public String parseJwt(String jwt) {
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(apiKey)).parseClaimsJws(jwt)
                .getBody();
        return claims.getSubject();
    }
}
