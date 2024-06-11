package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import pages.WebUniversityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class WebUniversityStepdefinitions {
    WebUniversityPage webUniversityPage = new WebUniversityPage();
    Faker faker = new Faker();

    @Then("Login Portal a  kadar asagi iner")
    public void login_portal_a_kadar_asagi_iner() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",
                            webUniversityPage.loginPortalElementi);
    }
    @Then("Login Portal a tiklar")
    public void login_portal_a_tiklar() {
        webUniversityPage
                .loginPortalElementi
                .click();
    }
    @When("acilan diger window'a gecer")
    public void acilan_diger_window_a_gecer() {

        ReusableMethods.windowaGec("https://webdriveruniversity.com/Login-Portal/index.html",Driver.getDriver());

    }
    @When("username ve password kutularina fake degerler yazdirir")
    public void username_ve_password_kutularina_fake_degerler_yazdirir() {
        webUniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webUniversityPage.passwordKutusu.sendKeys(faker.internet().password());
    }
    @When("login butonuna basar")
    public void login_butonuna_basar() {
        webUniversityPage
                .loginButonu
                .click();
    }
    @Then("popup'ta cikan yazinin {string} oldugunu test eder")
    public void popup_ta_cikan_yazinin_oldugunu_test_eder(String expectedPopupYazisi) {

        String actualPopupYazisi = Driver.getDriver()
                                            .switchTo().alert()
                                            .getText();

        Assertions.assertEquals(expectedPopupYazisi,actualPopupYazisi);
    }
    @Then("Ok diyerek Popup'i kapatir")
    public void ok_diyerek_popup_i_kapatir() {
        Driver.getDriver()
                .switchTo().alert()
                .accept();
    }
    @Then("ilk window'a geri doner")
    public void ilk_window_a_geri_doner() {
        ReusableMethods.windowaGec("https://webdriveruniversity.com/",Driver.getDriver());
    }
    @Then("ilk window a donuldugunu test eder")
    public void ilk_window_a_donuldugunu_test_eder() {
        String expectedUrl = ConfigReader.getProperty("webUniUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);
    }
}
