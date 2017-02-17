#!/bin/sh

javacode=../javacode.gitlab/

jettyc_cp=/usr/share/java/servlet-api-3.0.jar:/usr/share/java/jetty9-server.jar:/usr/share/java/jetty9-util.jar
jetty_cp=$jettyc_cp:/usr/share/java/jetty9-http.jar:/usr/share/java/jetty9-io.jar
csv_cp=/usr/share/java/javacsv.jar

cp MANIFEST.MF.in MANIFEST.MF
cp=`echo .:$csv_cp:$jetty_cp | tr ":" " "`
echo "Class-Path: $cp" >> MANIFEST.MF

cp Servlet.java $javacode/transport/src
sed -i -e "s/private/public/" $javacode/transport/src/Transport.java

rm -rf $javacode/transport/src/build
rm -f $javacode/transport/transport.jar $javacode/transport/src/2016-12-30istdaten.csv

(cd $javacode/transport/src && make compile && javac -cp .:$jettyc_cp Servlet.java)

mkdir -p $javacode/transport/src/META-INF
cp MANIFEST.MF $javacode/transport/src/META-INF
(cd $javacode/transport/src && zip -r ../transport.jar .)

cp build.gradle Procfile Buildfile $javacode/transport/src
(cd $javacode/transport/src && gradle build)

(cd $javacode/transport/src && zip -r ../transport-v2.zip .)
