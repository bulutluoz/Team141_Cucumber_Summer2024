package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditorPage {

    public EditorPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[@class='dt-button buttons-create']")
    public WebElement newButonu;

    @FindBy(xpath = "//*[@id='DTE_Field_first_name']")
    public WebElement firstName;


    @FindBy(xpath = "//*[@class='btn']")
    public WebElement createButonu;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchKutusu;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public WebElement tablodanIlkIsimElementi;



}
