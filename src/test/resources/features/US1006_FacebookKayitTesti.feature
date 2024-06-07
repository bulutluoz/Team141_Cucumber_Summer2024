

  Feature: US1006 kullanici fake bilgilerle facebook'ta kayit olusturur

    Scenario: TC12 Kullanici fake bilgilerle facebook'da kayit olusturabilmeli

      Given kullanici "faceUrl" anasayfaya gider
      Then facebook cookies kabul eder
      And facebook'da yeni hesap olustur butonuna basar
      And 1 saniye bekler
      When Faker class'indan bilgilerle facebook kayit formunu doldurur
      Then 2 saniye bekler
      And facebook kayit ol tusuna basar
      Then 8 saniye bekler
      And sayfayi kapatir