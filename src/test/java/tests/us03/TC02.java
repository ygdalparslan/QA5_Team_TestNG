package tests.us03;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P04_MyAccountPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {

    P01_HomePage p01HomePage =new P01_HomePage();

    P04_MyAccountPage p04MyAccountPage =new P04_MyAccountPage();

    @Test
    public void testCase02(){

        Driver.getDriver().get("https://allovercommerce.com/my-account-2/");



    }
}
