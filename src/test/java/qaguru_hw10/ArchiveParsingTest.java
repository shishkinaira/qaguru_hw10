package qaguru_hw10;
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ArchiveParsingTest {

    @Test
    void zipTest() throws Exception {

       try (ZipFile zipFile = new ZipFile("src/test/resources/Archive.zip")) {

            ZipEntry entryXlsx = zipFile.getEntry("Code coverage.xlsx");
            try (InputStream stream = zipFile.getInputStream(entryXlsx)) {
                XLS xlsx = new XLS(stream);
                Assertions.assertEquals("test",
                        xlsx.excel.getSheetAt(0)
                                .getRow(0)
                                .getCell(0)
                                .getStringCellValue());
            }


            ZipEntry entryPDF = zipFile.getEntry("Lovilee DIY_Daily Planner_French Blue.pdf");
            try (InputStream stream = zipFile.getInputStream(entryPDF)) {
                PDF pdf = new PDF(stream);
                Assertions.assertEquals("Adobe InDesign CS5.5 (7.5)", pdf.creator);
            }


           ZipEntry entryCsv = zipFile.getEntry("COVERAGE.csv");
           try (InputStream stream = zipFile.getInputStream(entryCsv)) {
               Reader reader = new InputStreamReader(stream);
               CSVReader csvReader = new CSVReader(reader);
               List<String[]> content = csvReader.readAll();

               Assertions.assertEquals(199, content.size());

               final String[] firstRow = content.get(0);
               final String[] secondRow = content.get(1);
               final String[] thirdRow = content.get(2);
               final String[] fourthRow = content.get(3);
               final String[] fifthRow = content.get(4);

               Assertions.assertArrayEquals(new String[]{" Coverage of", " SharepointBackendUtils.java is"," 48.4 "}, firstRow);
               Assertions.assertArrayEquals(new String[]{" Coverage of", " SharepointCommonUtils.java is"," 54.6 "}, secondRow);
               Assertions.assertArrayEquals(new String[]{" Coverage of", " SP UTILS is end","  "}, thirdRow);
               Assertions.assertArrayEquals(new String[]{" Coverage of", " SharepointCopyHelper.java is"," 14.0 "}, fourthRow);
               Assertions.assertArrayEquals(new String[]{" Coverage of", " SPOConnection.java is"," 40.8 "}, fifthRow);
           }

        }


    }
}