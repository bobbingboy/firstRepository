package tw.bobbyko.model;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Session getSession() {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sessionFactory.openSession();
		return session;
	}

	public Userdata insert(Userdata rBean) {

		if (rBean != null) {
			getSession().save(rBean);
		}
		return rBean;
	}

	public boolean checkExist(Userdata rBean) {
		// method checkExist is used to check whether the account is already created.

		String target = "user_acc";
		String hql = String.format("from Userdata where %s =?1", target);

		System.out.println("Search Start.");

		return getSession().createQuery(hql, Userdata.class).setParameter(1, rBean.getUser_acc()).list().isEmpty();

		// if RHS is null, it means there is no such account exist, so it is OK to use.
	}
}
