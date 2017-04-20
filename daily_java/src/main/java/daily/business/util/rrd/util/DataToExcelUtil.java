package daily.business.util.rrd.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.List;

public class DataToExcelUtil {

    private static Log logger = LogFactory.getLog(DataToExcelUtil.class);

    public static class Sheet {
        private String sheetNmae;
        private String[] titles;
        private String[][] data;

        public Sheet(String sheetNmae, String[] titles, String[][] data) {
            this.sheetNmae = sheetNmae;
            this.titles = titles;
            this.data = data;
        }

        public String getSheetNmae() {
            return sheetNmae;
        }

        public void setSheetNmae(String sheetNmae) {
            this.sheetNmae = sheetNmae;
        }

        public String[][] getData() {
            return data;
        }

        public void setData(String[][] data) {
            this.data = data;
        }

        public String[] getTitles() {
            return titles;
        }

        public void setTitles(String[] titles) {
            this.titles = titles;
        }

    }

    /**
     * 数据写入excel
     * 
     * @param sheets
     * @param path
     * @param fileName
     */
    public static void data2Excel(List<Sheet> sheets, String path, String fileName) {
        if (sheets == null || sheets.size() == 0) {
            return;
        }

        HSSFWorkbook workBook = creatWorkBook(sheets);

        FileOutputStream fos = null;
        try {
            // 输出成XLS文件
            File file = new File(path + fileName + ".xls");
            fos = new FileOutputStream(file);
            // 写入数据，并关闭文件
            workBook.write(fos);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 数据写入流
     * 
     * @param sheets
     * @return
     */
    public static InputStream data2Excel(List<Sheet> sheets) {
        if (sheets == null || sheets.size() == 0) {
            return null;
        }

        InputStream input = null;
        HSSFWorkbook workBook = creatWorkBook(sheets);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            workBook.write(outputStream);
            byte[] tempBuff = outputStream.toByteArray();
            input = new ByteArrayInputStream(tempBuff, 0, tempBuff.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return input;
    }

    /**
     * 根据数据创建WorkBook
     * 
     * @param sheets
     * @return
     */
    private static HSSFWorkbook creatWorkBook(List<Sheet> sheets) {
        // 创建一个工作簿
        HSSFWorkbook workBook = new HSSFWorkbook();

        // sheet
        if (sheets != null && sheets.size() > 0) {
            int index = 1;
            for (Sheet sheet : sheets) {
                // 创建Sheet
                HSSFSheet hSSFSheet = workBook.createSheet((sheet.getSheetNmae() != null && !"".equals(sheet
                        .getSheetNmae())) == true ? sheet.getSheetNmae() : "data" + index++);

                // 标题
                String[] titles = sheet.getTitles();
                boolean hasTitles = false;
                if (titles != null && titles.length > 0) {
                    hasTitles = true;
                    // 创建表头
                    HSSFRow row = hSSFSheet.createRow((short) 0);
                    // 构造表头单元格
                    HSSFCell cell[] = new HSSFCell[titles.length];

                    for (int i = 0; i < titles.length; i++) {
                        cell[i] = row.createCell(i);
                        cell[i].setCellValue(titles[i]);
                    }
                }

                // 数据
                String[][] data = sheet.getData();
                if (data != null && data.length > 0) {
                    for (int i = 0; i < data.length; i++) {
                        HSSFRow dataRow = null;
                        if (hasTitles) {
                            dataRow = hSSFSheet.createRow(i + 1);
                        } else {
                            dataRow = hSSFSheet.createRow(i);
                        }

                        HSSFCell dataCell[] = new HSSFCell[data[i].length];

                        for (int j = 0; j < data[i].length; j++) {
                            dataCell[j] = dataRow.createCell(j);
                            dataCell[j].setCellValue(data[i][j]);
                        }
                    }
                }
            }
        }

        return workBook;
    }
}
