
===========================================
Note: This script downloads large files from Google drive.
We used windows version of gdrive and 7z. 
However, we also provide equivalent bash commands for Linux machines.
Dependencies:
- https://github.com/prasmussen/gdrive
- https://www.7-zip.org/
===========================================

# clone repository from GitHub
# git clone https://github.com/masud-technope/NLP2API-Replication-Package.git NLP2API

# GitHub skips large files which are stored on Google Drive
# Now downloading the rest files
# cd NLP2API
cd dataset
#answer-ext
#gdrive-linux-x64 download 1x2Btg4z9-0Jk6V20nU8KXT-_ICXYPptq
gdrive-windows-x64 download 1x2Btg4z9-0Jk6V20nU8KXT-_ICXYPptq
#question-ext
gdrive-windows-x64 download 1K7ofG_FVFe1vLKadU52A1p_ghmiGmXrT

# fastText-windows version
cd ..
gdrive-windows-x64 download 1OjBNiaRadLq0-qenp9Ltn_E9c_Hhnv0q

#fastText cross-platform / python based models
gdrive-windows-x64 download 18GSvXYNmSIzP1VnWktWRrUWLe3O-4AXN

#unzip the compressed files
cd dataset
mkdir answer-ext
7z e answer-ext.7z -o\answer-ext
mkdir question-ext
7z e question-ext.7z -o\question-ext

cd ..
mkdir fastText-windows
7z e fastText-windows.7z -o\fastText-windows
mkdir fastText
7z e fastText.7z -o\fastText

echo "Downloaded and unzipped the large files successfully!"


# Please contact Masud Rahman (masud.rahman@usask) for further assistance.





