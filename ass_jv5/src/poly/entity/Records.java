package poly.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Records")
public class Records {
	@Id
		@GeneratedValue
		@Column(name="Id")
		private String id;
		@Column(name="Type")
		private Integer type;
		@Column(name="Reason")
		private String reason;
		@Column(name="Date")
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		private Date date;
		
		@ManyToOne
		@JoinColumn(name="StaffId")
		private Staffs staff;

		
		
		public Records() {
		}

		public Records(String id, Integer type, String reason, Date date, Staffs staff) {
			super();
			this.id = id;
			this.type = type;
			this.reason = reason;
			this.date = date;
			this.staff = staff;
		}


		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
		}



		public Integer getType() {
			return type;
		}



		public void setType(Integer type) {
			this.type = type;
		}



		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		public Date getDate() {
			return date;
		}



		public void setDate(Date date) {
			this.date = date;
		}



		public Staffs getStaff() {
			return staff;
		}



		public void setStaff(Staffs staff) {
			this.staff = staff;
		}
		
		
		
}
