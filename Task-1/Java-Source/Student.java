package demo;

public class Student {
	
	int id;
	String name;
	int age;
	String password;
	String email;
	
	public Student(int id,String name,int age,String password,String email) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.password=password;
		this.email=email;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}
	
}
