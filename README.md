# QrCardParsing

[![Platform (Android)](https://img.shields.io/badge/platform-Android-blue.svg?style=flat-square)](http://www.android.com)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-QrCardParsing-green.svg?style=true)](https://android-arsenal.com/details/1/3978)
[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/RurioLuca/QrCardParsing/blob/master/License)
<!-- [![Codewake](https://www.codewake.com/badges/ask_question_flat_square.svg)](https://www.codewake.com/p/qrcardparsing) -->
[ ![Download](https://api.bintray.com/packages/auron/maven/mecard-parser/images/download.svg) ](https://bintray.com/auron/maven/mecard-parser/_latestVersion) 
[![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14)
 [![GitHub stars](https://img.shields.io/github/stars/RurioLuca/QrCardParsing.svg)](https://github.com/RurioLuca/QrCardParsing/stargazers)
 
Android Libraries to parsing and generate content of:

- MeCard
- VCard
- VEvent
- WifiCard 
- GeoCard

![Screen](https://raw.githubusercontent.com/RurioLuca/MeCardParsing/master/img/screen.png)


### Requirements

The library requires Android **API Level 14+**.

if you need a higher backward compatibility, use version 1.1.3 or lower (api level 9+)
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
// ... other dependencies here
implementation 'it.auron:mecard-parser:1.1.5'
}
```

### How to use

#### Generate MeCard content
```java
        MeCard meCard =new MeCard();
        meCard.setName("Luca");
        meCard.setSurname("Rurio");
        meCard.setDate("1989-07-19");
        meCard.setEmail("rurio.luca@gmail.com");
        meCard.setNote("generate MeCard string content!");
        meCard.addTelephone("+39 3486454313");
        meCard.addTelephone("+39 3476512321");
        meCard.setUrl("https://github.com/RurioLuca");
        meCard.setAddress("via del corso , Rome , Italy");
        meCard.setOrg("your company");
        String meCardContent=meCard.buildString();
        
        //sample using QrGen to generate QrCode bitmap
        imageView.setImageBitmap(QRCode.from(meCardcontent).bitmap());
```
#### Parsing MeCard content

```java

   String meCardString = "MECARD:N:Rurio,Luca;TEL:+39 3486454313;EMAIL:rurio.luca@gmail.com;URL:https://github.com/RurioLuca;NOTE:generate MeCard!;BDAY:1989-07-19;ADR:via del corso , Rome , Italy;ORG:your company;";
       
   MeCard meCard = MeCardParser.parse(meCardString);

   String name = meCard.getName(); 
   //output :Luca
    String name = meCard.getEmail(); 
    //output :rurio.luca@gmail.com
    
  meCard.setDate("1989-07-19");
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
        vCard.addEmail("rurio.luca@gmail.com");
        vCard.addTelephone("+39 3486454314");
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
                "URL:https://yoursite.com\n" +
                "END:VCARD";

        VCard vCard = VCardParser.parse(vCardString);

        vCard.setNote("vCard generate and modified!");
        vCard.addTelephone("+39 3486454314");
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

#### Generate VEvent content

```java

        VEvent vEvent = new VEvent();
        vEvent.Summary("Google IO");
        vEvent.Location("Shoreline Amphitheatre Mountain View, California");
        vEvent.Url("www.sample.com");
        vEvent.setDtStart("20170611T130000Z");
        vEvent.setDtEnd("20170611T153400Z");
        
         //sample generate Qr code using Qrgen
        imageView.setImageBitmap(QRCode.from(vEvent.buildString()).bitmap());
        
```

#### Parsing VEvent content

```java

        String vEventString = "BEGIN:VEVENT\n" +
                "SUMMARY:Google IO\n" +
                "LOCATION:Shoreline Amphitheatre Mountain View, California\n" +
                "DTSTART:20170611T130000Z\n" +
                "DTEND:20170611T153400Z\n" +
                "END:VEVENT";
                
       VEvent vEvent = VEventParser.parse(vEventString);
       vEvent.setSummary("Google I/O");
      
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(VEventCostant.DATE_FORMAT);
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(vEvent.getDtEnd()));
            calendar.set(Calendar.DAY_OF_MONTH, 12);
            calendar.set(Calendar.HOUR_OF_DAY, 14);
            calendar.set(Calendar.MINUTE, 00);
            vEvent.setDtEnd(simpleDateFormat.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        


        String vEventcontent = vEvent.buildString();

        //sample generate Qr code using Qrgen
        imageView.setImageBitmap(QRCode.from(vEventcontent).bitmap());


```

#### Generate Geolocation content

```java

        GeoCard geoCard = new GeoCard();

        geoCard.setLat(41.8919300);
        geoCard.setLon(12.5113300);
        
         //sample generate Qr code using Qrgen
        imageView.setImageBitmap(QRCode.from(geoCard.buildString()).bitmap());
        
```

#### Parsing Geolocation content

```java

      String geoString = "geo:20.33470,20.39448";
      GeoCard geoCard = GeoCardParser.parse(geoString);
       
       // set Rome location
       geoCard.setLat(41.8919300);
       geoCard.setLon(12.5113300);


        String geoCardcontent = geoCard.buildString();

        //sample generate Qr code using Qrgen
        imageView.setImageBitmap(QRCode.from(geoCardcontent).bitmap());


```

### Developed By
Rurio Luca- [rurio.luca@gmail.com](mailto:rurio.luca@gmail.com)

[![Linkedin](https://raw.githubusercontent.com/RurioLuca/MeCardParsing/master/img/social/linkedin-icon.png) ](https://it.linkedin.com/in/luca-rurio-5a4462107)

### App using QrCardParsing


  * [Material Qr](https://play.google.com/store/apps/details?id=qrreader.com.studios.it.qrreader)
  * [Mercatini Usato](https://play.google.com/store/apps/details?id=it.auron.mercatino&hl=it)

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
