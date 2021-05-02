package com.shenxu.zuul.word;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * @author shen_xu
 * @date 2021/2/23 12:26 上午
 */
public class Pdf2Word {
    public static void main(String[] args) {
        //初始化PdfDocument实例
        PdfDocument doc = new PdfDocument();

        //加载PDF文档
        doc.loadFromFile("/Users/shen_xu/Desktop/pdf2word/1.pdf");

        //保存为Doc格式文档
        doc.saveToFile("/Users/shen_xu/Desktop/pdf2word/java.docx", FileFormat.DOCX);

        try (InputStream is = new FileInputStream("/Users/shen_xu/Desktop/pdf2word/java.docx")) {

            XWPFDocument document = new XWPFDocument(is);
            //以上Spire.Doc 生成的文件会自带警告信息，这里来删除Spire.Doc 的警告
            document.removeBodyElement(0);
            //输出word内容文件流，新输出路径位置
            OutputStream os = new FileOutputStream("/Users/shen_xu/Desktop/pdf2word/java1.docx");

            document.write(os);
            System.out.println("生成docx文档成功！");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
