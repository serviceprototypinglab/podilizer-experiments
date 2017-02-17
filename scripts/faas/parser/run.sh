
libs="../../scripts/faas/libs";

awsl=`find -not -path "*/LambdaProjects/*" -type f -name *.java`

javafiles=;

for file in $awsl; do
	javafiles="$javafiles $file"
done
javac -cp .:$libs/* $javafiles 
# classpath nonsense workaround
cp calculator4/gen/*.class calculator4

cd src
time java -cp .:$libs/* calculator4.Calculator4 test.script
