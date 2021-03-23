package tw.chris.model;

import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDAO {
	@Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public House findHouseById(int houseid) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		return session.get(House.class, houseid);

	}

//	@Autowired @Qualifier("sqlserverDataSource")
//	private DataSource datasource;
//
//	public House findHouseById(int houseid) throws SQLException {
//		House house1 = null;
//		Connection conn = datasource.getConnection();
//		String sql = "Select * From [ChrisPower].[dbo].[House] Where houseid = ?";
//
//		PreparedStatement ptst = conn.prepareStatement(sql);
//		ptst.setInt(1, houseid);
//		ResultSet rs = ptst.executeQuery();
//		if (rs.next()) {
//			house1 = new House();
//			house1.setHouseid(rs.getInt(1));
//			house1.setHousename(rs.getNString(2));
//		}
//		rs.close();
//		ptst.close();
//		conn.close();
//		return house1;
//	}

}
