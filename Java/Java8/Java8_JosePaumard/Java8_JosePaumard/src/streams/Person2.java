package streams;

public class Person2 {

	String firstName;
	String lastName;
	String department;

	public Person2(String firstName, String lastName, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Person2 [firstName=" + firstName + ", lastName=" + lastName + ", department=" + department + "]";
	}
	
	

}
