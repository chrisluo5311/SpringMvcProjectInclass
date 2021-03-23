package tw.chris.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PictureService {

	@Autowired
	private PictureDAO pDao;
	
	public Picture insert(Picture bean) {
		return pDao.insert(bean);
	}
	
}
