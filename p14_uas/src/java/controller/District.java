/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Putra Sudaryanto
 */
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DistrictModel;
import page.DistrictPage;

public class District extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String MANAGE = "/district/admin_manage.jsp";
    private static String INSERT_OR_EDIT = "/district/admin_form.jsp";
    private static String DELETE = "/district/admin_delete.jsp";
    private DistrictPage o;
    
    public District() {
        super();
        o = new DistrictPage();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        if(action.equalsIgnoreCase("delete")) {
            String id = request.getParameter("districtId");
            o.deleteByPk(id);
            forward = MANAGE;
            request.setAttribute("model", o.findAll());
            
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            String id = request.getParameter("districtId");
            DistrictModel model = o.findByPk(id);
            request.setAttribute("model", model);
            
        } else if (action.equalsIgnoreCase("manage")) {
            forward = MANAGE;
            request.setAttribute("model", o.findAll());
            
        } else if (action.equalsIgnoreCase("add")) {
            forward = INSERT_OR_EDIT;           
            
        } else {
            forward = MANAGE;
            request.setAttribute("model", o.findAll());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DistrictModel model = new DistrictModel();
        model.setPublish(request.getParameter("publish"));
        model.setDistrict(request.getParameter("district_name"));
	model.setMfdonline(request.getParameter("mfdonline"));
        String mfd = request.getParameter("mfdonline");
        if(mfd == null || mfd.isEmpty()) {
            o.insert(model);
        } else {
            model.setMfdonline(mfd);
            o.find(model);
        }

        RequestDispatcher view = request.getRequestDispatcher(MANAGE);
        request.setAttribute("model", o.findAll());
        view.forward(request, response);
    }
    
}
