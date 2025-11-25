package strings;

import java.util.Scanner;

public class StringDemo {

	public static void main(String[] args) {
		String s = "Life is beautiful";
		s.toUpperCase();
		System.out.println(s);
		System.out.println(s.toUpperCase());
		System.out.println(s.length());// no of characters in a string
		System.out.println(s.indexOf(' '));
		System.out.println(s.indexOf(' ', 7));
		System.out.println(s.indexOf('z'));
		System.out.println(s.lastIndexOf('f'));
		Scanner sc = new Scanner(System.in);
		System.out.println("Name capital of Inida");
		String capital = sc.next();// Delhi
		System.out.println(capital.equals("Delhi"));
		System.out.println(capital.equalsIgnoreCase("Delhi"));
		String url = "http://www.google.com";
		System.out.println(url.startsWith("https"));
		int fd = url.indexOf('.');
		int sd = url.lastIndexOf('.');
		System.out.println(fd+" "+sd);
		System.out.println(url.substring(fd+1,sd));
	}

}
