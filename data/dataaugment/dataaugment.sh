logfile="dataaugment/out/$1.txt"
java  -cp /Users/david/Projects/m/HousePriceInfoGrapher/war/WEB-INF/lib/mongo-1.4.jar:/Users/david/Projects/m/HousePriceInfoGrapher/war/WEB-INF/lib/commons-io-1.4.jar:/Users/david/Projects/m/HousePriceInfoGrapher/war/WEB-INF/lib/json_simple-1.1.jar:/Users/david/Projects/m/HousePriceInfoGrapher/data/lib/housepriceinfo.jar se.orbilius.service.ServiceRunner -servicedataaugment -inmodestd -outmodestd -log$logfile
