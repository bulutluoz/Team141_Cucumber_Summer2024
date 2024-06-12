package runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/test/java")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/resources/features/wip")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "stepdefinitions")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@wip")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/HtmlReport.html")


public class Runner {
    /*
        Cucumber'da istenen feature/Scenario'lari celistirmak icin kullandigimiz
        Runner class'i BOS bir class'dir.

        Istedigimiz class'lari belirlemek,
        calisan class'lara rapor eklemek
        ve feature dosyalari ile stepdefinitions class'larini irtibatlandirmak icin
        notasyonlar kullanacagiz


        dry run = true secildiginde kodlari calistirmaya gayret etmez
                       SADECE eksik adim var mi diye kontrol eder
                       ve varsa eksik adimlari bizim icin olusturur
                       Eksik adim yoksa KODLARI CALISTIRMAZ,
                       eksik adim kalmadigini soylemek icin test passed yazdirir
     */
}
