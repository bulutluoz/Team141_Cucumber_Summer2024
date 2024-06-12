package stepdefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Guru99Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class Guru99Stepdefinitions {

    Guru99Page guru99Page = new Guru99Page();

    @And("{string}, sutunundaki tum degerleri yazdirir")
    public void sutunundakiTumDegerleriYazdirir(String istenenSutunBasligi) {

        List<String> basliklarListesi = ReusableMethods
                                        .stringListesineDonustur(guru99Page.baslikElementleriListesi);


        int sutunIndexi = basliklarListesi.indexOf(istenenSutunBasligi);


        // tablodaki sutunlarin dinamik xpath'ini bulmaliyiz
        // (//tbody)[2]//tr/td[      4      ]

        String dinamikXpath = "(//tbody)[2]//tr/td[" + (sutunIndexi+1) + "]" ;

        List<WebElement> istenenSutundakiWebelementlerListesi =
                Driver.getDriver().findElements(By.xpath(dinamikXpath));

        System.out.println(ReusableMethods.stringListesineDonustur(istenenSutundakiWebelementlerListesi));
    }

    @And("tum sayfa screenshot alip {string} ismi ile kaydeder")
    public void tumSayfaScreenshotAlipIsmiIleKaydeder(String raporAdiStr) {
        ReusableMethods.tumSayfaScreenshot(Driver.getDriver(),raporAdiStr);
    }
}
