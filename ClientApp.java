package app102;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientApp {

	public static void main(String[] args) {
		Session session=null;
		SessionFactory sf=null;
		try
		{
			Configuration cfg=new Configuration();
			cfg.configure("app102/hibernate.cfg.xml");
			sf=cfg.buildSessionFactory();
			session=sf.openSession();
			Transaction tx=session.getTransaction();
			tx.begin();
			Employee emp=new Employee();
			emp.setEno(102);
			emp.setEname("lman");
			emp.setEsal(300000);
			emp.setEaddr("ranpur");
			session.save(emp);
			tx.commit();
			System.out.println("Record Inserted Successfully");
			
			
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			session.close();
			sf.close();
		}
		

	}

}
