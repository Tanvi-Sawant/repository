package com.AsianCloudUserMgmt.AsianCloudUser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRegisterAndLogin {
	
	WebDriver driver;

    LoginPage objLogin;
    
    RegisterPage objRegister;

    AsianCloudSystemPage objUserSystemPage;
    
    
    @BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		this.driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://console.uat.asians.group/#/domain/list");
		driver.manage().window().maximize();
		
	}
        
    
    @Test(priority=0)

    public void test_Verify_Register_New_User(){

        //Create Login Page object

    objLogin = new LoginPage(driver);
    //click on register
    objLogin.clickRegister();
    
    objRegister= new RegisterPage(driver);
    String registerPageTitle=objRegister.getRegisterTitle();
    Assert.assertTrue(registerPageTitle.toLowerCase().contains("register"));
    
    objRegister.register("test12345@gmail.com", "Test@123", "Test@123");

    //Verify home page title
    objUserSystemPage = new AsianCloudSystemPage(driver);

    boolean userLoggedIn = objUserSystemPage.getUserProfile();
   
    Assert.assertTrue(userLoggedIn);

    }
    
    @Test(priority=1)

    public void test_Verify_Register_Existing_User(){

        //Create Login Page object

    objLogin = new LoginPage(driver);
    //login to application
    objLogin.clickRegister();
    
    objRegister= new RegisterPage(driver);
    //String registerPageTitle=objRegister.getRegisterTitle();
    //Assert.assertTrue(registerPageTitle.toLowerCase().contains("register"));
    
    objRegister.register("test12345@gmail.com", "Test@123", "Test@123");
    
    String errMsg=objRegister.getErrorMessage();
    //System.out.println(errMsg);
    Assert.assertTrue((errMsg.toLowerCase()).contains("email already exists."));
    
    }
    
    @Test(priority=2)

    public void test_Verify_Login_Valid_Credentials(){

        //Create Login Page object

    objLogin = new LoginPage(driver);
    //login to application
    objLogin.login("test12345@gmail.com", "Test@123");

    //Verify home page title
    objUserSystemPage = new AsianCloudSystemPage(driver);

    boolean homeUserProfile = objUserSystemPage.getUserProfile();

    Assert.assertTrue(homeUserProfile);

    }
   
    @Test(priority=3)
    public void test_Verify_Login_Invalid_Credentials(){

        //Create Login Page object

    objLogin = new LoginPage(driver);
    //login to application
    objLogin.login("mgr123", "mgr!23");

    String errMsg=objLogin.getErrorMessage();
    Assert.assertTrue(errMsg.toLowerCase().contains("invalid username or password."));

    }
    
    
    @AfterMethod
	public void tearDown() {
		driver.close();
	}

}
