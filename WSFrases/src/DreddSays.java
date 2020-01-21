import java.util.Random;
import java.util.Vector;

public class DreddSays {
	
		private Vector<String> quotes = new Vector<String>();
		private Random random = new Random();

		public DreddSays () {
		init();
		}

		private void init () {
		quotes.add("Compile error: automatic fail.");
		quotes.add("Unit test error: automatic fail.");
		quotes.add("Stallone is not the law. I'm the law.");
		quotes.add("You have been warned.");
		quotes.add("Judgement time...");
		}

		public String randomQuote () {
		return quotes.get(random.nextInt(quotes.size()));
		}


}
