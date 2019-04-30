package Model;

public class Node {
	private Patient patient;
	private int priority;
	/**
	 * @param patient
	 * @param priority
	 */
	public Node(Patient patient, int priority) {
		super();
		this.patient = patient;
		this.priority = priority;
	}
	/**
	 * 
	 */
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return patient + ", Priority: " + priority;
	}
	
	
}
