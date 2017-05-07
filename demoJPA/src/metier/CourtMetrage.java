package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//HERITAGE AVEC TABLE UNIQUE
@DiscriminatorValue("Court")
public class CourtMetrage extends Film {
	
	private String cinema;

	public String getCinema() {
		return cinema;
	}

	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	@Override
	public String toString() {
		return "LongMetrage [cinema=" + cinema + "]";
	}
	

}
