package tk.thesuperlab.freenom4j.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import tk.thesuperlab.freenom4j.entities.DomainType;
import tk.thesuperlab.freenom4j.entities.SimpleDomain;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ParseUtils {
	public static List<SimpleDomain> listDomains(String userToken) {
		try {
			ArrayList<SimpleDomain> toReturn = new ArrayList<>();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

			Document doc = Jsoup.connect("https://my.freenom.com/clientarea.php?action=domains")
					.cookie("WHMCSItemsPerPage", "-1")
					.cookie("WHMCSUser", userToken)
					.get();

			Elements rows = doc.body().getElementsByTag("table").get(0)
					.getElementsByTag("tbody").get(0)
					.getElementsByTag("tr");

			rows.forEach(row -> {
				try {
					Elements columns = row.getElementsByTag("td");

					SimpleDomain domain = new SimpleDomain();
					domain.setId(Long.parseLong(
							columns.get(5)
									.getElementsByClass("smallBtn whiteBtn pullRight")
									.get(0).attr("href")
									.trim()
									.split("&id=")[1]
					));
					domain.setName(columns.get(0)
							.getElementsByTag("a")
							.get(0).attr("href"));
					domain.setRegistrationDate(formatter.parse(
							columns.get(1).text()
					));
					domain.setExpiryDate(formatter.parse(
							columns.get(2).text()
					));
					domain.setType(convertType(columns.get(4)
							.text().toLowerCase()));

					toReturn.add(domain);
				} catch(Exception e) {
					e.printStackTrace();
				}
			});

			return toReturn;
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static DomainType convertType(String typeRaw) {
		switch(typeRaw) {
			case "free":
				return DomainType.FREE;
			case "paid":
				return DomainType.PAID;
			default:
				return null;
		}
	}
}
