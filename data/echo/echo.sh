pushd /Users/david/Projects/m/HousePriceInfoGrapher/war/WEB-INF/classes/
jar -cf /Users/david/Projects/m/HousePriceInfoGrapher/data/lib/housepriceinfo.jar *
popd


logfile="echo/out/echo"$(date +"%Y%m%d%H%M%S")".txt"

java  -cp /Users/david/Projects/m/HousePriceInfoGrapher/war/WEB-INF/lib/mongo-1.4.jar:/Users/david/Projects/m/HousePriceInfoGrapher/war/WEB-INF/lib/commons-io-1.4.jar:/Users/david/Projects/m/HousePriceInfoGrapher/war/WEB-INF/lib/json_simple-1.1.jar:/Users/david/Projects/m/HousePriceInfoGrapher/data/lib/housepriceinfo.jar se.orbilius.service.ServiceRunner -serviceempty -inmodestd -outmodestd -log"$logfile"
