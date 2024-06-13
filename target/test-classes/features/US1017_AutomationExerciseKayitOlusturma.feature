
  Feature: US1017 kullanici fake bilgilerle kayit olusturur

    Scenario:TC23 fake bilgilerle kayit olusturulabilmeli

      Given kullanici "automationUrl" anasayfaya gider
      Then cookies kabul eder
      And user sign up linkine tiklar
      And user New user signUp bolumune fake name ve email adresi girer
      And signUp butonuna basar
      And user fake bilgilerle kisisel bilgilerini ve iletisim bilgilerini girer
      And user Create Account butonuna basar
      Then hesap olustugunu test eder
