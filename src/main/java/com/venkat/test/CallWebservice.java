package com.venkat.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CallWebservice {
	public static void main(String[] args) {
		getFilmsAndCharacters("A New Hope", "Raymus Antilles");
	}

	public static String getFilmsAndCharacters(String film, String character) {
		String result = null;
		try {
			StringBuilder tempResult = new StringBuilder();
			String urlFilmString = "https://challenges.hackajob.co/swapi/api/films/?format=json";
			String urlCharString = "https://challenges.hackajob.co/swapi/api/people/";
			URL url = new URL(urlFilmString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				tempResult.append(line);
			}
			System.out.println("First " + tempResult);
			rd.close();
			JsonObject jsonObject = JsonParser.parseString(tempResult.toString()).getAsJsonObject();
			int size = jsonObject.getAsJsonArray("results").size();

			JsonElement element = null;
			JsonArray array = null;
			for (int i = 0; i <= size; i++) {
				// String name1 = jsonObject.getAsJsonArray("results").get(i);
				if (jsonObject.getAsJsonArray("results").get(i).getAsJsonObject().get("title").getAsString()
						.equals(film)) {
					System.out.println(jsonObject.getAsJsonArray("results").get(i));
					element = jsonObject.getAsJsonArray("results").get(i).getAsJsonObject().get("characters");
					break;
				}
			}
			if (element.isJsonArray()) {
				array = element.getAsJsonArray();
			}
			tempResult = new StringBuilder();
			List<String> charNames = new ArrayList<String>();
			for (int i = 0; i < array.size(); i++) {
				url = new URL(array.get(i).getAsString());
				System.out.println(array.get(i).getAsString());
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				
				 rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				 String line1;
					while ((line1 = rd.readLine()) != null) {
						tempResult.append(line1);
					}
					System.out.println(tempResult);
					rd.close();
					jsonObject = JsonParser.parseString(tempResult.toString()).getAsJsonObject();
					System.out.println("Result that we got "+jsonObject.getAsJsonArray("results").get(0));
					//charNames.add(e)
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	public int getTotalFilms() {
		int totalFilms = 0;
		try {
			StringBuilder result = new StringBuilder();
			String name = "Luke Skywalker";
			String urlString = "https://challenges.hackajob.co/swapi/api/people/?format=json";
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();

			JsonObject jsonObject = JsonParser.parseString(result.toString()).getAsJsonObject();

			System.out.println(jsonObject.getAsJsonArray("results").size());
			int size = jsonObject.getAsJsonArray("results").size();

			System.out.println(jsonObject.getAsJsonArray("results").get(0));
			JsonElement element = null;
			JsonArray array = null;
			for (int i = 0; i <= size; i++) {
				String name1 = jsonObject.getAsJsonArray("results").get(i).getAsJsonObject().get("name").getAsString();
				if (name1.equals(name)) {
					System.out.println("found");
					element = jsonObject.getAsJsonArray("results").get(i).getAsJsonObject().get("films");
					break;
				}
			}
			if (element.isJsonArray()) {
				array = element.getAsJsonArray();
				totalFilms = array.size();
			} else {
				totalFilms = 1;
			}
			System.out.println(array.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalFilms;
	}

}
