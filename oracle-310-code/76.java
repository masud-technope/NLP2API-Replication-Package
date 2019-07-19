StandardAnalyzer analyzer = new StandardAnalyzer(Version.LATEST);
Directory index = new RAMDirectory();
/*from   w w  w .  j  a v a  2 s . c o m*/
IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);

IndexWriter w = new IndexWriter(index, config);
addDoc(w, "Lucene in Action", "1");
addDoc(w, "Lucene for Dummies", "2");
addDoc(w, "Java", "3");
addDoc(w, "Oracle", "4");
w.close();

private static void addDoc(IndexWriter w, String title, String isbn) throws IOException {
  Document doc = new Document();
  doc.add(new TextField("title", title, Field.Store.YES));
  doc.add(new StringField("isbn", isbn, Field.Store.YES));
  w.addDocument(doc);
}