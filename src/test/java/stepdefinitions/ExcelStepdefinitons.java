package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ExcelStepdefinitons {

    Sheet sayfa1;
    String istenenHucredekiBilgi;
    static Map<String , Map<String,String> > ulkelerMapi;

    @Given("kullanici baskentler exceline ulasir")
    public void kullanici_baskentler_exceline_ulasir() throws IOException {
        String dosyaYolu = "src/test/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        sayfa1 = workbook.getSheet("Sayfa1");

    }
    @Then("{int}.satir {int}.hucredeki datayi yazdirir")
    public void satir_hucredeki_datayi_yazdirir(Integer satirNo, Integer sutunNo) {

        istenenHucredekiBilgi = sayfa1
                                        .getRow(satirNo-1)
                                        .getCell(sutunNo-1)
                                        .toString();

        System.out.println(istenenHucredekiBilgi);
    }
    @Then("{int}.satir {int}.hucredeki datayi bir string degiskene kaydeder")
    public void satir_hucredeki_datayi_bir_string_degiskene_kaydeder(Integer satirNo, Integer sutunNo) {
        istenenHucredekiBilgi = sayfa1
                                    .getRow(satirNo-1)
                                    .getCell(sutunNo-1)
                                    .toString();

    }
    @Then("kaydedilen datanin {string} oldugunu test eder")
    public void kaydedilen_datanin_oldugunu_test_eder(String expectedHucredekiBilgi) {

        Assertions.assertEquals(expectedHucredekiBilgi,istenenHucredekiBilgi);
    }
    @Then("baskenti Jakarta olan ulkenin Turkce isminin {string} oldugunu test eder")
    public void baskenti_jakarta_olan_ulkenin_turkce_isminin_oldugunu_test_eder(String expectedTurkceUlkeIsmi) {

        String satirdakiBaskentIsmi;
        String satirdakiTurkceUlkeIsmi;

        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            satirdakiBaskentIsmi = sayfa1
                                    .getRow(i)
                                    .getCell(1)
                                    .toString();

            if (satirdakiBaskentIsmi.equalsIgnoreCase("Jakarta")){

                satirdakiTurkceUlkeIsmi = sayfa1
                                            .getRow(i)
                                            .getCell(2)
                                            .toString();
                Assertions.assertEquals(expectedTurkceUlkeIsmi,satirdakiTurkceUlkeIsmi);

            }
        }
    }
    @Then("excelde kayitli ulke sayisinin {int} oldugunu test eder")
    public void excelde_kayitli_ulke_sayisinin_oldugunu_test_eder(Integer expectedUlkeSayisi) {

        int actualUlkeSayisi = sayfa1.getLastRowNum(); // son satirin index'i
        // index'den kullanilan satir sayisina gecmek icin +1 yapmaliyiz
        // baslik satiri ulke olmadigindan onu cikartmaliyiz -1

        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);
    }
    @Then("excelde kullanilan fiziki satir sayisinin {int} oldugunu test eder")
    public void excelde_kullanilan_fiziki_satir_sayisinin_oldugunu_test_eder(Integer expectedKullanilanSatirsayisi) {

        // int actualKullanilanSatirSayisi = sayfa1.getLastRowNum()+1;
        int actualKullanilanSatirSayisi = sayfa1.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedKullanilanSatirsayisi,actualKullanilanSatirSayisi);
    }
    @When("Tum bilgileri map olarak kaydedip")
    public void tum_bilgileri_map_olarak_kaydedip() {

        /*
            Map'i Nested Map olarak olusturmaya karar verdik

            { ulkeIsmiIngilizce = geriyeKalanBilgilerMapi }

            icerdeki map ise
            { "Başkent (İngilizce)"="Baku", "Ülke (Türkçe)"="Azerbaycan",  "Başkent (Türkçe)"="Baku"}

         {
            Afghanistan={baskentIng=Kabul, baskentTurkce=Kabil, ulkeTurkce=Afganistan},
            Albania={baskentIng=Tirana, baskentTurkce=Tiran, ulkeTurkce=Arnavutluk},
            Algeria={baskentIng=Aljiers, baskentTurkce=Cezayir, ulkeTurkce=Cezayir},
            Andorra={baskentIng=Andorra la Vella, baskentTurkce=Andorra la Vella, ulkeTurkce=Andorra}


         */


        ulkelerMapi = new TreeMap<>();

        // her bir satirdaki bilgileri map'e aktaralim

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {
            Map<String,String> geriyeKalanBilgilerMapi  = new TreeMap<>();
            String ingilizceUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            String ingilizceBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();
            String turkceUlkeIsmi = sayfa1.getRow(i).getCell(2).toString();
            String turkceBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();

            geriyeKalanBilgilerMapi.put("baskentIng",ingilizceBaskentIsmi);
            geriyeKalanBilgilerMapi.put("ulkeTurkce",turkceUlkeIsmi);
            geriyeKalanBilgilerMapi.put("baskentTurkce",turkceBaskentIsmi);

            ulkelerMapi.put(ingilizceUlkeIsmi,geriyeKalanBilgilerMapi);
        }

        System.out.println(ulkelerMapi);
    }
    @Then("baskenti Jakarta olan ulkenin tum bilgilerini yazdirir")
    public void baskenti_jakarta_olan_ulkenin_tum_bilgilerini_yazdirir() {

    }
    @Then("mapi kullanarak turkce ismi Hollanda olan bir ulke bulundugunu test eder")
    public void mapi_kullanarak_turkce_ismi_hollanda_olan_bir_ulke_bulundugunu_test_eder() {

    }

}
