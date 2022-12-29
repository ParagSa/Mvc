package com.parag.serv;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class uploadServlet
 */
@WebServlet("/uploadServlet")
@MultipartConfig
public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part part = request.getPart("image");
		ServletContext sc = request.getServletContext();
		String path = sc.getRealPath("image");
		Path path2 = Paths.get(path);
		if(!Files.exists(path2)) {
			Files.createDirectories(path2);
		}
		String filename = part.getSubmittedFileName();
		path2 = path2.resolve(filename);
		Files.copy(part.getInputStream(), path2, StandardCopyOption.REPLACE_EXISTING);
		response.sendRedirect("loggedIn.jsp");
	}

}
