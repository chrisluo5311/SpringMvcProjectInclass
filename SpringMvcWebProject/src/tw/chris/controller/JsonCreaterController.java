package tw.chris.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.chris.model.House;

@Controller
public class JsonCreaterController {
	
	@RequestMapping(path="/houseJason.controller",method = RequestMethod.GET)
	@ResponseBody
	public House processHouseJsonAction() {
		House house1 = new House();
		house1.setHouseid(1);
		house1.setHousename("stevehouse");
		return house1;
	}
	
	@RequestMapping(path="/houseJasonAarray.controller",method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<House> processHouseArrayJsonAction(){
		House house2 = new House();
		house2.setHouseid(2);
		house2.setHousename("greenhouse");
		House house3 = new House();
		house3.setHouseid(3);
		house3.setHousename("redhouse");
		
		ArrayList<House> housearray = new ArrayList<House>();
		housearray.add(house2);
		housearray.add(house3);
		return housearray;
	}

}
