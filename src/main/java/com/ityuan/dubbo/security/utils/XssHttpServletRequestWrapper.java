package com.ityuan.dubbo.security.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author ityuan
 * @version XssHttpServletRequestWrapper, v 0.1  2019/4/18 17:02
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Map<String,String[]> getParameterMap(){
		Map<String,String[]> request_map = super.getParameterMap();
		Iterator iterator = request_map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry me = (Map.Entry)iterator.next();
			String[] values = (String[])me.getValue();
			for(int i = 0 ; i < values.length ; i++){
				values[i] = xssClean(values[i]);
			}
		}

		return request_map;
	}
	@Override
	public String[] getParameterValues(String paramString)
	{
		String[] arrayOfString1 = super.getParameterValues(paramString);
		if (arrayOfString1 == null){
			return null;
		}
		int i = arrayOfString1.length;
		String[] arrayOfString2 = new String[i];
		for (int j = 0; j < i; j++){
			arrayOfString2[j] = xssClean(arrayOfString1[j]);
		}
		return arrayOfString2;
	}

	@Override
	public String getParameter(String paramString)
	{
		String str = super.getParameter(paramString);
		if (str == null) {
			return null;
		}
		return xssClean(str);
	}

	@Override
	public String getHeader(String paramString)
	{
		String str = super.getHeader(paramString);
		if (str == null){return null;}
		str = str.replaceAll("\r|\n", "");
		return xssClean(str);
	}


	private String xssClean(String value) {
		if (value != null) {
			value = value.replaceAll("\0", "");
			// Avoid anything between script tags
			Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid anything in a src='...' type of expression
			scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			// Avoid anything in a href='...' type of expression
			scriptPattern = Pattern.compile("href[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");


			// Remove any lonesome </script> tag
			scriptPattern = Pattern.compile("</script>",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Remove any lonesome <script ...> tag
			scriptPattern = Pattern.compile("<script(.*?)>",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid eval(...) expressions
			scriptPattern = Pattern.compile("eval\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid expression(...) expressions
			scriptPattern = Pattern.compile("expression\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid javascript:... expressions
			scriptPattern = Pattern.compile("javascript:",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid vbscript:... expressions
			scriptPattern = Pattern.compile("vbscript:",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid onload= expressions
			scriptPattern = Pattern.compile("onload(.*?)=",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
		}
		return value;
	}
}
