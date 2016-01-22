package com.avnet.bioskoop.twitter.util;

public class ImageURLTrimmer {

	public static String removeNormalFromURL(String imageUrl)
	{
		
		String trimmedImageURL = imageUrl.replaceFirst("_normal","");
		return trimmedImageURL;
	}
}
