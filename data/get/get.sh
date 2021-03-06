#Usage: get.sh logdate place pages

logfile="/Users/polopoly/projects/HPG/data/get/out/$2$1.txt"
cookiefile="/Users/polopoly/projects/HPG/data/get/$2cookies.txt"
echo $logfile
echo $cookiefile

touch $logfile 
myvar=0
while [ $myvar -ne $3 ]
do
    next=$(( $myvar + 1 ))
	echo $next	
	
	wget --load-cookies $cookiefile  --user-agent='Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; en-US; rv:1.9.2.3) Gecko/20100401 Firefox/3.6.3' -O TMPFILE 'http://www.hemnet.se/resultat?page='$next
	cat TMPFILE >> $logfile	
    myvar=$(( $myvar + 1 ))
done

rm TMPFILE
