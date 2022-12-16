package dto;

import java.io.Serializable;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDTO implements Serializable {

	public static final long serialVersionUID = 44444444456L;

	private int id;
	private String todos;
	private String time;
	

	
	
}
