package tw.bobbyko.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.json.JSONArray;

import org.json.JSONObject;

@Repository
public class SelectDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Session getSession() {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sessionFactory.openSession();
		return session;
	}

	private static String[] empColName = { "NO.", "Account", "Password", "Name", "Phone", "Birthday", "Email" };

	public String select(Userdata rBean) {

		// String targetName = "userid";
		String tableName = "Userdata";
		String columnName = "user_acc";
		// String hqlsql = "from Login as l where l.username=?1";

		String hqlsql = String.format("from %s as l where l.%s=?1", tableName, columnName);
		Query<Userdata> query = getSession().createQuery(hqlsql, Userdata.class);
		query.setParameter(1, rBean.getUser_acc());
		
		ArrayList<LinkedHashMap<String, String>> aList = new ArrayList<>();
				
		
		List<Userdata> u = query.list();
		System.out.println(u.get(0).getEmail());
		int size = 4;
		
		for (Userdata uu : query.list()) {
			for (int j = 0; j < query.list().size(); j++) {
				for (int k = 0; k < 3; k++) {
					
				}
				query.list().get(j).getUser_acc();
				query.list().get(j).getUsername();
				query.list().get(j).getUser_pwd();
				query.list().get(j).getUser_phone();
				query.list().get(j).getBirthday();
				query.list().get(j).getEmail();
			}
		}
//		ArrayList.add()
		
		
		System.out.println("-----------------");
//		System.out.println(u);
		

		System.out.println("-----------------");

		for (Userdata component : query.list()) {
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			for (int i = 0; i < query.list().size(); i++) {
				map.put(empColName[i], component.toString());
				System.out.println(i);
			}
			aList.add(map);
		}
		
		JSONArray ary = new JSONArray();
		for (LinkedHashMap<String, String> emp : aList) {
			JSONObject object = new JSONObject();
			Set<String> keySet = emp.keySet();
			for (String key : keySet) {
				object.put(key, emp.get(key));// Set (key, value) pair into object
			}
			ary.put(object);
		}

		System.out.println(ary.toString());
		return ary.toString();

	}

	public List<Userdata> selectAll(Userdata rBean) {

		String tableName = "Userdata";
		String hqlsql = String.format("from %s", tableName);
		return getSession().createQuery(hqlsql, Userdata.class).list();

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
