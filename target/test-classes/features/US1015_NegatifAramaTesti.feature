
# testotomasyonu sayfasina gidin
# verilen kelimelerin sitede bulunmadigini tek tek test edin
# Java, Cokokrem, Nutella, Pizza, Masa, Sandalye
  @negatif
  Feature: US1015 Negatif arama testi

    Scenario Outline: TC21 verilen kelimeler sitede bulunamamali
      Given kullanici "toUrl" anasayfaya gider
      Then arama kutusuna "<aranacakKelime>" yazip aratir
      And arama sonucunda urun bulunamadigini test eder


      Examples:
      |aranacakKelime |
      |Java           |
      |Apple          |
      |Nutella        |
      |Pizza          |
      |Masa           |
      |Sandalye       |