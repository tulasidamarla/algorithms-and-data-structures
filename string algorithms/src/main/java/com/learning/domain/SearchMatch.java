package com.learning.domain;

public class SearchMatch {

	private int startIndex;
	private int matchCount;
	
	public SearchMatch(int startIndex, int matchCount) {
		this.startIndex = startIndex;
		this.matchCount = matchCount;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public void setMatchCount(int matchCount) {
		this.matchCount = matchCount;
	}

	@Override
	public String toString() {
		return "SearchMatch [startIndex=" + startIndex + ", matchCount=" + matchCount + "]";
	}

}
