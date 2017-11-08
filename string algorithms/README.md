#Introduction
--------------
When we enter URL in any browser, we observer that after typing the prefix of the URL, a list of all possible URLs is displayed. It means, browsers are doing some internal processing and giving us the list of matching URLs. This technique is called auto-completion.

Similarly, when we use command line interface, after typing the prefix of the directory if we press tab button, then we get list of all matched directory names available. This is another example of auto-completion.

Note: In order to support these operations, we need a data structure which stores the string data efficiently. we will look at some data structures in this module.

First we look at some string matching algorithms. i.e. given a string, how do we search a substring(or pattern). This is called string matching problem. After discussing various string matching algorithms, we will see different data structures for storing strings.

String Matching Algorithms
--------------------------

Let's say we want to search for a pattern P of length m, in the text T of length n. It means T has characters from 0 to n-1 and P has characters from 0 to m-1.

Here are few algorithms. We will start from Brute force and gradually move to better algorithms.

1)Brute Force Method(naive method)
2)Robin-Karp
3)Finite Automata
4)KMP Algorithm
5)Boyce-Moore Algorithm
6)Suffix Trees

Brute Force Method
------------------
In this method, for each possible position in the Text T, we check whether the pattern P matches or not. Since length of T is n, we have n - m + 1 possible choices for comparison, because we don't need to check last m-1 locations of T as the pattern length is m. Here is the code:

	private static List<SearchMatch> match(char[] text, char[] pattern) {
		List<SearchMatch> matchList = new ArrayList<>();
		int n = text.length;
		int m = pattern.length;
		for(int i=0; i < n - m + 1 ; i++ ) {
			int matchCount = 0;
			int j=0;
			while( j < m && pattern[j] == text[i+j]) {
				j = j+1;
			}
			
			if(j == pattern.length) {
				matchList.add(new SearchMatch(i,++matchCount));
			}
		}
		
		return matchList;
	}
	
	public class SearchMatch {

		private int startIndex;
		private int matchCount;
		
		public SearchMatch(int startIndex, int matchCount) {
			this.startIndex = startIndex;
			this.matchCount = matchCount;
		}
	
		@Override
		public String toString() {
			return "SearchMatch [startIndex=" + startIndex + ", matchCount=" + matchCount + "]";
		}

	}
	
Time complexity: O((n-m+1)*m) = O(n*m)
Space complexity: O(1)

Rabin-Karp String Search Algorithm
-----------------------------------
Rabin karp string search algorithm is based on hashing. Here is how it works.

Let's take pattern P as "abc", and text T as "adbabc". 

1)Calculate hash of the pattern P. i.e. hash(abc) and store it in a variable. Let's say hash(abc) is a long value x.
2)Now starting from the first character in text T, take m(where m is the length of pattern i.e. 3) characters at a time('adb','dba','bab','abc') and calculate the hash. 
3)Let's say in first iteration the hash(adb) is y. 
4)check if x and y are equal. 
5)if x and y are equal, then compare the actual strings
6)if x and y are not equal, then skip one character and take next 3 characters. i.e. 'dba'
7)repeat this process, until the reaching the last m-1 characters in the text T

Generating hash
---------------
We use rolling hash function. Here are the steps.

1)Rolling hash function assigns some integer values to the alphabets. For ex, a = 1, b = 2 ... z = 26. (In real scenarios using ascii codes are common)  
2)Take some primary number say 3. In real scenarios take something like 101.
3)If the pattern is 'abc', then hash equation could be like 1 + 2 * (3) + 3 *(3^2) = 34.Let's say x = 34

So, hash value for 'adb' say y = 1 + 4 * (3) + 2 * (3^2) = 31 (not matched)
hash value for 'dba' say y = 4 + 2 * (3) + 1 * (3^2) = 19 (not matched)
hash value for 'bab' say y = 2 + 1 * (3) + 2 * (3^2) = 23 (not matched)
hash value for 'abc' say y=  1 + 2 * (3) + 3 *(3^2) = 34. (matched)

As we can see from above, hash value of last iteration y is matched with x, now we can compare actual strings to find the exact match. 

Note: As we can see from the above, finding out hash value in each iteration is mandatory for comparing hash value, there is a quick way to get the hash value from the second iteration i.e. from 'dba'. Let's say hash value of 'adb' (31) as oldhash, character removed (a) as oldchar and character added (a) as newchar. 
Here are the steps to findout the newhash.

1)newhash = oldhash - val(oldchar); i.e. newhash = 31 - 1 = 30
2)newhash = newhash / prime ; i.e. newhash = 30/3 = 10;
3)newhash = newhash + val(newchar) *(prime^m-1) ; newhash = 10 + 1*(3^2) = 19

Here is the sample code of both the hash functions.

	private static long createHash(char[] str, int end) {
		long hash = 0;
		for(int i=0; i <=end ; i++) {
			hash += str[i] * Math.pow(PRIME, i);
		}
		return hash;
	}
	
	private static long recalculateHash(char[] str, int oldIndex, int newIndex, long oldHash, int patternLength) {
		long newHash = oldHash - str[oldIndex];
		newHash = newHash/PRIME;
		newHash += str[newIndex] * Math.pow(PRIME, patternLength-1);
		return newHash;
	}

