# Movie-Creator

##Kullanılan Teknolojiler
* Java 11, Spring Boot *2.5.2.RELEASE*, Spring Data, Spring Web, Spring Security, Thymeleaf
* Yardımcı Kütüphaneler 
    * Lombok
    * Spring Boot Devtools
    
* Veritabanı
    * H2 (In-Memory)
    * MySQL

##Kurulum ve Kullanım

Movie-Creator projesi clone edilip 

* IDE üzerine import edilip direkt olarak Spring Boot projesi run edilebilir.
* Proje dizininde,
- ***>mvn clean install***
- ***>cd target; java -jar movie-creator-0.0.1-SNAPSHOT.jar*** 

Her iki işlemde de proje in memory bir H2 veritabanı ile birlikte 8081 portunda ayağa kalkacaktır. MySQL ile çalışılmak istenirse application.properties dosyası üzerinde var olan konfigürasyonları aktif duruma getirilip çalışılabilir.

* Proje iki farklı ekrandan oluşmaktadır. Sign Up alanından kullanıcı oluşturulup Movie veya Actor butonları ile direkt olarak listeleme ekranlarına gidilir.

###Movies
* Mevcut movie kayıtlarının listelendiği ekrandır. Yeni bir movie oluşturulabilir, movie adına ve genre tipine göre arama yapılabilir, mevcut bir movie silinebilir, düzenlenebilir ve movie içerisine aktör eklenip çıkarılabilir.

###Actors
* Mevcut actor kayıtlarının listelendiği ekrandır. Yeni bir aktör oluşturulabilir, aktör adına göre arama yapılabilir, mevcut bir aktör silinebilir ve düzenlenebilir.

###Users
* Mevcut user kayıtlarına sadece ADMIN rolüne sahip bir kullanıcı ile listeleyebilir ve üzerinde işlem yapılabilir.
* Proje'de mevcut olmayan bir user ile işlem yapılamaz. 