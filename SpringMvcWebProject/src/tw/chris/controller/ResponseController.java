package tw.chris.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
	
	@RequestMapping(path="/response/responseBody.controller",method=RequestMethod.GET)
	@ResponseBody
	public String responseBdoy() {
		return "hi steve, ur grassbag";
	}
	
	@RequestMapping(path="/response/responseBodyEncode1.controller",method=RequestMethod.GET)
	@ResponseBody
	public String responseBdoyEncode1() {
		return "hi 史帝夫, ur 草包";
	}
	
	
	@RequestMapping(path="/response/responseBodyEncode2.controller",method=RequestMethod.GET,
			produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String responseBdoyEncode2() {
		return "hi 史帝夫, ur 草包";
	}
	
	@RequestMapping(path="/response/entity/status.controller",method=RequestMethod.GET)
	public  ResponseEntity<String> responseEntityStatusCode(){
		 return new ResponseEntity<String>("Message From Server ResponseEntity(Forbidden 403)", HttpStatus.FORBIDDEN);	 
	}
	
	
	@RequestMapping(path="/imagesResponse.controller",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] responseImageAsByteArray(HttpServletResponse response,HttpServletRequest request) throws IOException {
		InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/mvc.jpeg");
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		return IOUtils.toByteArray(in);
	}
	
	
	
}
