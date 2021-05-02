package com.shenxu.zuul.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author ly
 * @date 2020/8/5 16:38
 */

@Slf4j
public class HuaweiSaasUtil {


    /**
     * 解密手机号码或邮箱
     *
     * @param key           秘钥
     * @param str           密文
     * @param encryptLength 加密长度
     * @return 解密结果
     */
    public static String decryptMobilePhoneOrEMail(String key, String str, int encryptLength) {

        Logger logger = LoggerFactory.getLogger(HuaweiSaasUtil.class);
        // 当返回值为null 的时候 直接抛出参数不合法的错误
        if (null != str && str.length() > 16) {
            String iv = str.substring(0, 16);
            String encryptStr = str.substring(16);
            String result = null;
            try {
                result = decryptAESCBCEncode(encryptStr, key, iv, encryptLength);
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException
                    | IllegalBlockSizeException | BadPaddingException e) {
                logger.error("华为saas在解密手机号或者邮箱的时候出现异常，异常信息：msg = {}", e.getMessage());
            }
            return result;
        }
        return null;
    }

    /**
     * 解密AES CBC
     *
     * @param content 原文
     * @param key     秘钥
     * @param iv      盐值
     * @return 解密结果
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    private static String decryptAESCBCEncode(String content, String key, String iv, int encryptType) throws InvalidKeyException,
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        if (StringUtils.isEmpty(content) || StringUtils.isEmpty(key) || StringUtils.isEmpty(iv)) {
            return null;
        }
        return new String(decryptAESCBC(Base64.decodeBase64(content.getBytes()), key.getBytes(),
                iv.getBytes(), encryptType));

    }

    private static byte[] decryptAESCBC(byte[] content, byte[] keyBytes, byte[] iv, int encryptType) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(keyBytes);
        keyGenerator.init(encryptType, secureRandom);
        SecretKey key = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] result = cipher.doFinal(content);
        return result;
    }
}
