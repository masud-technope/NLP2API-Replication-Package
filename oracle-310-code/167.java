GitHub github = GitHub.connect();
GHRepository repo = github.createRepository(
  "new-repository","this is my new repository",
  "http://www.kohsuke.org/",true/*public*/);
repo.addCollaborators(github.getUser("abayer"),github.getUser("rtyler"));
repo.delete();