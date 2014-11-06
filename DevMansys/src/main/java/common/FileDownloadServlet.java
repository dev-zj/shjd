package common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		// 服务器相对路径
        String path = req.getParameter("path").replace("/", "\\");
        // 服务器绝对路径
//        path = getServletContext().getRealPath("/") + path;

       // 检查文件是否存在
        File obj = new File(path);
        if (!obj.exists()) {
          res.setContentType("text/html;charset=UTF-8");
          res.getWriter().print("指定文件不存在！");
          return;
        }

       // 读取文件名：用于设置客户端保存时指定默认文件名
        int index = path.lastIndexOf("\\"); // 前提：传入的path字符串以“\”表示目录分隔符
        String fileName = path.substring(index + 1);
 
        // 写流文件到前端浏览器
        ServletOutputStream out = res.getOutputStream();
        res.setContentType("application/x-download");//设置为下载application/x-download
        //res.setHeader("Content-disposition", "attachment;filename=" + fileName);
        res.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
          bis = new BufferedInputStream(new FileInputStream(path));
          bos = new BufferedOutputStream(out);
          byte[] buff = new byte[2048];
          int bytesRead;
          while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
            bos.write(buff, 0, bytesRead);
          }
        } catch (IOException e) {
          throw e;
        } finally {
          if (bis != null)
            bis.close();
          if (bos != null)
            bos.close();
        }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
}
