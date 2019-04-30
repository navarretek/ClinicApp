package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Doctor;

public class DoctorHelper {
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ClinicAppFinal");

		
		public void insertDoctor(Doctor p) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Doctor> showAllDoctors() {
			EntityManager em = emfactory.createEntityManager();
			List<Doctor> allDoctors = em.createQuery("SELECT d FROM Doctor d").getResultList();
			return allDoctors;
		}
		
		public void deleteDoctor(Doctor toDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Doctor> typedQuery = em.createQuery("select d from Doctor d where d.firstname = :selectedfirstname and d.lastname = :selectedlastname", Doctor.class);
			
			//substitute parameter with actual data from the toDelete item
			typedQuery.setParameter("selectedfirstname", toDelete.getFirstName());
			typedQuery.setParameter("selectedlastname", toDelete.getLastName());
			
			//we only want one result
			typedQuery.setMaxResults(1);
			
			//get the result and save it 
			Doctor result = typedQuery.getSingleResult();
			
			//remove it
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}
}
