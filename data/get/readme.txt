
Surfa till hemnet och ställ in alla söktermer. Presentationsmässiga inställningar som "visa text" och "antal träffar per sida" skrivs inte i kakan utan sätts som requestparameters.

Stäng ner firefox, annars får man "Error: Database locked" senare
Gå sedan till
/Users/david/Library/Application\ Support/Firefox/Profiles/zpwlzsyh.David

Använd den här för att få ut en cookies.txt:
sqlite3 -separator ' ' cookies.sqlite 'select * from moz_cookies' > cookies.txt