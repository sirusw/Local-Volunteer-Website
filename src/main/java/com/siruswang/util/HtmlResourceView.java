package com.siruswang.util;
import java.io.File;
import java.util.Locale;
 
import org.springframework.web.servlet.view.InternalResourceView;
 
/** 
 * @author hui 
 * @date ����ʱ�䣺2018��5��9�� ����5:26:55 ������½�
 * @version 1.0 
 **/
public class HtmlResourceView extends InternalResourceView {
    @Override  
    public boolean checkResource(Locale locale) {  
     File file = new File(this.getServletContext().getRealPath("/") + getUrl());  
     return file.exists();// �жϸ�ҳ���Ƿ����  
    }

}