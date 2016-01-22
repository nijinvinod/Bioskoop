package com.avnet.bioskoop.commons.util;

import com.avnet.bioskoop.commons.beans.FinalBean;
import com.avnet.bioskoop.commons.beans.PersonalityInsightsBean;
import com.google.gson.Gson;

public class BeanToJsonConverter {

	public static String convertFinalBeanToJson(FinalBean finalBean)
	{
		Gson gson = new Gson();
		String json = gson.toJson(finalBean);
		
		System.out.println("Final Bean :"+finalBean);
		System.out.println("Json :"+json);
		return json;
				 
	}
	public static String convertPersonalityInsightsBeanToJson(PersonalityInsightsBean piBean)
	{
		Gson gson = new Gson();
		String json = gson.toJson(piBean);
		
		System.out.println("Final Bean :"+piBean);
		System.out.println("Json :"+json);
		return json;
	}
}
