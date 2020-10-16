package com.cm;
import com.cm.dao.CmDao;
import java.lang.reflect.Method;
import java.lang.Exception;
import com.cm.proxy.CmInvocationHandlerImpl;
public class $Proxy implements CmDao {
	private CmInvocationHandlerImpl h; 
	public $Proxy ( CmInvocationHandlerImpl h) {
		this.h = h;
	}
	public String query() throws Exception {
		Method method = Class.forName("com.cm.dao.CmDao").getDeclaredMethod("query");
		return (String)h.invoke(method);
	}
}