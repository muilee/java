package com.iii.bb104.matt;

import java.util.*;

public class Homework1 {

	public static void main(String[] args) {
		String text = identify("        SELECT    ename , salary   FROM    employee  ;");
		System.out.println(text);

	}
	public static String identify(String s) {
		s = s.toLowerCase();
		s = s.replace(";", "");
		String regex = "\\s*select\\s+(\\w+\\s*,\\s*){1,}(\\w+\\s+)from\\s+\\w+\\s*";
		if(s.matches(regex)) {
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(s.split("\\s+|(\\s*,\\s*)")));
			int selectIndex = list.indexOf("select");
			int fromIndex = list.indexOf("from");
			String ans = "select\n";
			List<String> columns = list.subList(selectIndex + 1, fromIndex);
			String table = list.get(fromIndex + 1);
			ans += table + "\n";
			for (String column : columns) {
				ans += column + "\n";
			}
			return ans;
		}else {
			return "invalid statement";
		}
	}
}
