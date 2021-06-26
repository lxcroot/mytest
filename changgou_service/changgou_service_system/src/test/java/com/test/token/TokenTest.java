package com.test.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenTest {
    public static void main(String[] args) {


        //当前时间
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        JwtBuilder builder= Jwts.builder()
                .setId("888")   //设置唯一编号
                .setSubject("小白")//设置主题  可以是JSON数据
                .setIssuedAt(new Date())//设置签发日期
              //  .setExpiration(date)//用于设置过期时间 ，参数为Date类型数据
                .claim("大宝","小宝")//设置角色
                .signWith(SignatureAlgorithm.HS256,"123456");//设置签名 使用HS256算法，并设置SecretKey(字符串)
        //构建 并返回一个字符串
        System.out.println( builder.compact() );

        String str = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE2MjMzMTU3MDMsIuWkp-WunSI6IuWwj-WunSJ9.WoysO10QGOn1VIBh22liXV6lwaw40Kw2SJ3oP8IhyQU";
        Claims claims = Jwts.parser().setSigningKey("123456").parseClaimsJws(str).getBody();

        System.out.println(claims);
    }
}
