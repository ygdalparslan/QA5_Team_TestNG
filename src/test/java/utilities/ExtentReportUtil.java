package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

public class ExtentReportUtil {
    // Raporlama sırasında kullanılacak variable'lar
    public static String message;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static ExtentHtmlReporter extentHtmlReporter;

    // Raporlama nesneleri oluşturulur
    public static void createExtentReports() {
        if (extentReports == null) { // ExtentReports nesnesi oluşturulmamış ise
            String raporAdi = "US02_html_report.html"; // Rapor dosyasının adı
            extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/reports/" + raporAdi); // raporun HTML dosyası oluşturulur
            extentReports = new ExtentReports(); // ExtentReports nesnesi oluşturulur
            extentReports.attachReporter(extentHtmlReporter); // Rapor dosyası ExtentHtmlReporter'a bağlanır

            // HTML raporu yapılandırılır
            extentHtmlReporter.config().setDocumentTitle("Alparslan TestNG_allovercommerce Otomasyon Raporu");
            extentHtmlReporter.config().setReportName("US02 | Kullanıcı siteden alışveriş yapabilmeli");

            // Raporlama bilgileri girilir
            extentReports.setSystemInfo("Uygulama", "Alaprslan TestNG");
            extentReports.setSystemInfo("Test Türü", "Regression");
            extentReports.setSystemInfo("Grup", "Batch189");
            extentReports.setSystemInfo("Takım", "TEAM-5");

            // Raporlama bilgileri girilir (User Story ve QA kişisi bilgileri burada girilir)
            extentReports.setSystemInfo("User Story", "US02 | Kullanıcı siteden alışveriş yapabilmeli");
            extentReports.setSystemInfo("QA", "Alparslan Yiğid");

            // Ekran görüntüleri için klasör oluşturulur
            File screenshotFile = new File(System.getProperty("user.dir") + "/src/test/java/reports/screenshots");
            screenshotFile.mkdir();
        }

    }

    //It runs when test pass
    public static void extentTestPass(String message) {
        if (extentTest != null) {
            extentTest.pass(message);
        }
    }

    //It runs when test fail
    public static void extentTestFail(String message) {
        if (extentTest != null) {
            extentTest.fail(message);
        }
    }

    public static void extentTestInfo(String message) {
        if (extentTest != null) {
            extentTest.info(message);
        }
    }

    //Create Extent Test object for logging
    public static void createExtentTest(String testName, String testDesc) {
        extentTest = extentReports.createTest(testName, testDesc);
    }

    // ExtentReports nesnesinin flush() metodunu çağırarak rapor dosyasını oluşturur ve kaydeder.
    public static void tearDown() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }


}
