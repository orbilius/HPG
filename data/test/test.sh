#/bin/bash

pushd ../../war/WEB-INF/classes/
jar -cf /Users/david/Projects/m/HousePriceInfoGrapher/data/test/lib/housepriceinfo.jar *
popd

java  -cp ../../war/WEB-INF/lib/mongo-1.4.jar:../../war/WEB-INF/lib/commons-io-1.4.jar:../../war/WEB-INF/lib/json_simple-1.1.jar:lib/housepriceinfo.jar se.orbilius.util.Test $1
