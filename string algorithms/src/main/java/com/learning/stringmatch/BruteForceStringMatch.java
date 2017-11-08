package com.learning.stringmatch;

import java.util.ArrayList;
import java.util.List;

import com.learning.domain.SearchMatch;

public class BruteForceStringMatch {

	public static void main(String[] args) {
		char[] text = "Make sure you learned the key concepts key".toCharArray();
		char[] pattern = "key".toCharArray();
		List<SearchMatch> matches=match(text,pattern);
		
		matches.forEach(System.out::println);
		
	}

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
}
