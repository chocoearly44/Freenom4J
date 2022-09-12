package tk.thesuperlab.freenom4j.http;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bakery implements CookieJar {
	private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();

	@Override
	public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
		cookieStore.put(url, cookies);
	}

	@Override
	public List<Cookie> loadForRequest(HttpUrl url) {
		List<Cookie> cookies = cookieStore.get(url);
		return cookies != null ? cookies : new ArrayList<Cookie>();
	}
}
