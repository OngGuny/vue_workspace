package dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;


@AllArgsConstructor

public class MemberDTO implements Serializable{
	private String id;
	private String name;
	private String email;
	private Timestamp joindate;
	
	public static final long serialVersionUID = 444444444456L;

	public MemberDTO(){}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getJoindate() {
		return joindate;
	}

	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "memberDTO [id=" + id + ", name=" + name + ", email=" + email + ", joindate=" + joindate + "]";
	}
	
	

}
