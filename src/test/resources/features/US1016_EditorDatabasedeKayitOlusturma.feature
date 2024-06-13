
  Feature: US1016 Kullanici yeni kayit olusturur
    
    Scenario Outline: TC22 Kullanici kayit olusturabilmeli

    ##Farkli datalarla tabloya 5 kayit ekleyip, asagidaki testi yapin.
      When kullanici "editorUrl" anasayfaya gider
      Then new butonuna basar
      And kayit icin "<FirstName>" "<LastName>" "<Position>" "<Office>" "<Extension>" "<StartDate>" ve "<Salary>" degerlerini girer
      Then 2 saniye bekler
      And Create tusuna basar
      When kullanici "<FirstName>" ile arama yapar
      Then 1 saniye bekler
      Then isim bolumunde "<FirstName>" oldugunu dogrular

      Examples:

      |FirstName |LastName |Position|Office|Extension|StartDate |Salary|
      |Ilgar     |Ganbarov |QA      |Berlin|Junior   |2024-10-10|69000 |
      |Ramazan   |Esen     |QA      |Ankara|Junior   |2024-07-07|50000 |
      |Kubra     |Nur      |QA      |Bursa |Junior   |2024-08-08|35000 |
      |Nuran     |Yilmaz   |QA      |Izmir |teamLead |2024-09-09|69000 |
      |Seren     |Serengil |QA      |Bonn  |Junior   |2024-11-11|75000 |