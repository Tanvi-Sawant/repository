package com.AsianCloudUserMgmt.AsianCloudUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AsianCloudSystemPage {

	WebDriver driver;

    By titleText =By.className("");

    By userProfile = By.className("vue-avatar--wrapper");
    
    


    public AsianCloudSystemPage(WebDriver driver){

        this.driver = driver;

    }
  //Set user name in textbox

    public String getPageTitle(){

        return (driver.findElement(titleText).getText());

    }
    
    public boolean getUserProfile(){

        return (driver.findElement(userProfile).isDisplayed());

    }

}
