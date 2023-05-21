package accessingdatamysql.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Workshop {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Factory factory;

	public Workshop(Factory factory) {
		this.setFactory(factory);
	}
	@ManyToOne(fetch = FetchType.LAZY)
	private Personal director;

	@OneToMany(mappedBy = "workshop", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Site> sites = new ArrayList<>();
}
