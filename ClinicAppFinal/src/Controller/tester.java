package Controller;

import java.util.List;

import Model.Doctor;
import Model.Node;
import Model.Patient;

public class tester {

	public static void main(String[] args) {
		FrontEnd frontEnd = new FrontEnd();
		PatientHelper ph = new PatientHelper();
	/*  
		Doctor d = new Doctor("Frank","Nav");
		DoctorHelper dh = new DoctorHelper();
		dh.insertDoctor(d);
		
		List<Doctor> list2 = dh.showAllDoctors();
		
		for (Doctor d1 : list2) {
			System.out.println(d1.toString());
		}
	*/	
		//Make new patient
	//	Patient p = new Patient("Frank", "Nav", 24, 123, "3239999999", true, "A+");
	//	ph.insertPatient(p);
		
		//get patient thats checking in and the priority
		Patient patient = ph.searchForPatientById(6);
		Patient patient1 = ph.searchForPatientById(1);
		Patient patient2 = ph.searchForPatientById(3);
		Patient patient3 = ph.searchForPatientById(2);

		int priority = 5;
		
		//check them in.
		frontEnd.addToQ(patient, priority);
		frontEnd.addToQ(patient1, 1);
		frontEnd.addToQ(patient2, 10);
		frontEnd.addToQ(patient2, 1);
		
		//look at q
		List<Node> q = frontEnd.getQList();
		for (int i = 0; i < q.size(); i++) {
			System.out.println(q.get(i));
		}
		
		System.out.println();
		
		//find patient using their name
		Patient found = ph.searchForPatientByName("Frank", "Nav");
		if(found == null) {
			System.out.println("Invalid Patient");
		}
		else System.out.println(found.toString());
		
	}

}
