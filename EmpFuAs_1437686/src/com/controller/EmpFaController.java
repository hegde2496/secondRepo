package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Faculty;
import com.dao.EmpFaDao;
import com.service.EmpFaService;

/**
 * Servlet implementation class EmpFaController
 */
public class EmpFaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpFaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("search")){
			String names = request.getParameter("sename");
			EmpFaService ser = new EmpFaService();
			ArrayList<Faculty> fa = ser.searchfac(names);
			
			request.setAttribute("f", fa);
			
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		}
	}

}
