package com.AsianCloudUserMgmt.AsianCloudUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage {
	WebDriver driver;

    By email = By.id("email");

    By password = By.id("password");

    By confirmPassword =By.id("password-confirm");

    By submit = By.xpath("//input[@value='Register']");
    
    By titleText =By.id("kc-page-title");
    
    By error= By.xpath("//div/span[text()='Email already exists.']");

    public RegisterPage(WebDriver driver){

        this.driver = driver;

    }
  //Set email in textbox

    public void setUserName(String strEmail){

        driver.findElement(email).sendKeys(strEmail);

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

         driver.findElement(password).sendKeys(strPassword);

    }
    
  //Set password in confirm password textbox

    public void setConfirmPassword(String strConfirmPassword){

         driver.findElement(confirmPassword).sendKeys(strConfirmPassword);

    }

    //Click on login button

    public void clickLogin(){

            driver.findElement(submit).click();

    }

    //Get the title of Login Page

    public String getRegisterTitle(){

     return(driver.findElement(titleText).getText());

    }
    
    public String getErrorMessage() {
    	WebElement element = (new WebDriverWait(driver, 10))
    			   .until(ExpectedConditions.elementToBeClickable(error));
    	return (element.getText());
    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void register(String strUserName,String strPasword, String strConfirmedPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);
        
       //Fill confirmed password

        this.setConfirmPassword(strConfirmedPasword);

        //Click Login button

        this.clickLogin();        
    }



}
