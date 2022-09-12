package tk.thesuperlab.freenom4j;

import okhttp3.*;
import tk.thesuperlab.freenom4j.entities.SimpleDomain;
import tk.thesuperlab.freenom4j.http.Bakery;
import tk.thesuperlab.freenom4j.utils.ParseUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Main class for accessing your Freenom data.
 *
 * @author chocoearly44
 * @since 1.0
 */
public class Freenom {
	private final String email;
	private final String password;

	private String userToken;

	/**
	 * @param email    Your Freenom email
	 * @param password Your Freenom password
	 */
	public Freenom(String email, String password) {
		this.email = email;
		this.password = password;

		performLogin();
	}

	/**
	 * Method lists domains on your account.
	 *
	 * @return Domains on your account.
	 */
	public List<SimpleDomain> listDomains() {
		return ParseUtils.listDomains(userToken);
	}

	/**
	 * Method sets user access token.
	 */
	private void performLogin() {
		Bakery cookieJar = new Bakery();

		OkHttpClient httpClient = new OkHttpClient().newBuilder()
				.cookieJar(cookieJar)
				.followRedirects(false)
				.followSslRedirects(false)
				.build();

		RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addFormDataPart("username", this.email)
				.addFormDataPart("password", this.password)
				.addFormDataPart("rememberme", "on")
				.build();

		Request request = new Request.Builder()
				.url("https://my.freenom.com/dologin.php")
				.method("POST", body)
				.build();

		try {
			httpClient.newCall(request).execute();

			userToken = cookieJar.loadForRequest(HttpUrl.parse("https://my.freenom.com/dologin.php")).stream()
					.filter(cookie -> cookie.name().equals("WHMCSUser"))
					.collect(Collectors.toList())
					.get(0)
					.value();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
