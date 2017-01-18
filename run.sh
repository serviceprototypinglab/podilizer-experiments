#!/bin/bash
#
# Reproducible experiments with Podilizer

#podilizer_repo=https://github.com/serviceprototypinglab/podilizer.git
podilizer_repo=git@srv-lab-t-401.zhaw.ch:dord/service_tooling_initiative.git
javacode_repo=git@srv-lab-t-401.zhaw.ch:tooling/javacode.git

if [ ! -d podilizer ]; then

# Ensure that dependencies are met [Debian stretch/Ubuntu yakkety]
sudo apt-get install openjdk-8-jdk maven

# Fetch Podilizer and input data
git clone -b testbranch $podilizer_repo
git clone $javacode_repo

# Build Podilizer
(cd service_tooling_initiative; mvn install)

else

# Update

(cd service_tooling_initiative; git pull; mvn install)
(cd javacode; git pull)

fi

projects=`ls javacode`
origdir=$PWD
mkdir -p $origdir/results
cd service_tooling_initiative

for project in $projects; do
	if [ -d $origdir/javacode/$project ]; then
		echo "Converting $project..."
		log=$origdir/results/translated-$project.log
		time java -jar target/Podilizer-0.1.jar -t $origdir/javacode/$project $origdir/results/translated-$project -b $origdir/results/translated-$project additional/conf/pom.xml > $log
	fi
done
