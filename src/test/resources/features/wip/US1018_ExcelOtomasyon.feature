
  Feature: US1018 kullanici excel'de verilen gorevleri yapar

    Scenario: TC24 Excel'de datalar kullanilabilmeli

      Given kullanici baskentler exceline ulasir
      Then 1.satir 2.hucredeki datayi yazdirir
      And 1.satir 2.hucredeki datayi bir string degiskene kaydeder
      And kaydedilen datanin "Başkent (İngilizce)" oldugunu test eder
      Then baskenti Jakarta olan ulkenin Turkce isminin "Endonezya" oldugunu test eder
      And excelde kayitli ulke sayisinin 190 oldugunu test eder
      And excelde kullanilan fiziki satir sayisinin 191 oldugunu test eder
      When Tum bilgileri map olarak kaydedip
      Then baskenti Jakarta olan ulkenin tum bilgilerini yazdirir
      And mapi kullanarak turkce ismi Hollanda olan bir ulke bulundugunu test eder
