package cn.kgc.tangcco.tcbd1016.lihaozhe.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.uuid.BaseUUID;

/**
 * Servlet implementation class UpLoad
 */
@WebServlet(name = "upload", urlPatterns = { "/upload.action" })
@MultipartConfig()
public class UpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("upfile");
//		String reqinfo = part.getHeader("content-disposition");
//		System.out.println(reqinfo);
//		String str = reqinfo.substring(reqinfo.lastIndexOf("."), reqinfo.length());
//		System.out.println(str);
//		System.out.println(part.getName());
		// System.out.println(part.getSubmittedFileName());
		// 获取文件名字
		String submittedFileName = part.getSubmittedFileName();
		// 截取文件扩展名
		String str = submittedFileName.substring(submittedFileName.lastIndexOf("."), submittedFileName.length());
		// 获取上传路径在当前系统的完整路径
		String root = request.getServletContext().getRealPath("upfiles");
		// System.out.println(root);
		// 上传路径+随机生成的新的文件名字+源文件扩展名
		String fileName = root+File.separator+BaseUUID.generate().toString()+str;
		// System.out.println(fileName);
		// 保存文件
		part.write(fileName);
	}

}
