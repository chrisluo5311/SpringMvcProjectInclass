package tw.chris.model;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("accountdao")
@Transactional
public class AccountDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	public boolean checkLogin(Account users) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "from Account Where username=:user and userpwd=:pwd";
		Query<Account> query = session.createQuery(hql, Account.class);
		query.setParameter("user", users.getUsername());
		query.setParameter("pwd", users.getUserpwd());
		Account account = (Account)query.uniqueResult();
		return account != null?true:false;
	}
	
}
