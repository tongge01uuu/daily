package com.daily.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daily.entity.StockEntity;
import com.google.gson.Gson;

@WebServlet(urlPatterns="/servlet.test")
public class ServletController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("--get");
		resp.getWriter().print("do get");
		System.out.println("--after print ");
//		super.doGet(req, resp); //加上这一行无法print到页面内容
//		System.out.println("--after super get");
//		resp.sendRedirect("view/test.jsp");
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("--doHead");
		super.doHead(req, resp);
	}

	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--doOptions");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--");
		
		String[] keystr={"一","二","三","四","五"};
		
		List stocks=new ArrayList();
		StockEntity stock=null;
		
		for (int i = 0; i < keystr.length; i++) {
			stock=new StockEntity();
			stock.setCompany_name(keystr[i]+"有限公司");
			stock.setId(i);
			stock.setStock_name(keystr[i]+"商品");
			stock.setStock_no(i);
			stock.setStock_price(i*100);
			stocks.add(stock);
		}
		Gson gson=new Gson();
		String result=gson.toJson(stocks);
		System.out.println(result);
		response.getOutputStream().write(result.getBytes("UTF-8"));  
		response.setContentType("text/json; charset=UTF-8");  
	}

	@Override
	protected long getLastModified(HttpServletRequest req) {
		System.out.println("--getLastModified");
		return super.getLastModified(req);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("--http servlet service");
		super.service(arg0, arg1);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("--servlet service");
		super.service(arg0, arg1);
	}

	@Override
	public void destroy() {
		System.out.println("--destroy");
		super.destroy();
	}

	@Override
	public String getInitParameter(String name) {
		System.out.println("--InitParameter");
		return super.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		System.out.println("--Enumeration");
		return super.getInitParameterNames();
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("--ServletConfig");
		return super.getServletConfig();
	}

	@Override
	public ServletContext getServletContext() {
		System.out.println("--ServletContext");
		return super.getServletContext();
	}

	@Override
	public String getServletInfo() {
		System.out.println("--getServletInfo");
		return super.getServletInfo();
	}

	@Override
	public String getServletName() {
		System.out.println("--getServletName");
		return super.getServletName();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("--init");
		super.init();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("--ServletConfig init");
		super.init(config);
	}

	@Override
	public void log(String message, Throwable t) {
		System.out.println("-- log with Throwable");
		super.log(message, t);
	}

	@Override
	public void log(String msg) {
		System.out.println("-- log");
		super.log(msg);
	}

}
