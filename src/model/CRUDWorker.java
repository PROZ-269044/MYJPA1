package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;


public class CRUDWorker {

private EntityManagerFactory entityManagerFactory;
	
	CRUDWorker()
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("MYJPA1");
	}
	
	public void createWorker(Worker worker)
	{
		if (workerExists(worker.getEmpno()))
		{
			System.out.println("Pracownik ju¿ istnieje \n");
		}
		else
		{

			EntityManager entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(worker);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}
	
	
	@Override
	public void finalize()
	{
		entityManagerFactory.close();
	}
	
	public void deleteWorker(int id)
	{
		if (!workerExists(new BigDecimal(id)))
		{
			System.out.println("Pracownika ju¿ nie ma w bazie danych \n");
		}
		else 
		{
		
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			Worker worker = entityManager.find( Worker.class, new BigDecimal(id) );
			entityManager.remove(worker);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}
	
	public void readWorker(int id)
	{
		if (!workerExists(new BigDecimal(id)))
		{
			System.out.println("Pracownik nie figuruje w bazie danych \n");
		} 
		else 
		{
	      EntityManager entityManager = entityManagerFactory.createEntityManager();
	      Worker worker = entityManager.find( Worker.class, new BigDecimal(id) );

	      System.out.println("Worker EMPNO = " + worker.getEmpno());
	      System.out.println("Worker ENAME = " + worker.getEname());
	      System.out.println("Worker SAL = " + worker.getSal());
	      System.out.println("Worker JOB = " + worker.getJob());
	      System.out.println("Worker MGR = " + worker.getMgr());
	      System.out.println("Worker COMM = " + worker.getComm());
	      System.out.println("Worker HIREDATE = " + worker.getHiredate());
	      System.out.println("Worker DEPTNO = " + worker.getDeptno());
		}
	}
	
	public void updateWorker(int id)
	{  
		if(workerExists(new BigDecimal(id)))
		{
			  
			  //wyszukanie pracownika
			  EntityManager entityManager = entityManagerFactory.createEntityManager( );
		      entityManager.getTransaction( ).begin( );
		      Worker worker = entityManager.find( Worker.class, new BigDecimal(id) );
		    
		      worker.setSal(worker.getSal().multiply(new BigDecimal(1.1)));
		      //wypis przed updatem pensji
		      
		      entityManager.close();
		}
		else
		{
			System.out.println("nie mozna podniesc pensji pracownikowi niefugurujacemu w bazie");
		}
		  
	}
	
	public boolean workerExists(BigDecimal id) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Worker worker = entityManager.find(Worker.class, id);
		
		if (worker == null)
			return false;
		else
			return true;
	}

	
}
