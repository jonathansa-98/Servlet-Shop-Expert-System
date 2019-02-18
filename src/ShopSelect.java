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
		RequestDispatcher view;
		if (!request.getParameterMap().containsKey("answer")) {
			// 1st time
    		pregunta = pregunta.parsePrimeraPregunta();
		} else {
			// treat the next question
			HttpSession session = request.getSession();
			// get the answer pos [0,1,2...].
			String answer = request.getParameter("answer");
			// get the actual question
			Pregunta next = (Pregunta)session.getAttribute("pregunta");
            pregunta = next.parseFromAnswer(answer);
            System.out.println(pregunta.getQuestion()+"\n");
		}
		request.setAttribute("pregunta", pregunta);
		if(pregunta.getChildren()!=null) {
			// keep asking
			view = request.getRequestDispatcher("question.jsp");			
		} else {
			// finds a definitive answer.
			view = request.getRequestDispatcher("result.jsp");
		}
		view.forward(request, response);
	}
}
