HttpClient client = HttpClientBuilder.create().build();
HttpGet request = new HttpGet("http://mkyong.com");
HttpResponse response = client.execute(request);

//get all headers
Header[] headers = response.getAllHeaders();
for (Header header : headers) {
	System.out.println("Key : " + header.getName()
	      + " ,Value : " + header.getValue());
}

//get header by 'key'
String server = response.getFirstHeader("Server").getValue();