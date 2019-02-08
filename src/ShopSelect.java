import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class ShopSelect
 */
@WebServlet("/ShopSelect")
public class ShopSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopSelect() {
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
		Pregunta pregunta = new Pregunta();
		if (request.getParameterMap().containsKey("answer")) {
			String answer = request.getParameter("answer");
			HttpSession session = request.getSession();
			System.out.println(session.getId()+"\n");
			Pregunta next = (Pregunta)session.getAttribute("pregunta");
            //pregunta = pregunta.parseFromAnswer(answer);
			//pregunta = pregunta.parseFromAnswer(answer);
            System.out.println(next+"\n");
            System.out.println(next.getLabel()+"\n");
		} else {
    		pregunta = pregunta.parsePrimeraPregunta();
		}
		if(pregunta.getQuestion()=="null") {
			System.out.print("hola");
			request.setAttribute("answer", "hola");
			RequestDispatcher view = request.getRequestDispatcher("question.jsp");
			view.forward(request, response);
		} else {
			request.setAttribute("pregunta", pregunta);
			RequestDispatcher view = request.getRequestDispatcher("question.jsp");
			view.forward(request, response);
		}
	}
}
