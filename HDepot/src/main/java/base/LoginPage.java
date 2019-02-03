package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends CommonAPI {

    @FindBy(id = "email_id")
    public static WebElement emailBox;
    @FindBy(id = "password")
    public static WebElement passwordBox;
    @FindBy(xpath = "//*[@id='accountSignIn']/span")
    public static WebElement signinButton;
    @FindBy(xpath = "//span[contains(text(),'your email')]")
    public static WebElement errorEmailMessage;
    @FindBy(xpath = "//span[contains(text(),'your password')]")
    public static WebElement errorPasswordMessage;
    @FindBy(xpath = "//a[contains(text(),'Forgot')]")
    public static WebElement forgotPasswordLink;
    @FindBy(xpath = "//*[@id='forgotpasswordEmail']")
    public static WebElement forgotPasswordEmail;
    @FindBy(xpath = "//span[text()='Submit']")
    public static WebElement forgotPasswordSubmit;
    @FindBy(xpath = "//*[@id='userLogin']/div/div[5]/a[1]")
    public static WebElement termsConditionLink;
    @FindBy(xpath = "//*[@id='userLogin']/div/div[5]/a[2]")
    public static WebElement privacySecurityLink;
    @FindBy(xpath = "//*[@id='container']/div[2]//h1")
    public static WebElement termsConditionText;
    public static boolean checkEmailTextBoxEnable() {
        boolean bl = emailBox.isEnabled();
        return bl;
    }
    public static boolean checkPasswordTextBoxEnable() {
        boolean pb = passwordBox.isEnabled();
        return pb;
    }
    public static boolean checkSignInButton() {
        emailBox.sendKeys("farzad");
        passwordBox.sendKeys("abcd123");
        boolean bl = signinButton.isEnabled();
        System.out.println(bl);
        return bl;
    }
    public static String invalidEmail() {
        emailBox.sendKeys("farzad", Keys.ENTER);
        String str = errorEmailMessage.getText();
        return str;
    }
    public static String invalidPassword() {
        passwordBox.sendKeys("", Keys.ENTER);
        String str = errorPasswordMessage.getText();
        return str;
    }
    public static String verifyMyAccount() throws InterruptedException {
        int con = driver.findElements(By.xpath("//*[@id='userLogin']/div/div[5]/a[1]")).size();
        driver.findElements(By.xpath("//*[@id='userLogin']/div/div[5]/a[1]")).get(con - 1).click();
        new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(termsConditionText));
        String str = termsConditionText.getText();
        return str;
    }
    public void verifyForgotEmail() throws InterruptedException {
        new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotPasswordLink.click();
        driver.getWindowHandle();
        forgotPasswordEmail.sendKeys("shahid@gmail.com");
        System.out.println("url link " + driver.getCurrentUrl());
        forgotPasswordSubmit.click();
        //implicitWait(driver, 30);
        System.out.println("URL of 'Forgot password' page: " + driver.getCurrentUrl());
    }
    public void checkClearText() {
        emailBox.sendKeys("Siddiqur Rahman");
        emailBox.clear();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        emailBox.sendKeys("shahid@gmail.com");
        emailBox.clear();
    }
    public void enterInvalidEmail() {
        passwordBox.sendKeys("", Keys.ENTER);
    }
}


