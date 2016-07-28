# QrCardParsing

[![Platform (Android)](https://img.shields.io/badge/platform-Android-blue.svg?style=flat-square)](http://www.android.com)

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-QrCardParsing-green.svg?style=true)](https://android-arsenal.com/details/1/3978)

Android Libraries to parsing and generate MeCard - VCard and WifiCard content string.

![Screen](https://raw.githubusercontent.com/RurioLuca/MeCardParsing/master/img/screen.png)


### Requirements

The library requires Android **API Level 7+**.


### Import

in build.gradle

```Gradle
allprojects {
    repositories {
        jcenter()
    }
}

```
```Gradle
dependencies {
compile 'it.auron:mecard-parser:1.0.2'
}
```

### How to use

#### Generate MeCard content
```java
        MeCard meCard =new MeCard();
        meCard.setName("Rurio Luca");
        meCard.setDate("1989-07-19");
        meCard.setEmail("rurio.luca@gmail.com");
        meCard.setNote("generate MeCard string content!");
        meCard.addTelephone("+39 3486454313");
        meCard.addTelephone("+39 3476512321");
        meCard.setUrl("https://github.com/RurioLuca");
        meCard.setAddress("via del corso , Rome , Italy");
        String meCardContent=meCard.buildString();
        
        //sample using QrGen to generate QrCode bitmap
        imageView.setImageBitmap(QRCode.from(meCardcontent).bitmap());
```
#### Parsing MeCard content

```java

   String meCardString = "MECARD:N:Rurio Luca;TEL:+39 3486454313;EMAIL:rurio.luca@gmail.com;URL:https://github.com/RurioLuca;NOTE:generate MeCard!;BDAY:1989-07-19;ADR:via del corso , Rome , Italy;";
       
   MeCard meCard = MeCardParser.parse(meCardString);

   String name = meCard.getName(); 
   //output :Rurio Luca

  meCard.setName("Luca Rurio");
  String meCardContent=meCard.buildString();
  
   //sample using QrGen to generate QrCode bitmap
  imageView.setImageBitmap(QRCode.from(meCardcontent).bitmap());
  
```


#### Generate VCard content

```java

        VCard vCard=new VCard();
        vCard.setName("Luca");
        vCard.setAddress("via del corso");
        vCard.setCompany("freelancer");
        vCard.setEmail("rurio.luca@gmail.com");
        vCard.setTelephone("+39 3486454314");
        vCard.setFormattedName("Rurio Luca");
        vCard.setTitle("Developer");
        vCard.setUrl("https://github.com/RurioLuca/MeCardParsing/");
        imageView.setImageBitmap(QRCode.from(vCard.buildString()).bitmap());
        
```
#### Parsing VCard content

```java

 String vCardString = "BEGIN:VCARD\n" +
                "N:Luca\n" +
                "FN:Rurio Luca\n" +
                "ORG:freelancer\n" +
                "TITLE:Developer\n" +
                "EMAIL:rurio.luca@gmail.com\n" +
                "END:VCARD";

        VCard vCard = VCardParser.parse(vCardString);

        vCard.setNote("vCard generate and modified!");
        vCard.setTelephone("+39 3486454314");
        String vCardcontent = vCard.buildString();
        //sample generate bitmap using QrGen
        imageView.setImageBitmap(QRCode.from(vCardcontent).bitmap());


```

#### Generate Wifi content

```java

        WifiCard wifiCard = new WifiCard();
        wifiCard.setSid("Vodafone Wifi32341");
        wifiCard.setPassword("administrator");
        wifiCard.setType("WPA");
        
         //sample generate Qr code using Qrgen
        imageView.setImageBitmap(QRCode.from(wifiCard.buildString()).bitmap());
        
```

#### Parsing Wifi content

```java

        String wifiString = "WIFI:S:Vodafone Wifi32341;T:WPA;P:administrator;;";
        WifiCard wifiCard = WifiCardParser.parse(wifiString);

        wifiCard.setPassword("administrator2016");


        String wifiCardcontent = wifiCard.buildString();

        //sample generate Qr code using Qrgen
        imageView.setImageBitmap(QRCode.from(wifiCardcontent).bitmap());


```
###Developed By
Rurio Luca- [rurio.luca@gmail.com](mailto:rurio.luca@gmail.com)

[![Linkedin](https://raw.githubusercontent.com/RurioLuca/MeCardParsing/master/img/social/linkedin-icon.png) ](https://it.linkedin.com/in/luca-rurio-5a4462107)

###App using QrCardParsing
=======

  * [Material Qr](https://play.google.com/store/apps/details?id=qrreader.com.studios.it.qrreader)

send me your apps!
rurio.luca@gmail.com

# License

The MIT License (MIT)

Copyright (c) 2016 Rurio Luca

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
