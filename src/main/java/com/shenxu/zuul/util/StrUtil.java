package com.shenxu.zuul.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shen_xu
 * @ClassName StrUtil
 */

public class StrUtil {

    public static final String PHONE_REGEX = "^[1][3,4,5,6,7,8,9][0-9]{9}$";

    public static final String EMAIL_REGEX = "[0-9a-zA-Z]{1,}[@][0-9a-zA-Z]{1,}[.][a-z]{1,}";
    private static final DateTimeFormatter YYYY_MM_DD_HH_II_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final String PASS_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6,16}$";

    public static final String REQUEST_ID = "requestId";

    public final static String IMAGE_EXT = "jpg,jpeg,png";
    public final static String DOC_EXT = "txt, docx, doc";
    public final static String VIDEO_EXT = "mp4, mov, avi, mpeg, aif";
    public final static String MP3_EXT = "mp3, wav, flac, aif";
    public final static String LRC_EXT = "lrc";

    public final static String LABEL_ERR = "v2/label_path/error/";
    public final static String LABEL_ERR_MSG = "labelCopy错误数据表格";

    public final static String LABEL_WARNING = "v2/label_path/warning/";
    public final static String LABEL_WARNING_MSG = "labelCopy警告数据表格";

    public final static String EXPORT_EXCEL = "v2/label_path/export/";
    public final static String EXPORT_EXCEL_MSG = "入库数据导出";

    /**
     * 纯中文
     */
    public static final String CHINESE_REGEX = "^[\\u4e00-\\u9fa5]*$";

    public static final String ISRC_REGEX = "^[A-Z]{1,}[0-9]{1,}$";
    public static final String JAN_REGEX = "^[0-9]+$";


    /**
     * uuid
     *
     * @return string
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String uuid(int length) {
        return uuid().substring(0, length);
    }

    /**
     * zhaowei
     * 数字和字母的混合
     *
     * @return String
     */
    public static String randMix(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    /**
     * zhaowei
     * 纯数字
     *
     * @return String
     */
    public static String randNum(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    /**
     * zhaowei
     * 反正是string，合过来
     *
     * @return String
     */
    public static String ip() {
        RequestAttributes attr = RequestContextHolder.getRequestAttributes();
        if (null == attr) {
            return "";
        }
        HttpServletRequest req = ((ServletRequestAttributes) attr).getRequest();
        String ip = req.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }
        if (StringUtils.isBlank(ip)) {
            return "127.0.0.1";
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    /**
     * zhaowei
     * 判断是不是邮箱
     *
     * @param input 邮箱地址
     * @return bool
     */
    public static boolean isEmail(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        return input.matches(EMAIL_REGEX);
    }

    /**
     * zhaowei
     * 判断是不是手机
     *
     * @param input 手机号
     * @return bool
     */
    public static boolean isPhone(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        return input.matches(PHONE_REGEX);
    }


    /**
     * 判断是否是全中文
     *
     * @param input
     * @return
     */
    public static boolean isChinese(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        return input.matches(CHINESE_REGEX);
    }

    /**
     * 检测ISRC
     *
     * @param input
     * @return
     */
    public static boolean isISRC(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        return input.matches(ISRC_REGEX);
    }

    /**
     * 检测JAN
     *
     * @param input
     * @return
     */
    public static boolean isJAN(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        return input.matches(JAN_REGEX);
    }

    public static String now() {
        return LocalDateTime.now().format(YYYY_MM_DD_HH_II_SS);
    }

    /**
     * 生成code
     */
    public static String createCode() {
        UUID uuid = UUID.randomUUID();
        String code = uuid.toString().replace("-", "").toUpperCase();
        return code.substring(0, 14);
    }

    public static String md5(String input) {
        return DigestUtils.md5Hex(input);
    }

    /**
     * 将用逗号分隔的id字符串转换为list
     *
     * @param idStr
     * @return
     */
    public static List<Integer> getIdListFromStr(String idStr) {
        if (StringUtils.isBlank(idStr)) {
            return new ArrayList<>();
        }
        return Arrays.asList(idStr.split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
    }

    public static List<Integer> getIdListFromStr(List<String> idStrs) {
        List<Integer> result = new ArrayList<>();
        for (String idStr : idStrs
        ) {
            result.addAll(getIdListFromStr(idStr));
        }
        return result;
    }


    /**
     * 生成授权书code
     *
     * @param prefix
     * @return
     */
    public static String createLicenseCode(String prefix) {
        return prefix + new SimpleDateFormat("yyyyMMdd").format(new Date()) + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
    }

    /**
     * 获取上传label copy表错误的地址路径发
     *
     * @param storeCode 流程code
     * @param suffix    文件后缀名
     * @return url
     */
    public static String getLabelErrPath(String storeCode, String suffix) {
        return buildPath(LABEL_ERR, LABEL_ERR_MSG, storeCode, suffix);
    }

    /**
     * 获取上传label copy表警告的地址路径发
     *
     * @param storeCode 流程code
     * @param suffix    文件后缀名
     * @return url
     */
    public static String getLabelWarningPath(String storeCode, String suffix) {
        return buildPath(LABEL_WARNING, LABEL_WARNING_MSG, storeCode, suffix);
    }

    public static String getExportPath(String storeCode) {
        return buildPath(EXPORT_EXCEL, EXPORT_EXCEL_MSG, storeCode, "xlsx");
    }

    private static String buildPath(String path, String msg, String storeCode, String suffix) {
        return path + msg + "-" + storeCode + "." + suffix;
    }
}
