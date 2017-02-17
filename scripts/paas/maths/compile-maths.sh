#!/bin/sh

javacode=../javacode.gitlab/

jettyc_cp=/usr/share/java/servlet-api-3.0.jar:/usr/share/java/jetty9-server.jar:/usr/share/java/jetty9-util.jar
jetty_cp=$jettyc_cp:/usr/share/java/jetty9-http.jar:/usr/share/java/jetty9-io.jar

cp MANIFEST.MF.in MANIFEST.MF
#cp=`echo .:dist/maths.jar:$jetty_cp | tr ":" " "`
cp=`echo .:$jetty_cp | tr ":" " "`
echo "Class-Path: $cp" >> MANIFEST.MF

cp Servlet.java build.xml $javacode/maths

rm -rf $javacode/maths/build
rm -f $javacode/maths.jar

(cd $javacode/maths && ant run)

mkdir -p $javacode/maths/META-INF
cp MANIFEST.MF $javacode/maths/META-INF
rm -rf $javacode/maths/wizardmath
cp -r $javacode/maths/build/wizardmath $javacode/maths
(cd $javacode/maths && zip -r ../maths.jar .)

cp build.gradle Procfile Buildfile $javacode/maths
(cd $javacode/maths && gradle build)

(cd $javacode/maths && zip -r ../maths-v2.zip .)
