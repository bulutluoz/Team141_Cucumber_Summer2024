
Feature: US1008 Kullanici elementler icin bekler

  Scenario: TC14 sonradan gorunen elementler gorunur oluncaya kadar beklenebilmeli

    Given kullanici "heroUrl" anasayfaya gider
    When kullanici Add Element butonuna basar
    And 2 saniye bekler
    And Delete butonu’nun gorunur oldugunu test eder
    Then Delete tusuna basar
    And Delete butonunun kayboldugunu test eder
    And Add Remove Elements yazisinin gorunur oldugunu test eder
    And 2 saniye bekler