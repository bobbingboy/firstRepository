package tw.bobbyko.model;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Session getSession() {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sessionFactory.openSession();
		return session;
	}

	public boolean checkLogin(Userdata rBean) {
		// method checkExist is used to check whether the account is already created.

		String target_1 = "user_acc";
		String target_2 = "user_pwd";

		String hql = String.format("from Userdata as u where u.%s =?1 and u.%s =?2", target_1, target_2);

		System.out.println("Search Start.");

		Query<Userdata> query = getSession().createQuery(hql, Userdata.class);
		query.setParameter(1, rBean.getUser_acc());
		query.setParameter(2, rBean.getUser_pwd());

		return !query.list().isEmpty();

		// if line35 return true, means there is acc and pwd existed in database, and
		// accept to login.
	}

	public Userdata showdata(Userdata rBean) {

		int id = getid(rBean.getUser_acc());

		System.out.println("Search Start.");

		return getSession().get(Userdata.class, id);

	}

	public int getid(String user_acc) {

		try {
			// String targetName = "userid";
			String tableName = "Userdata";
			String columnName = "user_acc";
			// String hqlsql = "from Login as l where l.username=?1";

			String hqlsql = String.format("from %s as l where l.%s=?1", tableName, columnName);
			Query<Userdata> query = getSession().createQuery(hqlsql, Userdata.class);
			query.setParameter(1, user_acc);

			System.out.println("SEARCH SUCCESS");

			int id0 = query.list().get(0).getUserid();
			System.out.println(id0);
			return id0;
		} catch (Exception e) {
			System.out.println("");
			e.printStackTrace();
			return -1;
		}
	}

}
