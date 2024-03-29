package poly.entity;



import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Departs")
public class Departs {
@Id
	@Column(name="Id")
	private String id;
	@Column(name="Name")
	private String name;

	@OneToMany(mappedBy="depart", fetch=FetchType.EAGER)
	private Collection<Staffs> staff;
	
	public Departs(String id, String name, Collection<Staffs> staff) {
		this.id = id;
		this.name = name;
		this.staff = staff;
	}

	public Departs() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Staffs> getStaff() {
		return staff;
	}

	public void setStaff(Collection<Staffs> staff) {
		this.staff = staff;
	}
	
}
