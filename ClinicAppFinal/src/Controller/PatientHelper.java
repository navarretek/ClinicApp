package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Patient;

public class PatientHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ClinicAppFinal");

	
	public void insertPatient(Patient p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Patient> showAllPatients() {
		EntityManager em = emfactory.createEntityManager();
		List<Patient> allPatients = em.createQuery("SELECT p FROM Patient p").getResultList();
		return allPatients;
	}
	
	public void deletePatient(Patient toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Patient> typedQuery = em.createQuery("select p from patient p where p.firstname = :selectedfirstname and p.lastname = :selectedlastname", Patient.class);
		
		//substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedfirstname", toDelete.getFirstName());
		typedQuery.setParameter("selectedlastname", toDelete.getLastName());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it 
		Patient result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Patient searchForPatientById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Patient found = em.find(Patient.class, id);
		em.close();
		return found;
	}
	
	public Patient searchForPatientByName(String fName, String lName) {
		try {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Patient> typedQuery = em.createQuery("select p from Patient p where p.firstName = :selectedfirstname and p.lastName = :selectedlastname", Patient.class);
			typedQuery.setParameter("selectedfirstname", fName);
			typedQuery.setParameter("selectedlastname", lName);
			
			typedQuery.setMaxResults(1);

			Patient result = typedQuery.getSingleResult();
			
			em.close();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		
	}
}
