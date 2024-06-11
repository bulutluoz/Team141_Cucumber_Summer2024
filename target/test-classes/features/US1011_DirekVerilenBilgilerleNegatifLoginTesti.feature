
  Feature: US1011 Direk verilen yanlis bilgilerle giris yapilamaz

    Scenario Outline: TC17 direk verilen gecersiz bilgilerle giris yapilamamali

      Given kullanici "toUrl" anasayfaya gider
      Then account butonuna basar
      When email olarak direk verilen "<verilenEmail>" girer
      And password olarak direk verilen "<verilenPassword>" girer
      And 3 saniye bekler
      Then signIn butonuna basar
      And giris yapilamadigini test eder
      And 1 saniye bekler
    #Then sayfayi kapatir

      Examples:
        |verilenEmail    	|verilenPassword    	|
        |murat@akar.com  	|76jrf6 	|
        |selcuk@gmail.com	|53535  	|
        |selin@wise.com 	|rdgdtds 	|
        |damra@gmail.com	|g56435 	|
        |bugra@gmail.com	|23456  	|