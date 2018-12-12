package unit.tool.com.toolcombain.utils;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 项目名称：toolProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2018/12/12 13:39
 * 修改备注
 */
public class ToolUtils {
    //验证混合密码
    public static boolean pwd(String str) {
        String regEx = "((?=.*\\d)(?=.*\\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{8,16}$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.matches();
        return b;
    }

    //验证是否是邮编
    public static boolean isPostCode(String postCode) {
        String reg = "d{5}";
        return Pattern.matches(reg, postCode);
    }

    //验证用户名
    public static boolean getYhm(String str) {
        String regEx = "^[a-zA-Z][a-zA-Z0-9_]{5,15}$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.matches();
        return b;
    }

    //验证是否是社保卡
    public static boolean getSbk(String str) {
        String regEx = "^[a-zA-Z][a-zA-Z0-9]{8}$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.matches();
        return b;
    }

    //是否是中文
    public static boolean isChinese(String str) throws PatternSyntaxException {
        String regEx = "[\\u4e00-\\u9fa5]{2,}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.matches();
        return b;
    }

    //是否是18位身份证
    public static boolean isIdcard(String str) throws PatternSyntaxException {
        String regEx = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.matches();
        return b;
    }

    //是否是11手机号
    public static boolean isPhone(String str) throws PatternSyntaxException {
        String regEx = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.matches();
        return b;
    }

    //是否是11手机号
    public static boolean isEmail(String str) throws PatternSyntaxException {
        String regEx = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.matches();
        return b;
    }

    //去掉特殊字符
    public static String stringFilter(String str) throws PatternSyntaxException {
        String regEx = "[/\\:*?<>|\"\n\t]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }

    //是不是网页
    public static String filterHtml(String str) {
        Pattern pattern = Pattern.compile("<([^>]*)>");
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        while (result1) {
            matcher.appendReplacement(sb, "");
            result1 = matcher.find();
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    //判断第一个是否是数字
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str.charAt(0) + "");
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    //判断全数字
    public static boolean isAllNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    //姓名掩码 掩第一个字
    public static String Deal_name(String str) {
        String name = null;
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            String head = str.substring(0, 1);
            name = stringBuffer.append(head).append("**").toString();
        }
        return name;
    }

    /**
     * 姓名掩码
     * 张三三----->张**
     * 张三 ----> 张*
     *
     * @param name
     * @return
     */
    public static String DealName_3(String name) {
        if (!TextUtils.isEmpty(name)) {
            int length = name.length();
            if (length == 2) {
                name = name.substring(0, 1) + "*";
            } else if (length == 3) {
                name = name.substring(0, 1) + "**";
            } else if (length == 4) {
                name = name.substring(0, 1) + "***";
            }
            return name;
        }
        return "";
    }

    //处理身份证号
    public static String Deal(String str) {
        String idcard = null;
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            String head = str.substring(0, 4);
            String last = str.substring(str.length() - 4);
            idcard = stringBuffer.append(head).append("**********").append(last).toString();
        }
        return idcard;
    }

    /**
     * 隐藏身份证号后六位
     *
     * @param str
     * @return
     */
    public static String DealIdCard(String str) {
        String idcard = null;
        if (str != null) {
            idcard = str.replace(str.substring(str.length() - 6), "******");

        }
        return idcard;
    }

    //处理手机号
    public static String Dealtel(String str) {
        String phone = null;
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            String head = str.substring(0, 3);
            String last = str.substring(str.length() - 4);
            phone = stringBuffer.append(head).append("****").append(last).toString();
        }

        return phone;
    }

    //社保卡掩码
    public static String DealSbkh(String str) {
        String idcard = null;
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            String head = str.substring(0, 3);
            String last = str.substring(str.length() - 2);
            idcard = stringBuffer.append(head).append("****").append(last).toString();
        }
        return idcard;
    }

    // 添加时间转化：例如101702  转化为 1017年2月
    public static String getData(String str) {
        StringBuffer s = null;
        if (str != null) {
            s = new StringBuffer();
            String year = str.substring(0, 4);
            String month = str.substring(4, 6);
            s.append(year).append("年").append(month).append("月");
        }
        return s.toString();
    }

    //将sk2017-06-11 截取为2017年06月11日
    public static String getData2(String str) {
        StringBuffer s = null;
        if (str != null) {
            s = new StringBuffer();
            String year = str.substring(0, 4);
            String month = str.substring(5, 7);
            String day = str.substring(8, 10);
            s.append(year).append("年").append(month).append("月").append(day).append("日");
        }
        return s.toString();
    }

    //截取时间
    public static String getData3(String str) {
        StringBuffer s = null;
        if (str != null) {
            s = new StringBuffer();
            String time = str.substring(0, 10);
            s.append(time);
        }
        return s.toString();
    }

    //...
    public static String getData4(String str) {
        StringBuffer s = null;
        if (str != null) {
            s = new StringBuffer();
            String year = str.substring(0, 4);
            String month = str.substring(5, 7);
            String day = str.substring(8, 10);
            s.append(year).append(month).append(day);
        }
        return s.toString();
    }

    ///将纯数字字符串改为sk:2018-05-11
    public static String getData6(String str) {
        StringBuffer s = null;
        if (str != null) {
            s = new StringBuffer();
            String year = str.substring(0, 4);
            String month = str.substring(4, 6);
            String day = str.substring(6, 8);
            s.append(year).append("-").append(month).append("-").append(day);
        }
        return s.toString();
    }

    //将纯数字字符串改为sk:2018年05月
    public static String getData5(String str) {
        StringBuffer s = null;
        if (str != null) {
            s = new StringBuffer();
            String year = str.substring(0, 4);
            String month = str.substring(4, 6);
            s.append(year).append("年").append(month).append("月");
        }
        return s.toString();
    }

    //将纯数字字符串改为sk:2018-05
    public static String getData7(String str) {
        StringBuffer s = null;
        if (str != null) {
            s = new StringBuffer();
            String year = str.substring(0, 4);
            String month = str.substring(4, 6);
            s.append(year).append("-").append(month);
        }
        return s.toString();
    }

    //处理时间，长度为5添加0
    public static String Dealtime(String time) {
        StringBuffer stringBuffer = new StringBuffer();
        String head = time.substring(0, 4);
        String last = time.substring(time.length() - 4);
        time = stringBuffer.append(head).append("0").append(last).toString();
        return time;
    }

    //yyyy年MM月
    public static String transDate(String str) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
        if (!str.isEmpty()) {
            long lcc_time = Long.valueOf(str);
            re_StrTime = sdf.format(new Date(lcc_time));
            return re_StrTime;
        } else {
            return "";
        }
    }

    //yyyy年MM月dd日
    public static String transDate2(String str) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        if (!str.isEmpty()) {
            long lcc_time = Long.valueOf(str);
            re_StrTime = sdf.format(new Date(lcc_time));
            return re_StrTime;
        } else {
            return "";
        }
    }

    //"yyyy-MM-dd
    public static String transDate3(String str) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (!str.isEmpty()) {
            long lcc_time = Long.valueOf(str);
            re_StrTime = sdf.format(new Date(lcc_time));
            return re_StrTime;
        } else {
            return "";
        }
    }

    //yyyymmdd
    public static String transDate4(String str) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if (!str.isEmpty()) {
            long lcc_time = Long.valueOf(str);
            re_StrTime = sdf.format(new Date(lcc_time));
            return re_StrTime;
        } else {
            return "";
        }
    }
}
