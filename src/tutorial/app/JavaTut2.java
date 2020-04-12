package tutorial.app;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
//Used to generate ranges
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.regex.*;

public class JavaTut2 {

	public static void main(String[] args) {

		// ---- STREAMS ----
		// Streams represent groups of objects
		// you can perform aggregate operations on

		// Map performs an operation on each value
		// IntStream is used with ints
		// rangeClosed generates a list from start to finish
		// Boxed returns list boxed to an Integer
		// Collect process the list elements into a container
		List<Integer> oneTo10 = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

		List<Integer> squares = oneTo10.stream().map(x -> x * x).collect(Collectors.toList());

		for (Integer x : squares)
			System.out.println(x);

		// Filter eliminates values based on a condition
		List<Integer> evens = oneTo10.stream().filter(x -> (x % 2) == 0).collect(Collectors.toList());
		for (Integer x : evens)
			System.out.println(x);

		// Limit output to 5
		IntStream limitTo5 = IntStream.range(1, 10).limit(5);
		limitTo5.forEach(System.out::println);

		int multAll = IntStream.range(1, 5).reduce(1, (x, y) -> x * y);
		System.out.println(multAll);

		// Map to double
		DoubleStream stream = IntStream.range(1, 5).mapToDouble(i -> i);

		// Generate statistics
		IntSummaryStatistics iStats = IntStream.range(1, 10).summaryStatistics();
		System.out.println("Avg " + iStats.getAverage());
		System.out.println("Sum " + iStats.getSum());
		System.out.println("Min " + iStats.getMin());
		System.out.println("Max " + iStats.getMax());

		// ---- REGULAR EXPRESSIONS ----
		// You can use character codes to search for
		// matching data

		// ape followed by a space \\s
		// Other white space escapes: \b \f \n
		// \r \t \v
		// \\S : Anything not a space
		regexChecker("ape\\s", "ape at apex");

		// Match one of many characters with []
		regexChecker("[crmfp]at", "Cat rat mat fat pat");

		// Match characters in range and ignore case
		regexChecker("(?i)[c-f]at", "Cat rat mat fat pat");

		// Match any character except [^]
		regexChecker("[^c-f]at", "Cat rat mat fat pat");

		// Replace 1 - 4 letter p words with ant
		// \\w : Matches any single letter or number
		// \\w{5} : Would match 5 letters
		// \\W : Anyhting not a letter or number
		System.out.println("pie pizza pork ".replaceAll("p\\w{1,3}\\s", "ant "));

		// Match only acronyms with periods
		// . matches any single character
		// \\. escapes .
		regexChecker(".\\..\\..", "F.B.I. I.R.S. CIA");

		// Match only 4 digit numbers
		// \\D : Anything not a number
		regexChecker("\\d{4}", "1 23 456 7890");

		// Match telephone #
		regexChecker("\\w{3}-\\w{3}-\\w{4}", "412-555-1212");

		// Match 1 or more with +
		// Match emails
		regexChecker("[\\w._%+-]{1,20}@[\\w.-]{2,20}.[A-Za-z]{2,3}", "db@aol.com m@.com @apple.com db@.com");

		// Match 0 or more
		regexChecker("[cat]+s?", "cat cats");

		// Match 0 or more with *
		regexChecker("[doctor]+['s]*", "doctor doctors doctor's");

		// Greedy versus lazy matching
		String rStr1 = "<name>Life On Mars</name><name>Freaks and Geeks</name>";
		regexChecker("<name>.*</name>", rStr1);

		// To get the smallest possible match use
		// *? +? or {n,}?
		regexChecker("<name>.*?</name>", rStr1);

		// ---- LAMBDA EXPRESSIONS ----
		// Lambda expressions are functions that
		// can be passed as if they are objects
		ArrayList<Integer> oneTo5 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

		// Multiply each value by 2
		oneTo5.forEach(x -> System.out.println(x * 2));

		// Print only evens
		oneTo5.forEach(x -> {
			if (x % 2 == 0)
				System.out.println(x);
		});

		// Generate Fibonacci numbers
		List<Integer> fib = new LinkedList<Integer>();

		// iterate creates an infinite stream starting
		// with 0, 1 as we define and then create the next
		// value by adding the previous 2
		// We limit to 10 results
		// map stores the result
		// collect process the list elements into a
		// container
		fib = Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10).map(n -> n[0])
				.collect(Collectors.toList());
		fib.forEach(x -> System.out.println(x));

		// ---- FILE IO ----
		// A File object is a file or directory
		// Create a file object not a file on the drive
		File f1 = new File("f1.log");

