package com.revature.eval.java.core;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		//@Author: Chris Copeland
		//convert string phrase to a character array
		char[] tla = phrase.toCharArray();
		String acr = "" + tla[0];
		for(int i=1; i<tla.length; i++) {
			//Add letter to return statement if letter is NOT next to a space or a letter
			if(!(Character.isLetter(tla[i-1]))&& tla[i] != ' ') {
				acr += tla[i];
			}
		}
		//turn all character upper case
		return acr.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		//@Author: Chris Copeland
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			//Compare each side to see if all are equal
			return (sideOne == sideTwo && sideTwo == sideThree);
		}

		public boolean isIsosceles() {
			//Compare all possibilities of at least 2 sides being equal
			return (isEquilateral() || sideOne == sideTwo || sideTwo == sideThree || sideThree == sideOne);
		}

		public boolean isScalene() {
			//if triangle is NOT Isosceles its Scalene
			return (!(isIsosceles()));
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		//@Author: Chris Copeland
		//convert incoming string to all Lower case
		String string2 = string.toLowerCase();
		
		//turn string to character array
		char[] scrabbleArr = string2.toCharArray();
		
		//initialize sum variable
		int sum = 0; 
		
		//enhanced for loop to check switch cases
		for(char c : scrabbleArr) {
			switch(c) {
			case 'd':
				sum += 2;
				break;
			case 'g':
				sum += 2;
				break;
			case 'b':
				sum += 3;
				break;
			case 'c':
				sum += 3;
				break;
			case 'm':
				sum += 3;
				break;
			case 'p':
				sum += 3;
				break;
			case 'f':
				sum += 4;
				break;
			case 'h':
				sum += 4;
				break;
			case 'v':
				sum += 4;
				break;
			case 'w':
				sum += 4;
				break;
			case 'y':
				sum += 4;
				break;
			case 'k':
				sum += 5;
				break;
			case 'j':
				sum += 8;
				break;
			case 'x':
				sum += 8;
				break;
			case 'q':
				sum += 10;
				break;
			case 'z':
				sum += 10;
				break;
			default: 
				sum += 1;
			}
			
		}
		
		//returns sum after going through character array
		return sum;
				
	}

	

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		//@Author: Chris Copeland
		//place incoming string into as local phone variable
		String phone = string;
		
		//replace everything but digits
		phone = phone.replaceAll("[^0-9+]", "");
		
		//throw exception if phone string does not fit 10 digit format
		if(phone.length() > 10 || phone.length() < 10) {
			throw new IllegalArgumentException();
		}
		
		return phone;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		//@Author: Chris Copeland
		//Create expected HashMap
		HashMap<String, Integer> expectedWordCount = new HashMap<String, Integer>();
		
		//remove the commas and the "\n" in the string
		String stringCopy = string.replace("\n", "");
		stringCopy = stringCopy.replace(",", " ");
        
		//convert given string to string array 
        String[] strArray = stringCopy.split(" ");
        
        //for loop to count number of individual words
        for(String s : strArray) {
        	if(expectedWordCount.containsKey(s)) {
        		//if s is present increment by 1
        		expectedWordCount.put(s, expectedWordCount.get(s)+1);
        	} else {
        		//if s is not present, put s in HashMap, and set value to 1 
                 expectedWordCount.put(s, 1);
        	}
        }
		
		return expectedWordCount;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> implements Comparable<T> {
		private List<T> sortedList;
		
		

		public int indexOf(T t)  {
			//@Author: Chris Copeland
			System.out.println(sortedList);
			
			int first = 0;
			int last = sortedList.size() - 1;
			int location = 0;
			System.out.println("t = " + t);
			System.out.println("first = " + sortedList.get(first));
			System.out.println("Last = " + sortedList.get(last));
			
			
			
			return 0;
		}
		
		public int compareTo(Object arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		//@Author: Chris Copeland
		//Implemented both Pattern and Matcher still very unsure on how it performs the action
		//but i got it to work
		//Pattern class was implemented to catch vowels and consonants
		 Pattern vowel = Pattern.compile("^([aeiou]|y[^aeiou]|xr)");
	        Pattern consone = Pattern.compile("^([^aeiou]?qu|[^aeiouy]+|y(?=[aeiou]))");

	        //initialized input as empty
	        String translatedWord = "";
	        
	     
	        //enhanced for loop is used rearrange the input string
	        for (String word: string.split(" ")) {
	            if (vowel.matcher(word).find())
	            	//set Translated word equal to input
	            	translatedWord += word;
	            else {
	            	//matches against the pattern
	                Matcher z = consone.matcher(word);
	                if (z.find())
	                	//takes the end of the word starting from the first vowel and adds it to the front of the word
	                	translatedWord += word.substring(z.end()) + z.group();
	            }
	            //ads "ay" sound to the end of the word
	            translatedWord += "ay ";
	        }
	       
		//returns word back in Pig Latin
		return translatedWord.substring(0, translatedWord.length() - 1);
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		//@Author: Chris Copeland
		int a = input, b=0 ,d,e; 
		double sum = 0;
		
		//count number of digits in the input
		int length = String.valueOf(a).length();
		boolean c = true;
		
		//while loop to do armstrong sequence
		while(a>0) {
			b = a % 10;	
			a = a / 10;
			sum = sum + ((Math.pow(b, length)));
			
		}		
		
		//check to see if input matches the sum
		if(input == sum) {
			c = true;
			
		} else {
			c = false;
			
		}
		
		return c;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		//@Author: Chris Copeland
		long copyNum = l;
		
		//array that contains all factors
		List<Long>factors = new ArrayList();
		
		
		for(int currentNum = 2; currentNum <= copyNum; currentNum++) {
			//check if the current number completely divides the input
			if(copyNum % currentNum == 0) {
				
				//add to the list
				factors.add((long) currentNum);
				
				// calculate quotient of division
				copyNum /= currentNum;
				
				// stop the number from incrementing in next iteration
				currentNum--;
			}
		}
		
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			//@Author: Chris Copeland
			
			//convert string to char array
			char[] plain = string.toCharArray();
			int cipher;
			
			//for loop for encryption
			for(int i = 0; i < string.length(); i++) {
				cipher = (int) plain[i];
				
				if((cipher >= 97) && (cipher <=122)) {
					cipher += key;
					if (cipher > 122) {
						cipher -= 26;
					}
				}else if((cipher >= 65) && (cipher <=90)){
					cipher += key;
					if (cipher > 90) {
						cipher -= 26;
					}
					
				}
				plain[i] = (char) cipher;
			}			
			
			return String.valueOf(plain);
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		//@Author: Chris Copeland
		
		int num = 1;
		int count = 0;
		int j;
		
		if(i == 0) {
			throw new IllegalArgumentException();
		}
		
		while(count < i) {
			num +=1;
			//loop from 2 to number
			for(j = 2; j <= num; j++) {
				if(num % j == 0) {
					break;
				}
			}
			
			//if its a prime number
			if(j == num) {
				count += 1;
			}
		}
		
		return num;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		//@Author: Chris Copeland
		private static final int GROUP_SIZE = 5;
	    private static final String PLAIN = "abcdefghijklmnopqrstuvwxyz";
	    private static final String CIPHER = "zyxwvutsrqponmlkjihgfedcba";
	    
	    /**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
	    //@Author: Chris Copeland
		//encryption method
	    public static String encode(String string) {
	        string = invalidChar(string.toLowerCase());
	        StringBuilder encrypt = new StringBuilder();

	        for (char c : string.toCharArray()) {
	            encrypt.append(applyCipher(c));
	        }
	        return splitWords(encrypt.toString());
	    }

	    /**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
	    //@Author: Chris Copeland
		//decryption method
	    public static String decode(String string) {
	        string = invalidChar(string);
	        StringBuilder decrypt = new StringBuilder();

	        for (char c : string.toCharArray()) {
	            decrypt.append(applyCipher(c));
	        }
	        return decrypt.toString();
	    }

	    
	    //apply cipher for encryption and decryption
	    private static char applyCipher(char input) {
	        int idx = PLAIN.indexOf(input);

	        return idx >= 0 ? CIPHER.toCharArray()[idx] : input;
	    }
	    
	    //method to split the words up
	  	//my main problem
	    private static String invalidChar(String input) {
	        return input.codePoints()
	                    .filter(Character::isLetterOrDigit)
	                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	                    .toString();
	    }

	    //separate the words
	    private static String splitWords(String value) {

	        return String.join(" ", splitNumber(value, GROUP_SIZE));
	    }

	    //???
	    private static List<String> splitNumber(String value, int size) {
	        if (value == null || size <= 0) {
	            return null;
	        }
	        List<String> words = new ArrayList<>();

	        for (int i = 0; i < value.length(); i += size) {
	            words.add(i + size <= value.length() ? value.substring(i, i + size) : value.substring(i));
	        }
	        return words;
	    }
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		//@Author: Chris Copeland
		boolean c;
		
		//checks if string is empty or null
		if(string == null) {
			return false;
		}
		
		string = string.replaceAll("-", "");		
		
		//must be 10 digits
		if((string.length() != 10)) {
			return false;
		}
		
		
		 try {
	        int x = 0;
	        //check the digits 0-9
	        for ( int i = 0; i < 9; i++ )  {
	           int digit = Integer.parseInt(string.substring( i, i + 1 ) );
	           x += ((10 - i) * digit);
	            }
	        	//check the last digit
	            String sum = Integer.toString( (11 - (x % 11)) % 11 );
	            if ( "10".equals(sum ) )
	            {
	                sum = "X";
	            }

	            return sum.equals(string.substring( 9 ) );
	        }
	        catch ( NumberFormatException nfe )
	        {
	            //to catch invalid ISBNs that have non-numeric characters in them
	            return false;
	        }

	 
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		//@Author: Chris Copeland
		//create a hastable with chars as keys and ints as values
		Map<Character,Integer> abc = new HashMap<Character,Integer>();
		
		//fill the map
		for(int j = 0; j < 26; j++) {
			abc.put(((char)(j +97)), 0);
		}
		
		//go through the string
		for(int index = 0; index < string.length(); index++) {
			char currentChar = string.charAt(index);
			
			//check if current character is in map
			if(abc.get(currentChar) != null) {
				abc.put(currentChar, abc.get(currentChar) + 1);
			}
		}
		
		//go through the map
		for(char key : abc.keySet()) {
			//if a letter is missing return false
			if(abc.get(key) < 1) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		//@Author: Chris Copeland
		
		try {
			//parses date time and could throw exception if given is a local date
			LocalDateTime date = LocalDateTime.parse(given.toString());
			return date.plusSeconds(1000000000);
			
		} catch(Exception e) {
			//transform given to local date object
			LocalDate today = LocalDate.parse(given.toString());
			
			//converts date to time
			LocalDateTime now = today.atTime(0,0,0);
			
			return now.plusSeconds(1000000000);
		}
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		//@Author: Chris Copeland
		//create set to store multiples
		Set<Integer> multiples = new HashSet<Integer>();
		
		//intialize sum
		int sum = 0;
		
		
		for(int j=0; j < set.length; j++) {			
			for(int k=1; k <i; k++) {
				if(k * set[j] < i) {
					multiples.add(k * set[j]);
					
				}
			}
			
			
		}
		
		//find sum of multiples
		for(int x : multiples) {
			sum += x;
		}
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		//@Author: Chris Copeland
		
		//remove ? and split input string
		String string2 = string.replace("?", " ");
		String[] abc = string2.split(" ");
		
		//grab first integer
		int x = Integer.parseInt(abc[2]);
		
		//grab second integer
		int y = Integer.parseInt(abc[abc.length-1]);
		
		//intialize sum
		int sum = 0;
		
		if(string.contains("plus")) {
			sum = x + y;
		}
		if(string.contains("minus")) {
			sum = x - y;
		}
		if(string.contains("multiplied")) {
			sum = x * y;
		}
		if(string.contains("divided")) {
			sum = x / y;
		}
		
		
		return sum;
	}


}
