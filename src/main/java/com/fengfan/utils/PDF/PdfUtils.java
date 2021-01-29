package com.fengfan.utils.PDF;

import com.fengfan.utils.exception.FileException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class PdfUtils {
    public static void main(String[] args) throws Exception {
//        createAllPdf();
//        removeRepeat("F:\\1\\1.txt", "F:\\1\\2.txt", "F:\\1\\3.txt", "utf8");
//        createdPdf();
        Date date = new Date(); //取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sd.format(date));
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -2);
        date = calendar.getTime();
        System.out.println(sd.format(date));
    }

    public static void createdPdf() throws IOException, DocumentException {
        //文档对象
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        File file = new File("F:\\1\\123.pdf");
        if (!file.exists()) {
            file.createNewFile();
        }
        //创建写入对象
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        //打开文档对象
        document.open();
        //字体 - 编码 设置为宋体,中文正常现实
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        //大小
        Font font = new Font(bfChinese, 16);
        //颜色
        font.setColor(BaseColor.BLACK);
        //列数
        PdfPTable t = new PdfPTable(3);
        t.setSpacingBefore(10);
        t.setSpacingAfter(10);
        //一个cell 代表一个单元格
        PdfPCell cell = new PdfPCell(new Phrase("挂钩标的表现参考情况表", font));
        // 设置单元格高度
        cell.setMinimumHeight(20);
        // 设置可以居中
        cell.setUseAscender(true);
        // 设置水平居中
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        // 设置垂直居中
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        //无边框
        cell.setBorder(0);
        //设置合并3个单元格
        cell.setColspan(3);
        t.addCell(cell);
        cell = new PdfPCell(new Phrase("观察日期", font));
        cell.setMinimumHeight(20);
        cell.setUseAscender(true);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cell.setFixedHeight(20f);
        t.addCell(cell);
        cell = new PdfPCell(new Phrase("挂钩标的", font));
        cell.setMinimumHeight(20);
        cell.setUseAscender(true);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cell.setFixedHeight(20f);
        t.addCell(cell);
        cell = new PdfPCell(new Phrase("挂钩标的表现值", font));
        cell.setMinimumHeight(20);
        cell.setUseAscender(true);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cell.setFixedHeight(20f);
        t.addCell(cell);
        //测试用数据
        for (int i = 0; i < 5; i++) {
            cell = new PdfPCell(new Phrase("2020-10-55", font));
            cell.setMinimumHeight(20);
            cell.setUseAscender(true);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            cell.setFixedHeight(20f);
            t.addCell(cell);
            cell = new PdfPCell(new Phrase("沪深300指数", font));
            cell.setMinimumHeight(20);
            cell.setUseAscender(true);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            cell.setFixedHeight(20f);
            t.addCell(cell);
            cell = new PdfPCell(new Phrase("20211.33", font));
            cell.setMinimumHeight(20);
            cell.setUseAscender(true);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            cell.setFixedHeight(20f);
            t.addCell(cell);
        }
        //将表格对象添加至文档对象
        document.add(t);
        //一定要关闭,不然pdf会打不开
        document.close();
        writer.close();
    }

    /**
     * 根据模板生成pdf  需要设置模板中的表单
     *
     * @throws Exception
     */
    public static void createAllPdf() throws Exception {
        //填充创建pdf
        PdfReader reader = null;
        PdfStamper stamp = null;
        try {
            reader = new PdfReader("E:/test.pdf");
            SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
            String times = simp.format(new Date()).trim();
            //创建生成报告名称
            String root = "F:\\1\\" + File.separator;
            if (!new File(root).exists()) {
                new File(root).mkdirs();
            }
            File deskFile = new File(root, times + ".pdf");
            stamp = new PdfStamper(reader, new FileOutputStream(deskFile));
            //取出报表模板中的所有字段
            AcroFields form = stamp.getAcroFields();
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font f = new Font(bf, 18, Font.NORMAL);
            ArrayList<BaseFont> fontList = new ArrayList<BaseFont>();
            fontList.add(bf);
            //设置文字字体
            form.setSubstitutionFonts(fontList);
            // 填充数据
            form.setField("01", "产品开22始观察日");
            form.setFieldProperty("01", "size", 2.3f, null);
            form.setField("02", "男");
            form.setFieldProperty("02", "size", 2.3f, null);
            form.setField("03", "15");
            form.setFieldProperty("03", "size", 2.3f, null);
            form.setField("04", "产品结察日");
            form.setField("05", "这个不太好卖呀");
            form.setField("06", "我觉得还可以");

            //报告生成日期
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String generationdate = dateformat.format(new Date());
            form.setField("generationdate", generationdate);
            stamp.setFormFlattening(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stamp != null) {
                stamp.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
    }

    /**
     * 将两个文件合并为一个文件,去除其中重复的行
     *
     * @param File     文件1(路径+文件名)
     * @param File1    文件2(路径+文件名)
     * @param newFile  新文件(路径+文件名)
     * @param charcode 编码格式,不指定默认为utf8
     * @throws FileException 文件为空时抛出的异常
     * @throws IOException   创建文件失败时抛出的异常
     */
    public static void removeRepeat(String File, String File1, String newFile, String charcode) throws FileException, IOException {
        if (org.apache.commons.lang3.StringUtils.isBlank(File) || org.apache.commons.lang3.StringUtils.isBlank(newFile) || org.apache.commons.lang3.StringUtils.isBlank(File1)) {
            throw new FileException("文件名不能为空");
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(charcode)) {
            charcode = "utf8";
        }
        File file = new File(newFile);
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(File), charcode));
        BufferedReader bf1 = new BufferedReader(new InputStreamReader(new FileInputStream(File1), charcode));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charcode));
        List<String> StringList = new ArrayList();
        String line;
        while ((line = bf.readLine()) != null) {
            if (org.apache.commons.lang3.StringUtils.isNotBlank(line)) {
                System.out.println(line);
                if (!StringList.contains(line)) {
                    StringList.add(line + "\n");
                }
            }
        }
        System.out.println("文件1结束");
        while ((line = bf1.readLine()) != null) {
            if (StringUtils.isNotBlank(line)) {
                System.out.println(line);
                if (!StringList.contains(line)) {
                    StringList.add(line + "\n");
                }
            }
        }
        for (String s : StringList) {
            wr.write(s);
        }
        bf.close();
        bf1.close();
        wr.close();
    }
}
