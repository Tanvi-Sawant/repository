package com.AsianCloudUserMgmt.AsianCloudUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;

    By username = By.id("username");

    By password = By.id("password");

    By titleText =By.className("login-pf-page-header");

    By submit = By.name("login");
    
    By register = By.linkText("Register");
//href="/auth/realms/asians/login-actions/registration?client_id=public&tab_id=bEyPTf1kao8"
    By error = By.id("input-error");

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }
  //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(username).sendKeys(strUserName);

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

         driver.findElement(password).sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){

            driver.findElement(submit).click();

    }
    
    public String getErrorMessage() {
    	WebElement element = (new WebDriverWait(driver, 10))
 			   .until(ExpectedConditions.elementToBeClickable(error));
    	return (element.getText());
    
    }
    
  //Click on register button

    public void clickRegister(){

            driver.findElement(register).click();

    }

    //Get the title of Login Page

    public String getLoginTitle(){

     return    driver.findElement(titleText).getText();

    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void login(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();        
    }


}

