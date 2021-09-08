package com.revature;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class App {

	private static final String INPUT_FILE = "/Users/kirkhahn/Desktop/revature-notes/ThroughputHTTPServer/src/main/resources/war_and_peace.txt";

	// this is the variable passed to an executor to control thread-pool size
	private static final int NUMBER_OF_THREADS = 4;
	public static void main(String[] args) throws IOException {

		
		String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
		//the above method returns a byte array of the text file
	
		// we will create some method called startServer() and pass the text to the server
		startServer(text);
	}
	
	public static void startServer(String text) throws IOException {
		
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		// look up Spark Java MicroFramework
		
		// second parameter below is a new WordCountHandler to count the occurrences of the word after /search/
		server.createContext("/search", new WordCountHandler(text));
		
		Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		
		//pass this to the server 
		server.setExecutor(executor);
		
		server.start();
	}

	private static class WordCountHandler implements HttpHandler{
		String text;
		
		
		public WordCountHandler(String text) {
			super();
			this.text = text;
		}

		@Override
		public void handle(HttpExchange httpExchange) throws IOException {

			// capture the query from the client 
			// this returns anything past the "?" in the search bar ex. word=cat
			String query = httpExchange.getRequestURI().getQuery();
			//split the query, and deduce the exact word that the user is looking for
			String[] keyValue = query.split("="); //this SHOULD be word
			String action = keyValue[0];
			String word = keyValue[1];
			
			if(!action.equals("word")) {
				httpExchange.sendResponseHeaders(400, 0);
				return;
			}
			// trigger a countWord() method to find out how many times it appears within the text
			String count = countWord(word);
			// then return some message " x appears y times in the text" as an http response
			// the above response will appear on the browser 
			byte[] response = count.getBytes();
			httpExchange.sendResponseHeaders(200, response.length);
			// return the response in some output stream
			OutputStream outputStream = httpExchange.getResponseBody();
			outputStream.write(response);
			
			outputStream.close();
		}
		
		private String countWord(String word) {
			
			System.out.println("countWord() method triggered");
			
			long count = 0;
			int index = 0;
			while(index >= 0) {
				// if the index is positive we found the word in the book
				index = text.indexOf(word, index);
				if(index >= 0) {
					count++;
					index++;
				}
			}
			return "The word \"" + word + "\" appeared " + count + " times";
		}
	}
}
