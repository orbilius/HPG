#/bin/bash
#Usage: newbatch $place $pages $mongodbcollection
#set -e

pushd /Users/polopoly/projects/HPG/war/WEB-INF/classes/ && jar -cf /Users/polopoly/projects/HPG/data/lib/housepriceinfo.jar * && pushd
logdate=$(date +"%Y%m%d%H%M%S")

get/get.sh $logdate $1 $2
#TODO: Fixa detta, snygga till
getfile="/Users/polopoly/projects/HPG/data/get/out/$1$logdate.txt"

#cat $getfile | perl parse/parse.pl $logdate | perl clean/clean.pl $logdate
cat $getfile | perl parse/parse.pl $logdate | perl clean/clean.pl $logdate

#cat get/out/vasterort20100516183755.txt | perl parse/parse.pl $logdate | perl clean/clean.pl $logdate | geocode/geocode.sh $logdate | save/save.sh $logdate 
#get/get.sh vasterort $logdate