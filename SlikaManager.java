package managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Picture;
import model.User;

public class SlikaManager {
	
	public Picture saveSlika(String naziv, String autor, String godina, String pravac, User korisnik)
	{
		try
		{
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			
			Picture p = new Picture();
			p.setPictureName(naziv);
			p.setAuthor(autor);
			p.setAge(godina);
			p.setDirection(pravac);
			p.setUserID(korisnik.getUserID());
			em.persist(p);
			em.getTransaction().commit();
			em.close();
			return p;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public User getUserForID(int ID)
	{
		try
		{
			EntityManager em = JPAUtils.getEntityManager();
			User u = em.find(User.class, ID);
			em.close();
			return u;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public List<Picture> getAllPictures(){
		EntityManager em=JPAUtils.getEntityManager();
		
		TypedQuery<Picture> tq=em.createQuery("select * from Picture p",Picture.class);
		List<Picture> list = tq.getResultList();
		return list;
	}
	public List<Picture>  poAutoru(String autor){
		EntityManager em=JPAUtils.getEntityManager();
		Query q = em.createQuery("SELECT p.pictureName, p.age, p.direction,p.author FROM Picture p WHERE p.author = :author");
		q.setParameter("autor",autor);
		
		List<Picture> list = q.getResultList();
		return list;
	}
	public List<Picture>  poNazivu(String naziv){
		EntityManager em=JPAUtils.getEntityManager();
		Query q = em.createQuery("SELECT p.pictureName, p.age, p.direction,p.author FROM Picture p WHERE p.pictureName = :pictureName");
		q.setParameter("naziv",naziv);
		
		List<Picture> list = q.getResultList();
		return list;
	}
	public List<Picture>  poGodiniNastanka(String godina){
		EntityManager em=JPAUtils.getEntityManager();
		Query q = em.createQuery("SELECT p.pictureName, p.age, p.direction,p.author FROM Picture p WHERE p.age = :age");
		q.setParameter("autor",godina);
		
		List<Picture> list = q.getResultList();
		return list;
	}
	public List<Picture>  poPravcu(String pravac){
		EntityManager em=JPAUtils.getEntityManager();
		Query q = em.createQuery("SELECT p.pictureName, p.age, p.direction,p.author FROM Picture p WHERE p.age = :age");
		q.setParameter("autor",pravac);
		
		List<Picture> list = q.getResultList();
		return list;
	}
	
}