		// Create a file on the hardrive
		try {
			if (f1.createNewFile()) {
				System.out.println("File Created");

				// Rename the file
				f1.renameTo(new File("f1BU.log"));

				// Delete the file
				f1.delete();

			} else {
				System.out.println("File not Created");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// File object tied to a directory
		File d1 = new File("\\");

		// Check if we have a directory and print files
		if (d1.isDirectory()) {
			File[] files = d1.listFiles();
			for (File x : files)
				System.out.println(x.getName());
		}

		// A stream is a sequence of characters
		// Character Streams are strings
		// Binary Streams are bytes of data from
		// primitive types
		// Create a file for writing
		File f2 = new File("f2.txt");
		try {
			PrintWriter pw =
					// Formats the data you are writing
					new PrintWriter(
							// Saves data until it is time to write
							new BufferedWriter(
									// Writes characters to the file
									// Add FileWriter(f2, true) to append
									new FileWriter(f2)),
							true);
			// Write text to the file
			pw.println("This is sample text");
			// Close the file
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Reading from a file
		f2 = new File("f2.txt");

		try {
			// Reads data 1 line at a time
			BufferedReader bR = new BufferedReader(
					// Reads 1 character at a time
					new FileReader(f2));

			// Read the line
			String text = bR.readLine();

			// Stop when null is received (End of File)
			while (text != null) {
				System.out.println(text);
				text = bR.readLine();
			}
			bR.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ---- WRITING BINARY DATA ----
		// You don't have to nest the constructors
		File f3 = new File("f3.dat");

		// Connects to file to write raw bytes
		FileOutputStream fOS;

		try {

			// FileOutputStream(f3, true) to append
			fOS = new FileOutputStream(f3);

			// Adds buffering t write in bulk
			BufferedOutputStream bOS = new BufferedOutputStream(fOS);

			// Allows you to write primitives to the stream
			DataOutputStream dOS = new DataOutputStream(bOS);

			String name = "Derek";
			int age = 44;
			double bal = 1234.56;

			// Write string
			dOS.writeUTF(name);
			// Write int
			dOS.writeInt(age);
			// Write double
			dOS.writeDouble(bal);
			// Close file
			dOS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Reading with a DataInputStream
		f3 = new File("f3.dat");

		// File used for the input stream
		FileInputStream fIS;

		try {
			fIS = new FileInputStream(f3);

			// Adds buffering while pulling data
			BufferedInputStream bIS = new BufferedInputStream(fIS);

			// Provides methods for reading data
			DataInputStream dIS = new DataInputStream(bIS);
			System.out.println(dIS.readUTF());
			System.out.println(dIS.readInt());
			System.out.println(dIS.readDouble());
			fIS.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ---- GENERICS ----
		// Generics allow you to use any object type
		// Generic methods and classes can work with
		// any type automatically
		String[] gA1 = { "one", "two" };
		printStuff(gA1);
		Integer[] gA2 = { 1, 2, 3, 4 };
		printStuff(gA2);

		// Using a wildcard to print any type of
		// collection
		ArrayList<Integer> aL1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		printAL(aL1);

		// Using a generic custom class
		MyGeneric<Integer> myGI = new MyGeneric<Integer>();
		myGI.setVal(10);
		System.out.println(myGI.getVal());
		MyGeneric<String> myGS = new MyGeneric<String>();
		myGS.setVal("Dog");
		System.out.println(myGS.getVal());

		// ---- THREADS ----
		// A thread is a block of code that is expected
		// to execute while other blocks of code execute

		// Using threads using a class that implements
		// the Runnable interface
		// Create a Thread
		Thread t1 = new Thread(new MyThread(), "Thread 1");
		Thread t2 = new Thread(new MyThread(), "Thread 2");
		Thread t3 = new Thread(new MyThread(), "Thread 3");

		/*
		 * t1.start(); t2.start(); t3.start();
		 */

		// Have the 3rd thread wait for the 1st
		// to finish with join
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t3.start();

		ThreadTest tT1 = new ThreadTest(new Customer("Sam"));
		tT1.start();
		ThreadTest tT2 = new ThreadTest(new Customer("Sue"));
		tT2.start();
		ThreadTest tT3 = new ThreadTest(new Customer("Sid"));
		tT3.start();

		// ---- DATABASES ----
		// I'm using MySQL 5.7 because it is easier
		// to work with than MySQL 5.8 or 8
		// Download https://dev.mysql.com/downloads/connector/j/
		// Platform Independent
		// Right click Project folder -> Build Path
		// Configure Build Path -> Library Tab ->
		// Add External Jars -> Select mysql-connector-java-8.0.15.jar
		/*
		 * mysql -u root -p UPDATE mysql.user SET Password=PASSWORD('NEWPW') WHERE
		 * User='root'; CREATE DATABASE students; USE students; CREATE TABLE student(
		 * first_name VARCHAR(30) NOT NULL, last_name VARCHAR(30) NOT NULL, street
		 * VARCHAR(50) NOT NULL, student_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY
		 * KEY);
		 * 
		 * INSERT INTO student VALUES('Dale', 'Cooper', '123 Main', NULL); INSERT INTO
		 * student VALUES('Harry', 'Truman', '122 Main', NULL); CREATE USER
		 * 'sdbadmin'@'localhost' IDENTIFIED BY 'turtledove'; GRANT ALL PRIVILEGES ON
		 * students.student TO 'sdbadmin'@'localhost' IDENTIFIED BY 'turtledove'; SHOW
		 * GRANTS FOR 'sdbadmin'@'localhost';
		 */

		Connection con;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/Students";
			String user = "sdbadmin";
			String pw = "turtledove";

			// Used to issue queries to the DB
			con = DriverManager.getConnection(url, user, pw);

			// Sends queries to the DB for results
			Statement s = con.createStatement();

			// Add a new entry
			String query = "INSERT INTO STUDENT " + "(first_name, last_name, street, student_id) " + "VALUES ("
					+ "'Shelly', 'Johnson', '321 Main', NULL)";

			// Execute the Query
			s.executeUpdate(query);

			// Get results
			query = "SELECT first_name, last_name, street " + "FROM student";

			// Cycle through the results
			ResultSet result = s.executeQuery(query);

			// Also getBoolean, getDate, getDouble, getInt,
			// getLong
			while (result.next()) {
				System.out.println(result.getString("first_name"));
				System.out.println(result.getString("last_name"));
				System.out.println(result.getString("street"));
			}

			// Close DB connection
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ---- REGULAR EXPRESSION METHOD ----
	public static void regexChecker(String theRegex, String str2Check) {

		// You define the regex using pattern
		Pattern regexPattern = Pattern.compile(theRegex);

		// Matcher searches a string for a match
		Matcher regexMatcher = regexPattern.matcher(str2Check);

		// Cycle through the positive matches and
		// print them to screen
		// Make sure string isn't empty and trim
		// off any whitespace
		while (regexMatcher.find()) {
			if (regexMatcher.group().length() != 0) {
				System.out.println(regexMatcher.group().trim());
				// You can get the starting and ending indexs
				System.out.println("Start Index: " + regexMatcher.start());
				System.out.println("Start Index: " + regexMatcher.end());
			}
		}
	}

	// ---- GENERIC METHODS ----
	// You define the type using angle brackets
	// and an uppercase letter
	public static <E> void printStuff(E[] arr) {
		for (E x : arr)
			System.out.println(x);
	}

	// Use the wildcard ? when working with collections
	// You can define that you only want to accept
	// objects that subclass a class using
	// ArrayList<? extends YourClass>
	public static void printAL(ArrayList<?> aL) {
		for (Object x : aL)
			System.out.println(x);
	}

}

//---- GENERIC CLASS ----
class MyGeneric<T> {
	T val;

	public void setVal(T val) {
		this.val = val;
	}

	public T getVal() {
		return val;
	}
}

// ---- THREAD CLASSES ----
// Make a class object runnable by implementing 
// Runnable
class MyThread implements Runnable {
	@Override
	public void run() {
		// Print number of active threads
		System.out.println("Active Threads : " + Thread.activeCount());

		System.out.println("Start Thread : " + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End Thread : " + Thread.currentThread().getName());
	}

}

class Customer {
	public String name;

	public Customer(String name) {
		this.name = name;
	}
}

class BankAccount {
	static BankAccount account;
	static int balance = 100;
	static Customer cust;

	// This is how you set up a singleton
	// where there is only one BankAccount
	public static BankAccount getAccount(Customer cust) {
		if (account == null) {
			account = new BankAccount();
		}
		BankAccount.cust = cust;
		return account;
	}

	public static int getBalance() {
		return balance;
	}

	// By marking as synchronised only one
	// thread can execute at a time
	public synchronized void withdraw(int bal) {
		try {
			if (balance >= bal) {
				System.out.println(cust.name + " requested $" + bal);
				Thread.sleep(1000);
				balance -= bal;
				System.out.println(cust.name + " received $" + bal);
			} else {
				System.out.println(cust.name + " tried to exceed balance");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Current Balance : $" + balance);
		System.out.println();
	}
}

class ThreadTest extends Thread implements Runnable {
	Customer cust;

	public ThreadTest(Customer cust) {
		this.cust = cust;
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			try {
				BankAccount account = BankAccount.getAccount(cust);
				account.withdraw(10);
				Thread.sleep(1000);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}