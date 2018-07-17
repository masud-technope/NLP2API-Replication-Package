
import os
from gensim.models import FastText
from gensim.models import Word2Vec

# loading FastText model
current_directory = os.getcwd()
model_file = current_directory + "/fastText/fastText-models/so-java-big"
model = FastText.load(model_file)
word = "java"
vector = model.wv[word.strip()]
print(vector)
print("CONGRATS! FastText model is working properly!")
