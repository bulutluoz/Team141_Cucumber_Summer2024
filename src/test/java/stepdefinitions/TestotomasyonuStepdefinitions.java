package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestotomasyonuStepdefinitions {
    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
    String exceldeArananUrunIsmi;
    double exceldeArananUrunMinSonucSayisi;
    double aramaSonucundaBulunanSonucSayisi;

    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullanici_testotomasyonu_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }
    @When("arama kutusuna phone yazip aratir")
    public void arama_kutusuna_phone_yazip_aratir() {
        testotomasyonuPage.aramakutusu.sendKeys("phone" + Keys.ENTER);
    }
    @Then("arama sonucunda urun bulunabildigini test eder")
    public void arama_sonucunda_urun_bulunabildigini_test_eder() {
        Assertions.assertTrue(testotomasyonuPage.sonucElementleriList.size()>0);
    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.quitDriver();
    }


    @When("arama kutusuna dress yazip aratir")
    public void aramaKutusunaDressYazipAratir() {
        testotomasyonuPage.aramakutusu.sendKeys("dress" + Keys.ENTER);
    }

    @When("arama kutusuna samsung yazip aratir")
    public void aramaKutusunaSamsungYazipAratir() {

        testotomasyonuPage.aramakutusu.sendKeys("samsung" + Keys.ENTER);
    }

    @When("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipAratir(String istenenKelime) {

        testotomasyonuPage.aramakutusu.sendKeys(istenenKelime + Keys.ENTER);
    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int beklenecekSure) {

        try {
            Thread.sleep(beklenecekSure*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String configdenIstenenUrl) {
        Driver.getDriver().get(   ConfigReader.getProperty(configdenIstenenUrl)   );

    }
    @Then("account butonuna basar")
    public void account_butonuna_basar() {
        testotomasyonuPage.accountLinki.click();
    }
    @Then("email olarak {string} girer")
    public void email_olarak_girer(String configVerilenEmail) {
        testotomasyonuPage.loginEmailKutusu.sendKeys(  ConfigReader.getProperty(configVerilenEmail)     );
    }
    @Then("password olarak {string} girer")
    public void password_olarak_girer(String configVerilenPassword) {
        testotomasyonuPage.loginPasswordKutusu
                            .sendKeys(   ConfigReader.getProperty(configVerilenPassword)   );
    }
    @Then("signIn butonuna basar")
    public void sign_in_butonuna_basar() {
        testotomasyonuPage.loginSiginButonu
                            .click();
    }
    @Then("basarili giris yapilabildigini test eder")
    public void basarili_giris_yapilabildigini_test_eder() {
        // logout butonunun gorunur oldugunu test edelim
        Assertions.assertTrue( testotomasyonuPage.logOutButonu.isDisplayed() );
    }

    @Then("giris yapilamadigini test eder")
    public void girisYapilamadiginiTestEder() {

        try {
            Assertions.assertTrue(testotomasyonuPage.loginSiginButonu.isDisplayed());
        } catch (Exception e) {
            testotomasyonuPage.logOutButonu.click();
            Driver.quitDriver();
            // failed olan assertion'i try catch ile handle ettik
            // logout yaptiktan sonra yeniden testi FAILED etmemiz gerekir
            Assertions.assertTrue(false);
        }
    }

    @When("email olarak direk verilen {string} girer")
    public void emailOlarakDirekVerilenGirer(String direkVerilenEmail) {
        testotomasyonuPage.loginEmailKutusu.sendKeys(direkVerilenEmail);
    }

    @And("password olarak direk verilen {string} girer")
    public void passwordOlarakDirekVerilenGirer(String direkVerilenPassword) {

        testotomasyonuPage.loginPasswordKutusu.sendKeys(direkVerilenPassword);
    }


    @Then("urun excelindeki {string} daki urunun min. miktarini ve urun ismini kaydeder")
    public void urun_excelindeki_daki_urunun_min_miktarini_ve_urun_ismini_kaydeder(String satirNoStr) throws IOException {

        String dosyaYolu = "src/test/resources/urunListesi.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheet("Sheet1");

        int satirNo = Integer.parseInt(satirNoStr);

        exceldeArananUrunIsmi = sheet1
                                    .getRow(satirNo-1)
                                    .getCell(0)
                                    .toString();

        exceldeArananUrunMinSonucSayisi = sheet1
                                            .getRow(satirNo-1)
                                            .getCell(1)
                                            .getNumericCellValue();

    }
    @Then("urun ismini testotomasyonu sayfasinda arar ve sonuc sayisini kaydeder")
    public void urun_ismini_testotomasyonu_sayfasinda_arar_ve_sonuc_sayisini_kaydeder() {
        testotomasyonuPage.aramakutusu.sendKeys(exceldeArananUrunIsmi + Keys.ENTER);

        String sonucYazisi = testotomasyonuPage  // 4 Products Found
                                    .aramaSonucElementi
                                    .getText();

        sonucYazisi = sonucYazisi.replaceAll("\\D",""); // "4"

        aramaSonucundaBulunanSonucSayisi = Double.parseDouble(sonucYazisi);

    }
    @Then("bulunan urun sayisinin {string} da verilen min. miktara esit veya daha fazla oldugunu test eder")
    public void bulunan_urun_sayisinin_da_verilen_min_miktara_esit_veya_daha_fazla_oldugunu_test_eder(String satirNoStr) {

        Assertions.assertTrue( aramaSonucundaBulunanSonucSayisi >= exceldeArananUrunMinSonucSayisi);
    }

    @And("arama sonucunda urun bulunamadigini test eder")
    public void aramaSonucundaUrunBulunamadiginiTestEder() {

        String expectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = testotomasyonuPage
                                            .aramaSonucElementi
                                            .getText();

        Assertions.assertEquals(expectedAramaSonucu,actualAramaSonucu);
    }
}
