package utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportsListener implements ITestListener {

    //Extent Report is created, when test starts
    @Override
    public void onStart(ITestContext context) {
        ExtentReportUtil.createExtentReports();
    }

    //testName and description are added, when test starts
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName();
        String testDescription = result.getMethod().getDescription();
        ExtentReportUtil.createExtentTest(testName, testDescription);
        ExtentReportUtil.extentTestInfo("Test Başladı");
    }

    //Test successful message and mark are added, when test passes
    @Override
    public void onTestSuccess(ITestResult result) {
        String passMark = "&#9989";
        ExtentReportUtil.extentTestPass("<span style='color:green; font-weight:bold'>TEST PASSED  </span> " + passMark);
        ExtentReportUtil.extentTestInfo(ExtentReportUtil.message);
    }

    //Test fail message and mark are added and screenshot is taken, when test fails
    @Override
    public void onTestFailure(ITestResult result) {
        //Taking screenshot
        File goruntu = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/src/test/java/reports/screenshots/" + currentDate + "image.png";
        File file = new File(path);

        try {
            // Ekran görüntüsünü dosyaya kaydetme
            FileUtils.copyFile(goruntu, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            ReusableMethods.getScreenshot(result.getMethod().getMethodName());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        //Adding fail message
        String failMark = "&#10060";
        ExtentReportUtil.extentTestFail("<span style='color:red; font-weight:bold'>TEST FAILED!  </span> " + failMark);
        ExtentReportUtil.extentTestFail(ExtentReportUtil.message);

        //Reporting
        try {
            ExtentReportUtil.extentTest.
                    fail("<span style='color:green; font-weight:bold; font-size: 16px'>SCREENSHOT</span><br>(Resmi büyütmek için üzerine tıklayınız.)",
                            MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Driver.closeDriver();
        }
    }

    //Extent Report is closed, when test finishes
    @Override
    public void onFinish(ITestContext context) {
        ExtentReportUtil.tearDown();
    }


}
