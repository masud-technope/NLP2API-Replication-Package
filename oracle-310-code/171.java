

public void parseJS (String filePath) throws Exception
{
	CompilerEnvirons env = new CompilerEnvirons();

	env.setRecoverFromErrors(true);

	FileReader strReader = new FileReader(filePath);

	IRFactory factory = new IRFactory(env, new JSErrorReporter());
	AstRoot rootNode = factory.parse(strReader, null, 0);

	JSNodeVisitor nodeVisitor = new JSNodeVisitor();

	rootNode.visit(nodeVisitor);

	nodeVisitor.getRoot().visit(new JSSymbolVisitor());
}

