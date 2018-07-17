
# Java version check
echo "**It should be at least JDK 8**"
java -version
javac -version
echo "--------------------------"

# Python version check
echo "**Developed with Python 3.6.5 :: Anaconda Inc.**"
python --version
echo "---------------------------"

# fastText check
echo "**This should show example embeddings**"
#PYTHON_HOME="C:/Users/MasudRahman/Anaconda3/envs/python-module"
#$PYTHON_HOME/python FastTextChecker.py
python FastTextChecker.py


