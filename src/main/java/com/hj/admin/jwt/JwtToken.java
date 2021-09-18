package com.hj.admin.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtToken {

    //加解密秘钥
    public final String KEY = "hhhhhhh";

    //默认过期时间
    long EXP = System.currentTimeMillis()+1000*60;//设置过期时间为1分钟

    /*
    *       根据用户id  创建 jwt  无过期 时间
    *
    */
    public String createJwt(String userId, Map<String ,String > map)  {


        /*
        *       token 续期
        */



        JwtBuilder builder = Jwts.builder().setId(userId)
                .setSubject(userId)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, KEY);

        if (null!=map) {
            for (String s : map.keySet()) {
                builder.claim(s, map.get(s));
            }
        }

        return builder.compact();
    }

    //多 过期时间
    public String createJwt(String userId,Map<String ,String > map,long exp) {
        JwtBuilder builder = Jwts.builder().setId(userId)
                .setSubject(userId)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, KEY)
                .setExpiration(new Date(exp));

        if (null!=map) {
            for (String s : map.keySet()) {
                builder.claim(s, map.get(s));
            }
        }


        return builder.compact();
    }





    /*
    *           解析jwt  返回用户id
    *
    **/
    public String   parseJwt(String  jwt){
        Claims claims = Jwts.parser().setSigningKey(KEY)
                .parseClaimsJws(jwt)
                .getBody();

        return claims.getId();
    }


    public static void main(String[] args) {

        //Jwts.builder()表示创建
        JwtBuilder builder = Jwts.builder().setId("16") //setId一般是用户id
                .setSubject("可非") //
                .setIssuedAt(new Date()) //setIssuedAt用于设置签发时间
                .signWith(SignatureAlgorithm.HS256, "kefei"); //signWith设置签名的秘钥
        System.out.println(builder.compact());

    }


}
