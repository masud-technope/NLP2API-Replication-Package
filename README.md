# NLP2API: Query Reformulation for Code Search using Crowdsourced Knowledge and Extra-Large Data Analytics

Accepted Paper at ICMSE 2018
============================
**Effective Reformulation of Query for Code Search using  Crowdsourced Knowledge and Extra-Large Data Analytics**

Authors: **Mohammad Masudur Rahman** and **Chanchal K. Roy**


Download Links:
=================
- You can download from Google drive: https://drive.google.com/drive/folders/1y-W0BllWlZwcRq2D0iEtP5qZ1nvJ_a2-


- You can also clone the replication package from our GitHub Repository using the following command:

  **git clone https://github.com/masud-technope/NLP2API-Replication-Package.git YOUR-HOME-DIR**
  
  *Warning!!! GitHub is not delivering the large files properly*


Getting Started
======================
- Execute **jdk-fasttext-checker.bat** to check whether your system meets the tool's requirements.
- NLP2API might work sub-optimally or might not work at all if the system requirements are not properly met.


Materials Included (20):
========================
- **nlp2api-runner.jar** : The working prototype of NLP2API
- **data** : It contains stop words and Java programming keywords
- **candidate** : Auxiliary folder storing candidate API classes 

- **dataset/qa-corpus-ext-index**: Lucene index of programming Q & A threads of Stack Overflow
- **dataset/answer-ext.7z** : It contains the HTML source of Stack Overflow answers
- **dataset/question-ext.7z** : It contains the HTML source of Stack Overflow questions
 (You need to unzip these files)
- **dataset/answer-norm-code-ext-index** : Lucene index of answer code segments of Stack Overflow
- **dataset/question-norm-code-ext-index** : Lucene index of question code segments of Stack Overflow

- **scripts** : It contains batch script to access fastText model
- **fastText.7z** : It contains our trained skip-gram model and fastText tool.
(You need to unzip this file and make sure the **fasttext** command is working on your platform. 
  More details on this tool's dependencis can be found here: https://fasttext.cc/docs/en/support.html
  Our model was developed using Windows version of the fastText)
  
- **NL-Query+GroundTruth** : It contains NL query and ground truth API classes (i.e., the order is important)
- **NLP2API-Results-Borda** :  It contains NL query and suggested API classes (Borda)
- **NLP2API-Results-Q-A-Proximity** :  It contains NL query and suggestd API classes (Q-A proximity)
- **NLP2API-Results** : It contains NL query and suggestd API classes of NLP2API (i.e., both proxies combined)

- **oracle-310** : NL queries and ground truth API classes

- **code-ext-index** : Lucene index of code segment corpus (310 ground truth code segments + 3,860 other code segments)

- **lib** : It contains all the dependency files (Optional). The tool is an executable JAR file, and hence already packages all the dependencies except those required by fastText.
- **jdk-fasttext-checker.bat** : It checks for Java 8 and fastText installations and their operation integrity.

- **README**
- **LICENSE**

System Requirements:
===================
- JDK: NLP2API was built with **JDK 1.8.0_74**. Please use JDK 1.8.* for the successful execution/run. **JDK 10 fails** to load several legacy dependencies of NLP2API.
- Operating System: Windows 10
- The path to the directory containing NLP2API materials should not contain any *space* characters.
- Every compressed file should be de-compressed in the same directory. For example, dataset/answer-ext.7z should be dataset/answer-ext.
- Make sure that **fastText** is working on your platform. To check, go to **/fastText** directory and execute **fasttext** on the Windows command line. 
If it shows the available options, then fastText is working. Otherwise, you have to take care of its dependencies (https://fasttext.cc/docs/en/support.html).


Available Operations:
=====================
- Reformulate a query, i.e., **reformulate**
- Evaluate API suggestion performance, i.e., **evaluate-as** 
- Evaluate the effectiveness of the queries, i.e., **evaluate-qe**
- Evaluate the retrieval performance of queries, i.e., **evaluate-cs**
- Evaluation of queries used by the web/code search engines, i.e., **evaluate-se**


Required parameters for the operations:
======================================
-  **-K** : expects the number of suggested API classes (e.g., default: 10)
-  **-query** : expects a natural language query
-  **-queryFile** : expects the file containing the natural language query (e.g., deafult: ./NL-Query+GroundTruth.txt)
-  **-outputFile** : expects the output file name (e.g., default: ./NLP2API-queries.txt)
-  **-resultFile** : same as outputFile
-  **-se** : expects the name of a search engine (e.g., google, stackoverflow, github)


Q.1: How to install the NLP2API tool?
======================================
- Download all items from the Google drive or GitHub, and keep in /home folder.
- Unzip all zip files, and make sure that they are in the home directory. For example, dataset/question-ext.7z should be /home/dataset/question-ext
- check Java and fastText installations using **jdk-fasttext-checker.bat**.
- Run the tool from within the home directory.


Q.2: How to reformulate a given NL query or a file containing all the queries?
==================================================
*Reformulate a single query *

**java -jar nlp2api-runner.jar -K 10 -task reformulate -query How do I send an HTML email?**

*Reformulate all queries stored in a file*

**java -jar nlp2api-runner.jar -K 10 -task reformulate -inputFile ./NL-Query+GroundTruth.txt -outputFile apiresults.txt**

Please note that each NL query is followed by ground truth API classes in the next line. 
If you want to create a custom query file, please keep the queries at the odd lines. 
The reformulation of 310 queries takes a few minutes.
The output file will be created inside the "home/result/" folder.

Query File format:
--------------------------
NL Query: How do I send an HTML email?

Ground Truth: Properties Session Message MimeMessage InternetAddress


Q.3: How to determine API suggestion performance?
=================================================================================

**java -jar nlp2api-runner.jar -K 10 -task evaluate-as -resultFile ./NLP2API-Results.txt**

This command reports Top-10 accuracy, MRR@10, MAP@10, and MR@10 for API suggestion

Q.4: How to determine query improvement and worsening ratios of the reformulated queries?
=================================================================================

**java -jar nlp2api-runner.jar -K 5 -task evaluate-qe -resultFile ./NLP2API-Results.txt**

This commands reports query improvement, worsening, preserved ratios and mean rank differences with the initial queries.


Q.5: How to get retrieval performance of the reformulated queries?
=================================================================

**java -jar nlp2api-runner.jar -K 10 -task evaluate-cs -resultFile ./NLP2API-Results.txt**

This commands reports Top-10 accuracy and MRR@10 of code segment retrieval by NLP2API

Q.6: How much improvements can be made over traditional web/code search engines' performance?
=============================================================================================

**java -jar nlp2api-runner.jar -K 10 -task evaluate-se -se google**

This command reports Google's Top-10 performance with NL queries, and subsequent improvements using our reformulated queries.
Possible se values are: google, stackoverflow and github


-----------------------------------------------------------------------------------------------------------
Please cite our work as 

`@INPROCEEDINGS{icsme2018masud,
author={Rahman, M. M. and Roy, C. K.}, 
booktitle={Proc. ICSME}, 
title={Effective Reformulation of Query for Code Search using Crowdsourced Knowledge and Extra-Large Data Analytics}, 
year={2018}, 
pages={12} 
}`

-----------------------------------------------------------------------------------------------------------
Contact: Masud Rahman (masud.rahman@usask.ca)



























