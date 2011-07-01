rm -rf parse/out/*
./newbatch.sh stockholm 1 testcol100
grep -ri $1 parse/out/*
