package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.EditorPage;
import utilities.Driver;

public class EditorStepdefinitons {

    EditorPage editorPage = new EditorPage();

    @Then("new butonuna basar")
    public void new_butonuna_basar() {
        editorPage.newButonu.click();
    }
    @Then("kayit icin {string} {string} {string} {string} {string} {string} ve {string} degerlerini girer")
    public void kayit_icin_ve_degerlerini_girer(String firstName, String lastname, String position, String office, String extension, String startDate, String salary) {

        Actions actions = new Actions(Driver.getDriver());

        actions.click(editorPage.firstName)
                .sendKeys(firstName)
                .sendKeys(Keys.TAB)
                .sendKeys(lastname)
                .sendKeys(Keys.TAB)
                .sendKeys(position)
                .sendKeys(Keys.TAB)
                .sendKeys(office)
                .sendKeys(Keys.TAB)
                .sendKeys(extension)
                .sendKeys(Keys.TAB)
                .sendKeys(startDate)
                .sendKeys(Keys.TAB)
                .sendKeys(salary)
                .perform();

    }
    @Then("Create tusuna basar")
    public void create_tusuna_basar() {
        editorPage.createButonu.click();
    }
    @When("kullanici {string} ile arama yapar")
    public void kullanici_ile_arama_yapar(String firstName) {

        editorPage.searchKutusu.sendKeys(firstName );
    }


    @Then("isim bolumunde {string} oldugunu dogrular")
    public void isimBolumundeOldugunuDogrular(String firstName) {

        String actualIsimSoyisim = editorPage
                                        .tablodanIlkIsimElementi
                                        .getText();

        Assertions.assertTrue(actualIsimSoyisim.contains(firstName));

    }
}
