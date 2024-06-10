package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import pages.HeroquPage;

public class HeroquAppStepdefinitions {
    HeroquPage heroquPage = new HeroquPage();

    @When("kullanici Add Element butonuna basar")
    public void kullanici_add_element_butonuna_basar() {
        heroquPage.addElementButonu.click();
    }
    @When("Delete butonu’nun gorunur oldugunu test eder")
    public void delete_butonu_nun_gorunur_oldugunu_test_eder() {
        Assertions.assertTrue(heroquPage.deleteButonu.isDisplayed());
    }
    @Then("Delete tusuna basar")
    public void delete_tusuna_basar() {
        heroquPage.deleteButonu.click();
    }
    @Then("Delete butonunun kayboldugunu test eder")
    public void delete_butonunun_kayboldugunu_test_eder() {

        boolean deleteButonuKayipMi = false;

        try {
            Assertions.assertFalse(heroquPage.deleteButonu.isDisplayed());
            // Olmayan bir elementin assert'i olmaz
            // olmayan elementi kullanmak istedigimizde NoSuchElementException olusur
            // biz de bunu try catch ile firsata cevirdik
            //
        } catch (NoSuchElementException e) {

            deleteButonuKayipMi = true ;
        }

        // bizden istenen asil assertion'i simdi yapalim

        Assertions.assertTrue(deleteButonuKayipMi);

    }
    @Then("Add Remove Elements yazisinin gorunur oldugunu test eder")
    public void add_remove_elements_yazisinin_gorunur_oldugunu_test_eder() {

        Assertions.assertTrue(heroquPage.addRemoveElementYazisi.isDisplayed());

    }

}
