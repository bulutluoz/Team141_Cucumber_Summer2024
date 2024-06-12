
  @smoke
  Feature: US1003 kullanici testotomasyonu sayfasinda istedigi kelimeyi aratir

    Scenario: TC07 Kullanici istedigi kelimeyi aratabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna "baby" yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And 5 saniye bekler
    And sayfayi kapatir