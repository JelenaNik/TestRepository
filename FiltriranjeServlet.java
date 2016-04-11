package servleti;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.SlikaManager;
import model.Picture;

/**
 * Servlet implementation class FiltriranjeServlet
 */
public class FiltriranjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltriranjeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SlikaManager sm = new SlikaManager();
		String author = request.getParameter("author");
		String age = request.getParameter("age");
		String direction  = request.getParameter("direction");
		String pictureName = request.getParameter("pictureName");
		
		
		
		List<Picture> list = sm.getAllPictures();
	    request.setAttribute("list", list);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/Filtriranje.jsp");
		rd.forward(request, response);
		
	}

}
