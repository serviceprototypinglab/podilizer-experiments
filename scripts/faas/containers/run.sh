
libs="../../scripts/faas/libs";

awsl=`find -not -path "*/LambdaProjects/*" -type f -name *.java`

javafiles=;

for file in $awsl; do
	javafiles="$javafiles $file"
done

javac -cp .:$libs/* $javafiles 
cd src
time java -cp .:$libs/* com.company.Main
