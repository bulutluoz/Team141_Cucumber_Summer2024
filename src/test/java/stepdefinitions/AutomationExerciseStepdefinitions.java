package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AutomationPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class AutomationExerciseStepdefinitions {

    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    AutomationPage automationPage = new AutomationPage();
    String fakeFirstName;

    @Given("user sign up linkine tiklar")
    public void user_sign_up_linkine_tiklar() {
        automationPage.signupLinki.click();
    }
    @Given("user New user signUp bolumune fake name ve email adresi girer")
    public void user_new_user_sign_up_bolumune_fake_name_ve_email_adresi_girer() {

        fakeFirstName = faker.name().firstName();

        actions.click(automationPage.nameBox)
                .sendKeys(fakeFirstName)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .perform();

    }
    @Given("signUp butonuna basar")
    public void sign_up_butonuna_basar() {
        automationPage.signupButonu.click();
    }
    @Then("cookies kabul eder")
    public void cookies_kabul_eder() {
        automationPage.cookies.click();
    }
    @Then("user fake bilgilerle kisisel bilgilerini ve iletisim bilgilerini girer")
    public void user_fake_bilgilerle_kisisel_bilgilerini_ve_iletisim_bilgilerini_girer() {
        actions.click(automationPage.mrRadioButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeFirstName)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Texas")
                .sendKeys(Keys.TAB)
                .sendKeys("Dallas")
                .sendKeys(Keys.TAB)
                .sendKeys("71000")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .perform();


        ReusableMethods.bekle(5);
    }
    @Then("user Create Account butonuna basar")
    public void user_create_account_butonuna_basar() {
        automationPage.createAccountButonu.click();
    }
    @Then("hesap olustugunu test eder")
    public void hesap_olustugunu_test_eder() {
        Assertions.assertTrue(automationPage.accountCreatedYaziElementi.isDisplayed());
    }

}
