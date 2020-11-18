/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.controller;

import com.empresa.proyecto.ws.AsignaturaWebService_Service;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author crist
 */
public class ClienteServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WS001/AsignaturaWebService.wsdl")
    private AsignaturaWebService_Service service;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Gson gson = new Gson();
            String jsonString = gson.toJson(listarAsignaturas());
            response.setContentType("application/json");
            response.getWriter().write(jsonString);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String nombreAsignatura = request.getParameter("nombreAsignatura");
            crearAsignaturas(nombreAsignatura);
            response.setContentType("text/plain");
            response.getWriter().write("Datos ingresados con exito");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String crearAsignaturas(java.lang.String nombreAsignatura) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.empresa.proyecto.ws.AsignaturaWebService port = service.getAsignaturaWebServicePort();
        return port.crearAsignaturas(nombreAsignatura);
    }

    private java.util.List<com.empresa.proyecto.ws.Asignatura> listarAsignaturas() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.empresa.proyecto.ws.AsignaturaWebService port = service.getAsignaturaWebServicePort();
        return port.listarAsignaturas();
    }

    
    
    
}
