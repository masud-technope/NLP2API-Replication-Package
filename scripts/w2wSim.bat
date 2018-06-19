SET BASE_DIR="%CD%"
echo %BASE_DIR%
CD %BASE_DIR%
fasttext print-word-vectors model/java-big.bin < input/wordpair.txt > output/wordvec.txt