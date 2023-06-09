package chap20_WebCrawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebCrawling {

	public static void main(String[] args) {
		System.out.println("Test");
		Document document;
		try {
			document = Jsoup.connect("https://www.namgarambooks.co.kr/category/출간 도서 소개").get();
			
			Elements elements = (Elements) document.select("#content .title");
			elements.stream().forEach(name -> System.out.println(name.text()));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
