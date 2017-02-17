#!/bin/sh

javacode=../javacode.gitlab/

jettyc_cp=/usr/share/java/servlet-api-3.0.jar:/usr/share/java/jetty9-server.jar:/usr/share/java/jetty9-util.jar
jetty_cp=$jettyc_cp:/usr/share/java/jetty9-http.jar:/usr/share/java/jetty9-io.jar

cp MANIFEST.MF.in MANIFEST.MF
cp=`echo .:$jetty_cp | tr ":" " "`
echo "Class-Path: $cp" >> MANIFEST.MF

cp Servlet.java $javacode/containers/src/com/company

# in src/com/company:
#javac -cp ../..:/usr/share/java/servlet-api-3.0.jar:/usr/share/java/jetty9-server.jar:/usr/share/java/jetty9-util.jar Servlet.java
# FIXME: does not work somehow

rm -rf $javacode/containers/src/build
rm -f $javacode/containers/containers.jar

(cd $javacode/containers/src && javac -cp .:$jettyc_cp com/company/*.java)

mkdir -p $javacode/containers/src/META-INF
cp MANIFEST.MF $javacode/containers/src/META-INF
(cd $javacode/containers/src && zip -r ../containers.jar .)

cp build.gradle Procfile Buildfile $javacode/containers/src
(cd $javacode/containers/src && gradle build)

(cd $javacode/containers/src && zip -r ../containers-v2.zip .)

#(cd $javacode/containers/src && java -cp .:$jetty_cp com.company.Servlet)
# => http://localhost:8080/
