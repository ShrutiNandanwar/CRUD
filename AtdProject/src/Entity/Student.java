package Entity;

public class Student {
	
	private int id;
	private String name;
	private String surname;
	private String dob;
	private String doj;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public Student() {
		super();
	}

	public Student(int id, String name, String surname, String dob, String doj) {
		super();
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.dob=dob;
		this.doj=doj;
	}
	
	
	
	}
