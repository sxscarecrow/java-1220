//package com.shenxu.zuul.component;
//
//import com.shenxu.zuul.domain.properties.MailProperty;
//import com.shenxu.zuul.exception.ServiceException;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.mail.MailException;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.util.ResourceUtils;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//
///**
// * 邮件
// *
// * @Author shenxu
// * @Date 2021/4/11 15:27
// */
//@Slf4j
//public class Mail {
//
//    private static final JavaMailSenderImpl client = SpringContext.getBean("emailSender", JavaMailSenderImpl.class);
//    private static final MailProperty mailProperty = SpringContext.getBean("mailProperty", MailProperty.class);
//
//    /**
//     * 测试发邮件接口
//     *
//     * @param account
//     * @param code
//     * @throws Exception
//     */
//    public static void sendVerify(String account, String code) throws Exception {
//        String html = readTpl("");
//        send(account, html.replace("{{code}}", code));
//    }
//
//    public static void send(String account, String tpl) {
//        if (StringUtils.isBlank(account)) {
//            throw new ServiceException(500, "账号不存在");
//        }
//
//        MimeMessage msg = client.createMimeMessage();
//        MimeMessageHelper messageHelper;
//        try {
//            messageHelper = new MimeMessageHelper(msg, true);
//            // 邮件发送人
//            messageHelper.setFrom(mailProperty.getFrom());
//            // 邮件接收人
//            messageHelper.setTo(account);
//            // 邮件主题
//            msg.setSubject("版权管家");
//            // 邮件内容，html格式
//            messageHelper.setText(tpl, true);
//            //发送
//            client.send(msg);
//        } catch (MessagingException | MailException e) {
//            log.error("send email err, {}", e);
//        }
//    }
//
//    private static String readTpl(String file) {
//        StringBuilder result = new StringBuilder();
//        try {
//            InputStream tempFile = ResourceUtils.getURL(file).openStream();
//            InputStreamReader read = new InputStreamReader(tempFile, StandardCharsets.UTF_8);
//            BufferedReader reader = new BufferedReader(read);
//            String line;
//            while ((line = reader.readLine()) != null) {
//                result.append(line);
//            }
//            read.close();
//        } catch (Exception e) {
//            // todo
//            log.info("解析html失败");
//
//        }
//        return result.toString();
//    }
//}
