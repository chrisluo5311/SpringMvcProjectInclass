package tw.chris.model;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PictureDAO {

	@Autowired
	private SessionFactory sessionactory;
	
	public Picture insert(Picture bean) {
		Session session = sessionactory.getCurrentSession();
		if(bean!=null) {
			session.save(bean);
		}
		
		return bean;
	}
	
}
