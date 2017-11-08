package com.learning.stringmatch;

import java.util.ArrayList;
import java.util.List;

import com.learning.domain.SearchMatch;

public class RabinKarpStringSearchAlgorithm {
	private static final int PRIME = 101;

	public static void main(String[] args) {
		char[] text = "Make sure you learned the key concepts key".toCharArray();
		char[] pattern = "key".toCharArray();
		List<SearchMatch> matches=match(text,pattern);
		System.out.println("finding match ");
		matches.forEach(System.out::println);
		System.out.println("end");

	}

	private static List<SearchMatch> match(char[] text, char[] pattern) {
		
		List<SearchMatch> matchList = new ArrayList<>();
		int matchCount=0;
		int n = text.length;
		int m = pattern.length;
		long patternHash = createHash(pattern,m);
		long textHash = createHash(text,m);
		for(int i=0; i< n-m+1;i++ ) {
			if(patternHash == textHash && checkEqual(text,i,i+m-1,pattern,0,m-1)) {
				matchList.add(new SearchMatch(i, ++matchCount));
			}
			if(i < n-m) {
				textHash = recalculateHash(text,i,i+m,textHash,m);
			}
		}
		return matchList;
	}

	private static long createHash(char[] str, int length) {
		long hash = 0;
		for(int i=0; i <= length-1 ; i++) {
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
	
	
}
