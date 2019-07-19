String querystr = "lucene";

Query q = new QueryParser(Version.LATEST, "title", analyzer).parse(querystr);