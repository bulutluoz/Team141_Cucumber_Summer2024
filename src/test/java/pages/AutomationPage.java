package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationPage {

    public AutomationPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='fa fa-lock']")
    public WebElement signupLinki;


    @FindBy(xpath = "//*[@data-qa='signup-name']")
    public  WebElement nameBox;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public  WebElement signupButonu;

    @FindBy (xpath = "(//*[@class='fc-button-label'])[1]")
    public WebElement cookies;

    @FindBy(id = "id_gender1")
    public WebElement mrRadioButton;

    @FindBy(xpath = "//*[text()='Create Account']")
    public WebElement createAccountButonu;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreatedYaziElementi;
}
