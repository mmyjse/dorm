package com.codestudio.dorm.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 * 
 * @author J 2013-4-2 下午4:24:53
 */
public class DateUtils {

    private static final Logger logger                      = LoggerFactory.getLogger(DateUtils.class);

    public static final String  DEFAULTDATEPATTERN          = "yyyy-MM-dd HH:mm:ss";
    public static final String  DATEPATTERN_YYYY_MM_DD      = "yyyy-MM-dd";

    public static final String  DATEPATTERN_YYYY_MM_DD4FILE = "yyyy/MM/dd";

    public static String getDatePattern() {
        return DEFAULTDATEPATTERN;
    }

    public static String parseDateStr(String date) {
        if (date == null || "".equals(date)) {
            return null;
        }
        String d = date;
        if (date.length() > 10) {
            d = date.substring(0, 10);
        }
        return d;
    }

    /**
     * 把时间格式化成字符串
     * 
     * @param date 时间
     * @param format 格式
     * @return
     */
    public static String formatDate2String(Date date, String format) {
        if (null == date) {
            return null;
        }
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * 把字符串格式化成时间
     * 
     * @param strDate 时间的字符串表示
     * @param format 格式
     * @return
     */
    public static Date formatString2Date(String strDate, String format) {
        if (strDate == null || "".equals(strDate)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
        return date;
    }

    /**
     * Date类型转化为String类型
     * 
     * @param date
     * @return
     * @author shuijing.linshj 2009-3-27
     */
    public static String dateConvert2String(Date date) {
        if (null == date) {
            return null;
        }
        DateFormat formatter = new SimpleDateFormat(DEFAULTDATEPATTERN);
        return formatter.format(date);
    }

    /**
     * Date类型转化为String 的年月日类型
     * 
     * @param date
     * @return
     * @author
     */
    public static String dateConvert2DateString(Date date) {
        if (null == date) {
            return null;
        }
        DateFormat formatter = new SimpleDateFormat(DATEPATTERN_YYYY_MM_DD);
        return formatter.format(date);
    }

    /**
     * Date类型转化为String类型
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String dateConvert2String(Date date, String pattern) {
        if (null == date) {
            return null;
        }
        DateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * Date类型转化为String类型
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String dateObjectConvert2String(Object date, String pattern) {
        if (null == date) {
            return null;
        }
        if (date instanceof Date) {
            return dateConvert2String((Date) date, pattern);
        }
        return date.toString();
    }

    /**
     * String类型转化为Date类型
     * 
     * @param strDate
     * @return
     */
    public static Date stringConvert2Date(String strDate) {
        if (strDate == null || "".equals(strDate)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULTDATEPATTERN);
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    public static Date stringConvert2Date(String strDate, String format) {
        if (strDate == null || "".equals(strDate)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    /**
     * 支持带区域语言设置的多种时间格式的转换
     * 
     * @param strDate
     * @param patterns
     * @return
     * @throws ParseException 如果所有的格式都不支持,则抛出异常
     */
    public static Date stringConver2Date(String strDate, DatePatternPair... patterns) throws ParseException {
        for (DatePatternPair pattern : patterns) {
            try {
                if (pattern.getLocale() == null) {
                    return new SimpleDateFormat(pattern.getFormate()).parse(strDate);
                } else {
                    return new SimpleDateFormat(pattern.getFormate(), pattern.getLocale()).parse(strDate);
                }
            } catch (ParseException e) {
            }
        }
        throw new ParseException("No pattern matching the date string: " + strDate, 0);
    }

    public static class DatePatternPair {

        private String formate;
        private Locale locale;

        public DatePatternPair(String formate, Locale locale){
            this.formate = formate;
            this.locale = locale;
        }

        public DatePatternPair(String formate){
            this.formate = formate;
            this.locale = null;
        }

        public String getFormate() {
            return formate;
        }

        public void setFormate(String formate) {
            this.formate = formate;
        }

        public Locale getLocale() {
            return locale;
        }

        public void setLocale(Locale locale) {
            this.locale = locale;
        }

        @Override
        public String toString() {
            return "DatePatternPair [formate=" + formate + ", locale=" + locale + "]";
        }
    }

    public static void index() throws IOException {
        URL url = new URL("http://ums.zj165.com:8888/sms/Api/Send.do");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String s = "111" + formatter.format(new Date());
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "GB2312");
        out.write("SpCode=001835&LoginName=hz_sd&Password=sd8181&MessageContent=恭喜您，已经成功开通家如何会员，我们会在24小时之内和您联系，找家具、找设计直接登陆www.jiaruhe.com。&UserNumber=15858208598&SerialNumber="
                  + s + "&ScheduleTime=&f=1"); // 向页面传递数据。post的关键所在！
        out.flush();
        out.close();
        String sCurrentLine;
        String sTotalString;
        sCurrentLine = "";
        sTotalString = "";
        InputStream l_urlStream;
        l_urlStream = connection.getInputStream();

        BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
        while ((sCurrentLine = l_reader.readLine()) != null) {
            sTotalString += sCurrentLine + "/r/n";
        }
        s = java.net.URLEncoder.encode(sTotalString, "gb2312");
        System.out.println(s);
    }

    /**
     * 计算两个日期之间相差的天数
     * 
     * @param smdate 较小的时间
     * @param bdate 较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date sdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATEPATTERN_YYYY_MM_DD);
        sdate = sdf.parse(sdf.format(sdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 字符串的日期格式的计算
     */
    public static int daysBetween(String sdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATEPATTERN_YYYY_MM_DD);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(sdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
        // System.out.println(stringConver2Date("星期四, 十一月 24, 2011 15:18", new DatePatternPair("E, MMMM d, yyyy H:m",
        // Locale.CHINA)));

        // String s = "余余额不足";
        // s = java.net.URLEncoder.encode(s, "gb2312");
        // System.out.println(s);
        // s = java.net.URLDecoder.decode(s, "gb2312");
        // System.out.println(s);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = sdf.parse("2013-06-08 10:10:10");
        Date d2 = sdf.parse("2013-06-15 00:00:00");
        System.out.println(daysBetween(d1, d2));

        System.out.println(daysBetween("2013-06-06 00:00:00", "2013-06-07 03:00:00"));

    }
}
