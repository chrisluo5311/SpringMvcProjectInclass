package tw.chris.model;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("houseService")                                      
public class HouseService {

	@Autowired
	private HouseDAO housedao;

	public HouseService(HouseDAO housedao) {
		this.housedao = housedao;
	}

	public House findHouseById(int houseid) throws SQLException {
		return housedao.findHouseById(houseid);
	}
}
