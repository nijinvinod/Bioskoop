package com.avnet.bioskoop.commons.beans;

public class User1PI {
	private String id;

	private Tree tree;

	private String source;

	private String word_count;

	private String word_count_message;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getWord_count() {
		return word_count;
	}

	public void setWord_count(String word_count) {
		this.word_count = word_count;
	}

	public String getWord_count_message() {
		return word_count_message;
	}

	public void setWord_count_message(String word_count_message) {
		this.word_count_message = word_count_message;
	}

	@Override
	public String toString() {
		return "User1PI [id=" + id + ", tree=" + tree + ", source=" + source
				+ ", word_count=" + word_count + ", word_count_message="
				+ word_count_message + "]";
	}

}
