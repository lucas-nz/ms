package com.zhousz.ms.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    public static String inputPassToForm(String input){
        return md5(input + salt);
    }

    public static String formPassToDB(String formPass, String salt) {
        return md5(formPass + salt);
    }

    public static String inputPassToDB(String inputPass, String salt) {
        String formPass = inputPassToForm(inputPass);
        return formPassToDB(formPass, salt);
    }
//    a916d167fd5e7689527edd5ca1d3dbfb
//    c132faa6b7fad4e11a0ab56f592e1300
    public static void main(String[] args) {
        System.out.println(inputPassToDB("123123", "zh200kg"));
    }


}
