
  Feature: US1014 Guru99 sayfasindaki tablodan istenen sutunu yazdirma

    Scenario: TC20 kullanici tablodan istedigi sutunu yazdirabilmeli

      Given kullanici "guruUrl" anasayfaya gider
      And "Prev Close (Rs)", sutunundaki tum degerleri yazdirir
      And tum sayfa screenshot alip "guruWebTableTesti" ismi ile kaydeder


