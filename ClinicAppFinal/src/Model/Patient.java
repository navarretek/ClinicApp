package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="age")
	private int age;
	@Column(name="heightInCm")
	private int heightInCm;
	@Column(name="phonenumber")
	private String phoneNumber;
	@Column(name="insured")
	private boolean insured;
	@Column(name="bloodType")
	private String bloodType;
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param heightInCm
	 * @param phoneNumber
	 * @param insured
	 * @param bloodType
	 */
	public Patient(String firstName, String lastName, int age, int heightInCm, String phoneNumber, boolean insured,
			String bloodType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.heightInCm = heightInCm;
		this.phoneNumber = phoneNumber;
		this.insured = insured;
		this.bloodType = bloodType;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the heightInCm
	 */
	public int getHeightInCm() {
		return heightInCm;
	}
	/**
	 * @param heightInCm the heightInCm to set
	 */
	public void setHeightInCm(int heightInCm) {
		this.heightInCm = heightInCm;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the insured
	 */
	public boolean isInsured() {
		return insured;
	}
	/**
	 * @param insured the insured to set
	 */
	public void setInsured(boolean insured) {
		this.insured = insured;
	}
	/**
	 * @return the bloodType
	 */
	public String getBloodType() {
		return bloodType;
	}
	/**
	 * @param bloodType the bloodType to set
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	/**
	 * 
	 */
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Age: " + age
				+ ", Height:" + heightInCm + "cm, Phone #: " + phoneNumber + ", Insured: " + insured
				+ ", Blood Type: " + bloodType ;
	}
}
