# Teaching-Resources-Sharing-Platform

Teaching Resources Sharing Platform (V1.0, Christopher)

*Christopher: from Christopher Morcom, the father of computer science -- Alan Turing's "first love"

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

MyEclipse (10 or newer, or Eclipse with javax) is needed to edit and build the transaction backend server. 
Eclipse should be installed to edit and build Android client. (If you choose to use Android Studio, you need to adapt the project to it)
SDK (19 or newer) should be installed, and ADT should adapt to the SDK version.
AnyChat server (r6733 or newer) could be installed, if you want to test the streaming functions in your own environment.
Apache (2 or newer) and Tomcat (7 or newer) are needed to deploy the whole backend server.

* [MyEclipse](https://www.genuitec.com/products/myeclipse/download/)
* [Eclipse](https://www.eclipse.org/downloads/)
* [Android Studio](https://developer.android.com/studio/index.html)
* [AnyChat Server](http://sdk.anychat.cn/html/download.html)
* [Apache](https://httpd.apache.org/download.cgi)
* [Tomcat](https://tomcat.apache.org/download-90.cgi)

## Edit & Deployment

Edit:
1) Download this repository.
2) Open the J2EE (Java Web) project in Transaction Server directory, make your own changes on it via the MyEclipse IDE.
3) Open the Android project in Android Client directory, make your own changes on it through Eclipse with SDK and ADT.
4) Download AnyChat Server, adapt your project to this streaming server (ip, port...)

Deployment:
1) Pack the transaction server as a .war file, deploy it on the Tomcat, config the proxy from Apache to Tomcat at the same time.
2) Export Android project as a .apk file, download and install on your Android mobile devices.
3) Run AnyChat Server on your server.

## Built With

* [MyEclipse](https://www.genuitec.com/products/myeclipse/download/)
* [struts2](https://struts.apache.org/)
* [Hibernate](http://hibernate.org/orm/releases/5.2/)
* [Spring](https://projects.spring.io/spring-framework/)
* [BaiduMap SDK](http://lbsyun.baidu.com/index.php?title=androidsdk)
* [AnyChat SDK](http://sdk.anychat.cn/html/download.html)
* [Eclipse](https://www.eclipse.org/downloads/)
* [Android Studio](https://developer.android.com/studio/index.html)
* [AnyChat Server](http://sdk.anychat.cn/html/download.html)
* [Apache](https://httpd.apache.org/download.cgi)
* [Tomcat](https://tomcat.apache.org/download-90.cgi)

All the useful jar packages are included in the project (Gson, log4j...)

## Versioning

[SemVer](http://semver.org/) for versioning.
