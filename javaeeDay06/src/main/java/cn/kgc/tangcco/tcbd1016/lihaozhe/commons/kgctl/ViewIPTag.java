package cn.kgc.tangcco.tcbd1016.lihaozhe.commons.kgctl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class ViewIPTag implements Tag {  
	  
    private PageContext pageContext;      
    @Override  
    public int doStartTag() throws JspException {  
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest(); //获取request  
        JspWriter out = pageContext.getOut(); //获取out</span>  
          
        String ip = request.getRemoteAddr(); //通过request获取客户机的ip  
        try {  
            out.write(ip); //写到浏览器  
        } catch (IOException e) {  
            throw new RuntimeException(e);  
        }         
        return 0;  
    }     
    @Override  
    public int doEndTag() throws JspException {  
        return 0;  
    }  
    @Override  
    public Tag getParent() {  
        return null;  
    }  
    @Override  
    public void release() {  
    }  
    @Override  
    public void setParent(Tag arg0) {  
    }
	@Override
	public void setPageContext(PageContext pc) {
		 this.pageContext = pc;
	}  
}