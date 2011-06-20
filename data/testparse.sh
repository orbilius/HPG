#/bin/bash
#Usage: newbatch $place $pages $mongodbcollection
#set -e

pushd /Users/david/Projects/m/HousePriceInfoGrapher/war/WEB-INF/classes/ && jar -cf /Users/david/Projects/m/HousePriceInfoGrapher/data/lib/housepriceinfo.jar * && pushd
logdate=$(date +"%Y%m%d%H%M%S")

get/get.sh $logdate $1 $2
#TODO: Fixa detta, snygga till
getfile="/Users/david/Projects/m/HousePriceInfoGrapher/data/get/out/$1$logdate.txt"

#cat $getfile | perl parse/parse.pl $logdate | perl clean/clean.pl $logdate
cat $getfile | perl parse/parse.pl $logdate | perl clean/clean.pl $logdate

#cat get/out/vasterort20100516183755.txt | perl parse/parse.pl $logdate | perl clean/clean.pl $logdate | geocode/geocode.sh $logdate | save/save.sh $logdate 
#get/get.sh vasterort $logdate