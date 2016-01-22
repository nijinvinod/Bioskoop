package com.avnet.bioskoop.commons.beans;

public class UserDetails {
	private String status;

	private String totalTransactions;

	private String usage;

	private ImageFaces[] imageFaces;

	private String url;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalTransactions() {
		return totalTransactions;
	}

	public void setTotalTransactions(String totalTransactions) {
		this.totalTransactions = totalTransactions;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public ImageFaces[] getImageFaces() {
		return imageFaces;
	}

	public void setImageFaces(ImageFaces[] imageFaces) {
		this.imageFaces = imageFaces;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "UserDetails [status = " + status + ", totalTransactions = "
				+ totalTransactions + ", usage = " + usage + ", imageFaces = "
				+ imageFaces + ", url = " + url + "]";
	}
}
