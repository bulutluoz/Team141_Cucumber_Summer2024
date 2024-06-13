
  Feature: US1016 Kullanici yeni kayit olusturur
    
    Scenario Outline: TC22 Kullanici kayit olusturabilmeli

    ##Farkli datalarla tabloya 5 kayit ekleyip, asagidaki testi yapin.
      When kullanici "editorUrl" anasayfaya gider
      Then new butonuna basar
      And kayit icin "<FirstName>" "<LastName>" "<Position>" "<Office>" "<Extension>" "<StartDate>" ve "<Salary>" degerlerini girer
      And Create tusuna basar
      When kullanici "<Firstname>" ile arama yapar
      Then isim bolumunde isminin oldugunu dogrular

      Examples:

      |FirstName |LastName |Position|Office|Extension|StartDate |Salary|
      |Ilgar     |Ganbarov |QA      |Berlin|Junior   |1-7-2024  |69000 |
      |Ramazan   |Esen     |QA      |Ankara|Junior   |10-7-2024 |50000 |
      |Kubra     |Nur      |QA      |Bursa |Junior   |15-7-2024 |35000 |
      |Nuran     |Yilmaz   |QA      |Izmir |team lead|12-7-2024 |69000 |
      |Seren     |Serengil |QA      |Bonn  |Junior   |1-7-2024  |75000 |