Note: str[i] automatically typecasts the char into an int(ascii value) when added to long.

Here is the main string search(or match function)

	private static List<SearchMatch> match(char[] text, char[] pattern) {
		
		List<SearchMatch> matchList = new ArrayList<>();
		int matchCount=0;
		int n = text.length;
		int m = pattern.length;
		long patternHash = createHash(pattern,m-1);
		long textHash = createHash(text,m-1);
		for(int i=1; i<= n-m+1;i++ ) {
			if(patternHash == textHash && checkEqual(text,i-1,i+m-2,pattern,0,m-1)) {
				matchList.add(new SearchMatch(i-1, ++matchCount));
			}
			if(i < n-m+1) {
				textHash = recalculateHash(text,i-1,i+m-1,textHash,m);
			}
		}
		return matchList;
	}
	
	private static boolean checkEqual(char[] str1, int start1, int end1, char[] str2, int start2, int end2) {
		if(end1-start1 != end2-start2) {
			return false;
		}
		while(start1 <= end1 && start2 <= end2) {
			if(str1[start1] != str2[start2]) {
				return false;
			}
			start1++;
			start2++;
		}
		return true;
	}

Time complexity: In the worst case, each substring hash matches with the pattern and complexity would be O(mn).
	
Note: This algorithm best suites, say if we have hundreds of documents and if we want to match the documents with a specific document, then we generate the hash for the required document and compare with others.

Note: Another scenario is, if given a text like 'abcgabcflmxyz' and we want to check if multple patterns 'abc','gab','xyz' are matching in the text, then this algorithm is best suited.

Rabin-Karp Vs Brute-Force/Naive
-------------------------------
If the hashing function is quick enough, then Rabin-Karp algorithm is faster. 

*****
Note: Rabin-Karp algorithm also works by sliding one character at a time. If hashing takes time, or if too many substrings matching the pattern hash then the performance could be worse than Brute-Force algorithm.

KMP Pattern
-----------
KMP means Knutt-Morris-Pratt. This algorithm uses degenerating property of the pattern and improves the worst case complexity to O(n).

Degenerating pattern, means pattern having same sub-patterns appearing more than. For ex, if pattern is 'abdab', where 'ab' is the sub-pattern appeared twice.

Note: KMP algorithm gives the time complexity O(m+n). But, pattern should satisfy the lps property.

This algorithm pre-process the pattern string before searching it in main text. Preprocess involves constructing an lps array corresponding to pattern, with the same size as pattern.

lps stands for longest proper prefix which is also suffix. For ex, proper prefixes of 'abc' are 'a' and 'ab'. similarly proper suffixes of 'abc' are 'c' and 'bc'.

Note: full pattern 'abc' is not considered either for prefix or suffix.

Consider the below example to understand lps. 

Text t -> a b c x a b c d a b x a b c d a b c d a b c y
pattern p -> a b c d a b c y

1)Starting from index 0 in t, first three characters are matching with p. But, 3rd index in t has x which is not matching with 3rd index of p, which has d. So, when there is a mismatch occurs howmany characters we can skip to start comparing in t. Howmany characters to skip depends on the previous characters in p before d. i.e. abc. so the substring 'abc' is not statisfying lps i.e. it has no prefix which is also a suffix. so, next match can start from character x and index 0 in pattern. Here is the 
				
	Text    t -> a b c x a b c d a b x a b c d a b c d a b c y
	pattern p -> a b c d a b c y
			 	
2)x is compared with a, no match. so move to next character.

				   |
		Text    t -> a b c x a b c d a b x a b c d a b c d a b c y
		pattern p ->       a b c d a b c y
 			 	   |
				   
3)Now characters a and a matched, b and b matched, c and c matched, d and d matched, a and a matched, b and b matched, x and c not mached.

				                 |  
		Text    t -> a b c x a b c d a b x a b c d a b c d a b c y
		pattern p ->         a b c d a b c y
 			               	         |
					     
4)Now characters in p, before c are 'a b c d a b'. In this the 'a b' is satisfying the lps property. so skip, 'a b' in p and start comparing 3rd character 'c' with x in t. 

						 |  
		Text    t -> a b c x a b c d a b x a b c d a b c d a b c y
		pattern p ->                 a b c d a b c y
 					         |						 
					     
5)x and c are not matching. before the character 'c' in 'p' we have 'a b'. no lps property satisfied here. so, start comparing x with a. 

						 |  
		Text    t -> a b c x a b c d a b x a b c d a b c d a b c y
		pattern p ->                     a b c d a b c y
					         |

6)x and a not matching. so skip one character and then compare.

						   |  
		Text    t -> a b c x a b c d a b x a b c d a b c d a b c y
		pattern p ->                       a b c d a b c y
						   |

7) all characters are matching until the last character. i.e. d and y are not matching. so characters before 'y' in p are 'a b c d a b c'. This satisfies the lps property for the characters 'a b c'. so skip 3 characters in p and start comparing 'd' in p with 'd' in t.

								 |
		Text    t -> a b c x a b c d a b x a b c d a b c d a b c y
		pattern p ->                    	   a b c d a b c y
								 |

8)now all characters matching from d to y in both t and p.

