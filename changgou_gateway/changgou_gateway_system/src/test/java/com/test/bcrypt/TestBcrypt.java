package com.test.bcrypt;


import org.springframework.security.crypto.bcrypt.BCrypt;

public class TestBcrypt {
    public static void main(String[] args) {


        for(int  i = 0 ;i<10;i++){
            //生成的盐
            String gensalt = BCrypt.gensalt();
            System.out.println("盐 = "+gensalt);
            String hashpw = BCrypt.hashpw("123456", gensalt);
            System.out.println("加盐后的= "+hashpw);
            //校验密码
            boolean checkpw = BCrypt.checkpw("123456", hashpw);
            System.out.println("密码校验结果: "+checkpw);
        }


    }
}
