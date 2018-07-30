package com.zhousz.ms.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

    /**
     * 纯数字(0-9)字符串匹配
     */
    private static Pattern digitPattern = Pattern.compile("^[0-9]+$");

    /**
     * 纯英文字符(A-Za-z)字符串匹配
     */
    private static Pattern letterPattern = Pattern.compile("^[A-Za-z]+$");

    /**
     * 数字(0-9)和英文字符(A-Za-z)字符串匹配
     */
    private static Pattern digitAndLetterPattern = Pattern
            .compile("^[A-Za-z0-9]+$");

    /**
     * 纯中文汉字字符串匹配
     */
    private static Pattern chinesePattern = Pattern
            .compile("^[\u4e00-\u9fa5]+$");

    /**
     * 纯双字节字符串匹配(包括汉字)
     */
    private static Pattern doubleBytePattern = Pattern
            .compile("^[^\\x00-\\xff]+$");

    /**
     * email地址字符串匹配
     */
    private static Pattern emailPattern = Pattern
            .compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");

    /**
     * number字符串匹配
     */
    private static Pattern numberPattern = Pattern
            .compile("[1-9]\\d*\\.?\\d*|0\\.\\d*|-[1-9]\\d*\\.?\\d*|-0\\.\\d*|0");

    /**
     * 电话号码字符串匹配
     */
    private static Pattern phoneNumberPattern = Pattern
            .compile("^(\\d{3,4}-)?\\d{7,8}$");

    // ---end:正在表达式---

    /**
     * 验证对象是否为空 (说明: String类型的null/""/"null"都认为为空，数字类型的null/0或多个0都认为为空，
     * 数组类型null和length为0都认为为空 ，集合类型null和size为0认为为空)
     *
     * @param value
     *            校验对象
     * @return true:为空，false:不为空
     * @author LiuKun
     * @created 2013-8-21 上午9:22:34
     */
    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        }
        if (value instanceof String) {
            String str = (String) value;
            return isEmpty(str);
        }

        // BigDecimal/BigInteger/Byte/Double/Float/Long/Integer/Short
        if (value instanceof Number) {
            Number number = (Number) value;
            return isEmpty(number);
        }

        if (value instanceof Object[]) {// 数组
            Object[] values = (Object[]) value;
            return isEmpty(values);
        }

        if (value instanceof Collection) {// 集合(List/Set)
            Collection<?> coll = (Collection<?>) value;
            return isEmpty(coll);
        }

        if (value instanceof Map) {// Map
            Map<?, ?> map = (Map<?, ?>) value;
            return isEmpty(map);
        }

        return isEmpty(value.toString());// StringBuffer/StringBuilder
        // return false;
    }

    public static boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }
        if ("".equalsIgnoreCase(value.toString().replaceAll(" ", ""))) {
            return true;
        }
        if ("null".equalsIgnoreCase(value.toString().replaceAll(" ", ""))) {
            return true;
        }
        if ("undefined".equalsIgnoreCase(value.toString().replaceAll(" ", ""))) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Number value) {
        if (null == value
                || (value.intValue() == 0 && value.doubleValue() == 0.0)) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Object[] values) {
        if (null == values || values.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Collection<?> coll) {
        if (null == coll || coll.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        if (null == map || map.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 删除单个文件
     *
     * @param sPath
     *            被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     * @author maqun
     * @created 2014-4-12 下午3:35:37
     */
    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    /**
     * 验证对象为空(具体查看isEmpty)
     *
     * @param value
     * @return
     * @author LiuKun
     * @created 2013-8-21 上午9:30:33
     */
    public static boolean isNotEmpty(Object value) {
        return !isEmpty(value);
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static boolean isNotEmpty(Number value) {
        return !isEmpty(value);
    }

    public static boolean isNotEmpty(Object[] values) {
        return !isEmpty(values);
    }

    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 校验字符串是否为空(说明:""/null/"null"都认为为空)
     *
     * @param value
     *            要校验的字符串
     * @return true:为空; false:不为空
     * @author LiuKun
     * @created 2013-8-21 上午9:44:39
     */
    public static boolean isNull(String value) {
        if (value == null) {
            return true;
        }
        value = value.trim();
        if (("null".equalsIgnoreCase(value)) || (value.equals(""))) {
            return true;
        }
        return false;
    }

    /**
     * 校验数组是否为空(说明:数组对象为空null或长度为0都认为为空)
     *
     * @param arr
     *            数组对象
     * @return true:为空；false:不为空
     * @author LiuKun
     * @created 2013-8-21 上午9:46:26
     */
    public static boolean isNull(Object[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证集合对象是否为空(说明:集合对象为null或size为0都认为为空)
     *
     * @param coll
     *            集合对象
     * @return true:为空；false:不为空
     * @author LiuKun
     * @created 2013-8-21 上午9:48:13
     */
    public static boolean isNull(Collection<?> coll) {
        if (null == coll || coll.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证Map对象是否为空(说明:Map对象为null或size为0都认为为空)
     *
     * @param map
     *            Map对象
     * @return true:为空；false:不为空
     * @author LiuKun
     * @created 2013-8-21 上午9:50:01
     */
    public static boolean isNull(Map<?, ?> map) {
        if (null == map || map.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotNull(String value) {
        return !isNull(value);
    }

    /**
     * 验证2个对象是否相等(说明:2个对象都为null认为为true,2个对象有一个为null认为false)
     *
     * @param o1
     *            比较对象1
     * @param o2
     *            比较对象2
     * @return
     * @author LiuKun
     * @created 2013-8-21 上午9:40:53
     */
    public static boolean equals(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            return true;
        }
        if (o1 == null || o2 == null) {
            return false;
        }
        return o1.equals(o2);
    }

    /**
     * 验证字符是否为英文字母(A-Z或a-z)
     *
     * @param c
     *            验证字符
     * @return true:是英文字母；false:不是英文字母
     * @author LiuKun
     * @created 2013-8-21 上午9:51:19
     */
    public static boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    /**
     * 验证字符串是否由英文字母(A-Z或a-z)构成
     *
     * @param value
     *            验证字符串
     * @return true:是；false:不是
     * @author LiuKun
     * @created 2013-8-21 上午10:04:19
     */
    public static boolean isLetter(String value) {
        if (isEmpty(value)) {
            return false;
        }
        Matcher m = letterPattern.matcher(value);
        return m.matches();
        // char[] c = value.toCharArray();
        // for (int i = 0; i < c.length; i++) {
        // if (!isLetter(c[i])) {
        // return false;
        // }
        // }
        // return true;
    }

    /**
     * 验证字符是否数字(0-9)
     *
     * @param c
     *            验证字符
     * @return true:是；false:不是
     * @author LiuKun
     * @created 2013-8-21 上午10:44:43
     */
    public static boolean isDigit(char c) {
        int x = (int) c;
        if ((x >= 48) && (x <= 57)) {
            return true;
        }
        return false;
    }

    /**
     * 验证字符串是否为纯数字(0-9)构成
     *
     * @param value
     *            字符串
     * @return true:是；false:不是
     * @author LiuKun
     * @created 2013-8-21 上午10:46:37
     */
    public static boolean isDigit(String value) {
        if (isEmpty(value)) {
            return false;
        }
        Matcher m = digitPattern.matcher(value);
        return m.matches();
        // char[] c = value.toCharArray();
        // for (int i = 0; i < c.length; i++) {
        // if (!isDigit(c[i])) {
        // return false;
        // }
        // }
        // return true;
    }

    /**
     * 判断给定字符串是否是完整的html代码段 （这里完整的html代码段是指带有<html></html>的代码，大小写五关）
     *
     * @param value
     *            要验证的字符串
     * @return 若为html代码段，则返回true，否则返回false
     * @author LiuKun
     * @created 2013-8-21 上午10:57:29
     */
    public static boolean isHTML(String value) {
        if (isEmpty(value)) {
            return false;
        }
        if (((value.indexOf("<html>") != -1) || (value.indexOf("<HTML>") != -1))
                && ((value.indexOf("</html>") != -1) || (value
                .indexOf("</HTML>") != -1))) {
            return true;
        }
        return false;
    }

    /**
     * 验证字符串是否为email地址
     *
     * @param emailValue
     *            email地址字符串
     * @return true:是；false:不是
     * @author LiuKun
     * @created 2013-8-21 上午10:58:42
     */
    public static boolean isEmailAddress(String emailValue) {
        if (isEmpty(emailValue)) {
            return false;
        }
        Matcher m = emailPattern.matcher(emailValue);
        return m.matches();
    }

    /**
     * 验证字符串是否java.lang.Number对象字符串(包括负数和小数)
     *
     * @param value
     *            字符串
     * @return true:是；false:不是
     * @author LiuKun
     * @created 2013-8-21 上午11:02:52
     */
    public static boolean isNumber(String value) {
        if (null != value) {
            if (value.trim().matches("[\\d]*")
                    || value.trim().matches("[\\d]*[\\.]?[\\d]*")) {
                return true;
            }
        }
        if (isEmpty(value)) {
            return false;
        }
        if (null == value) {
            return false;
        }
        Matcher m = numberPattern.matcher(value);
        return m.matches();
    }

    public static boolean isNumber(Object value) {
        if (null != value) {
            if (value instanceof Number) {
                return true;
            }
        }
        if (isEmpty(value)) {
            return false;
        }
        if (null == value) {
            return false;
        }

        if (value instanceof Number) {
            return true;
        } else if (value instanceof String) {
            String str = (String) value;
            return isNumber(str);
        } else {
            // String str = value.toString();
            // return isNumber(str);
            return false;
        }
    }

    /**
     * 判断给定字符串是否合法密码 （这里合法密码是指长度大等于4且由数字或者中英文字组成的字符串）
     *
     * @param password
     *            要验证的字符串
     * @return 若为合法密码，则返回true；否则返回false
     * @author LiuKun
     * @created 2013-8-21 上午11:08:31
     */
    public static boolean isPassword(String password) {
        if (isEmpty(password)) {
            return false;
        }
        if (password.length() < 4) {
            return false;
        }
        char[] c = password.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if ((!isLetter(c[i])) && (!isDigit(c[i]))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否数字（允许带有负号以及小数点）
     *
     * @param value
     *            字符串
     * @return 若为合法数字，则返回true；否则返回false
     * @author LiuKun
     * @created 2013-8-21 上午11:08:57
     */
    public static boolean isDigital(String value) {
        return isNumber(value);
    }

    /**
     * 验证字符串是否为电话号码
     *
     * @param phoneNumber
     *            字符串
     * @return true:是；false:不是
     * @author LiuKun
     * @created 2013-8-21 上午11:12:36
     */
    public static boolean isPhoneNumber(String phoneNumber) {
        if (isEmpty(phoneNumber)) {
            return false;
        }
        Matcher m = phoneNumberPattern.matcher(phoneNumber);
        return m.matches();
    }

    /**
     * 验证字符串是否为纯中文构成
     *
     * @param value
     *            字符串
     * @return true:是; false:不是
     * @author LiuKun
     * @created 2013-8-21 上午11:17:31
     */
    public static boolean isChinese(String value) {
        if (isEmpty(value)) {
            return false;
        }
        Matcher m = chinesePattern.matcher(value);
        return m.matches();
    }

    /**
     * 验证字符串是否友纯双字节字符构成
     *
     * @param value
     *            字符串
     * @return true:是；false:不是
     * @author LiuKun
     * @created 2013-8-21 上午11:21:25
     */
    public static boolean isDoubleByte(String value) {
        if (isEmpty(value)) {
            return false;
        }
        Matcher m = doubleBytePattern.matcher(value);
        return m.matches();
    }

    /**
     * 验证日期字符串是否为指定日期格式的字符串（说明：不支持日期进位 如：2012-02-30 不能表示2012-03-01）
     *
     * @param value
     *            字符串
     * @param pattern
     *            日期格式 如 yyyy-MM-dd或yyyyMMdd
     * @return true:是；false:不是
     * @author LiuKun
     * @created 2013-8-21 上午11:57:52
     */
    public static boolean isDate(String value, String pattern) {
        if (isEmpty(value) || isEmpty(pattern)) {
            return false;
        }
        // 去空格
        value = value.trim();
        boolean flag = false;
        SimpleDateFormat format = null;
        try {
            format = new SimpleDateFormat(pattern);
            Date date = format.parse(value);
            if (format.format(date).equalsIgnoreCase(value)) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            // throw new RuntimeException(e);
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public static boolean isDate(Object value) {
        if (isEmpty(value)) {
            return false;
        }
        if (value instanceof Date || value instanceof java.sql.Date
                || value instanceof java.sql.Timestamp) {
            return true;
        } else {
            return false;
        }
    }



}
