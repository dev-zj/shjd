package common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.web.filter.CharacterEncodingFilter;

public class EncodingTool extends FilterRegistrationBean {  
    public static String encodeStr(String str) {  
        try {  
        	Object obj = new org.springframework.web.filter.CharacterEncodingFilter();
//        	Object obj = new FilterRegistrationBean();
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }
    
	@Override
	public void addServletRegistrationBeans(
			ServletRegistrationBean... servletRegistrationBeans) {
		// TODO Auto-generated method stub
		super.addServletRegistrationBeans(servletRegistrationBeans);
	}

	@Override
	public void addServletNames(String... servletNames) {
		// TODO Auto-generated method stub
		super.addServletNames(servletNames);
	}

	@Override
	public void addUrlPatterns(String... urlPatterns) {
		// TODO Auto-generated method stub
		super.addUrlPatterns(urlPatterns);
	}
	  
}  
