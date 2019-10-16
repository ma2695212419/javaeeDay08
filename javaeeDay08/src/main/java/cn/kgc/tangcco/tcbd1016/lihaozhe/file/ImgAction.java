package cn.kgc.tangcco.tcbd1016.lihaozhe.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.servlet.BaseServlet;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.uuid.BaseUUID;

@WebServlet(urlPatterns = "/img.action")
@MultipartConfig()
public class ImgAction extends BaseServlet {
	private static final long serialVersionUID = 7520698361543989025L;

	public void upload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Part part = request.getPart("upfile");
		// 获取文件名字
		String submittedFileName = part.getSubmittedFileName();
		// 截取文件扩展名
		String str = submittedFileName.substring(submittedFileName.lastIndexOf("."), submittedFileName.length());
		// 获取上传路径在当前系统的完整路径
		String root = request.getServletContext().getRealPath("upfiles");
		// 上传路径+随机生成的新的文件名字+源文件扩展名
		String fileName = root + File.separator + BaseUUID.generate().toString() + str;
		// 保存文件
		part.write(fileName);
	}

	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//服务器相对路径
		String filepath = "upfiles/139ce2100b82a19f667451086aa5bd0697eaefc2f08c8b.zip";
		//服务器绝对路径
		String fullFilePath = getServletContext().getRealPath(filepath);
		System.out.println(fullFilePath);
		/*打开文件，创建File类型的文件对象*/
		File file = new File(fullFilePath);
		/*如果文件存在*/
		if(file.exists()){
			System.out.println("文件存在");
			/*获得文件名，并采用UTF-8编码方式进行编码，以解决中文问题*/
			String filename = URLEncoder.encode(file.getName(), "UTF-8");
			System.out.println(filename);
			/*重置response对象*/
			// response.reset();
			//设置文件的类型，xml文件采用text/xml类型，详见MIME类型的说明
			// response.setContentType("text/xml");
			 //设置响应头，控制浏览器下载该文件
            // response.setHeader("Content-Type","application/octet-stream");
            response.setHeader("Content-Type","application/x-gzip");
            // response.setHeader("Content-Disposition","attachment;filename="+java.net.URLEncoder.encode(zipName, "UTF-8"));
			//设置HTTP头信息中内容
			response.addHeader("Content-Disposition","attachment:filename=\"" + filename + "\"" );
			//设置文件的长度
			int fileLength = (int)file.length();
			System.out.println(fileLength);
			response.setContentLength(fileLength);
			/*如果文件长度大于0*/
			if(fileLength!=0){
				//创建输入流
				InputStream inStream = new FileInputStream(file);
				byte[] buf = new byte[4096];
				//创建输出流
				ServletOutputStream servletOS = response.getOutputStream();
				int readLength;
				//读取文件内容并写到response的输出流当中
				while(((readLength = inStream.read(buf))!=-1)){
					servletOS.write(buf, 0, readLength);
				}
				//关闭输入流
				inStream.close();
				//刷新输出缓冲
				servletOS.flush();
				//关闭输出流
				servletOS.close();
			}
		}else {
			System.out.println("文件不存在~！");
			PrintWriter out = response.getWriter();
			out.println("文件 \"" + fullFilePath + "\" 不存在");
		}
	}
}
