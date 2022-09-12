package tk.thesuperlab.freenom4j.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SimpleDomain {
	private Long id;
	private String name;
	private Date registrationDate;
	private Date expiryDate;
	private DomainType type;

	public SimpleDomain() {
	}

	@Override
	public String toString() {
		return "SimpleDomain{" +
				"id=" + id +
				", name='" + name + '\'' +
				", registrationDate=" + registrationDate +
				", expiryDate=" + expiryDate +
				", type=" + type +
				'}';
	}
}
