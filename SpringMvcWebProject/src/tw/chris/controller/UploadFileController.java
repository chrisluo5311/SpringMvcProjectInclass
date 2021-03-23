package tw.chris.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.chris.model.Picture;
import tw.chris.model.PictureService;

@Controller
public class UploadFileController {

	@RequestMapping(path = "/uploadMainPage.controller", method = RequestMethod.GET)
	public String processUploadMainPage() {
		return "UploadFile";
	}


	@RequestMapping(path = "/upload.controller", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<byte[]> processUploadFile(@RequestParam(name = "myfiles2") MultipartFile multipartFile,
			HttpServletRequest request) throws IllegalStateException, IOException {
		String name = multipartFile.getOriginalFilename();
		System.out.println("filename:" + name);

		String saveDirpath = request.getSession().getServletContext().getRealPath("/") + "uploadTempDir2\\";
		File fileDir1 = new File(saveDirpath);
		fileDir1.mkdirs();// 自動建立沒有的路徑
//		File rename = new File(saveDirpath+"helloThisIsRename.jpg");
		
		String saveFilePath = saveDirpath + name;
		System.out.println(saveDirpath);
		String filestr="helloThisIsRename.jpg";
		String newname = saveDirpath+filestr;
		File saveFile = new File(saveFilePath);
		
		File rename = new File(saveDirpath+filestr);
		saveFile.renameTo(rename);
		System.out.println(4);
		
		multipartFile.transferTo(saveFile);
		System.out.println(5);
		if (name != null && name.length() != 0) {
			savaPicture(filestr, newname);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(saveFile), headers, HttpStatus.OK);
	}

	@Autowired
	public PictureService pService;

	private void savaPicture(String filename, String savePath) {
		try {
			Picture picture = new Picture();
			picture.setFilename(filename);

			InputStream is1 = new FileInputStream(savePath);
			byte[] b = new byte[is1.available()];
			is1.read(b);
			is1.close();
			picture.setPicture(b);
			pService.insert(picture);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
