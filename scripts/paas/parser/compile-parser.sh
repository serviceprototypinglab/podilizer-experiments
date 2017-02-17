#!/bin/sh

javacode=../javacode.gitlab/

jettyc_cp=/usr/share/java/servlet-api-3.0.jar:/usr/share/java/jetty9-server.jar:/usr/share/java/jetty9-util.jar
jetty_cp=$jettyc_cp:/usr/share/java/jetty9-http.jar:/usr/share/java/jetty9-io.jar
antlr_cp=/usr/share/java/antlr4-runtime.jar

cp MANIFEST.MF.in MANIFEST.MF
cp=`echo .:$antlr_cp:$jetty_cp | tr ":" " "`
echo "Class-Path: $cp" >> MANIFEST.MF

cp Servlet.java $javacode/parser/calculator4
cp Makefile $javacode/parser

rm -rf $javacode/parser/build
rm -f $javacode/parser/parser.jar

(cd $javacode/parser && make compile)

mkdir -p $javacode/parser/META-INF
cp MANIFEST.MF $javacode/parser/META-INF
(cd $javacode/parser && zip -r ../parser.jar .)

cp build.gradle Procfile Buildfile $javacode/parser
(cd $javacode/parser && gradle build)

(cd $javacode/parser && zip -r ../parser-v2.zip .)
