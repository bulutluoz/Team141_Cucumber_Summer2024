package runners;

    /*
        1- Cucumber'da Feature dosyasindan
           istenen Feature veya Scenario'yu calistirabiliriz
           Ancak bu durumda Cucumber hicbir rapor olusturmaz

        2- Runner class'larindan calistirinca
           HTML, Xml veya Json raporlar alinabilir
           Istedigimiz data turunden rapor alabilmek icin ayri ayri Runner'lar hazirladik.
           Hangi rapor turunu elde etmek istiyorsak, o Runner kullanilabilir

        3- EGER daha gelismis raporlar ve/veya paralel calistirma istersek
           pom.xml'e gerekli plugin'leri eklemeli
           ve plugin'leri istedigimiz Runner class'larini calistiracak sekilde duzenlemeli
           Ve terminalden "mvn clean verify" komutu ile calistirmaliyiz

     */

public class Aciklamalar {
}
