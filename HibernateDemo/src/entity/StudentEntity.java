package entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class StudentEntity {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="cname")
	private String cname;
	
	@Column(name="marks")
	private int marks;
	
	@Column(name="grade")
	private String grade;
	
	@Embedded
	@AttributeOverrides ({
			@AttributeOverride (name = "street", column = @Column(name = "STREET")),
			@AttributeOverride (name = "area", column = @Column(name = "AREA"))
	})
		
	
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	StudentEntity(){
		
	}

	public StudentEntity(int id, String cname, int marks, String grade) {
		this.id = id;
		this.cname = cname;
		this.marks = marks;
		this.grade = grade;
	}
	
	

}
