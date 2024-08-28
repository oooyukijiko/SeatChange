
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Seat;


@WebServlet("/UserInputServlet")
public class UserInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		int headcount = 14;
		Seat seat = new Seat(headcount);
		
		ServletContext application = config.getServletContext();
		application.setAttribute("seat", seat);
		
		StudentDAO sql = new StudentDAO();
		for(int i = 1; i < 15; i++) {
			sql.Set_Name_SQL(i, null);
			sql.Set_Seat_SQL(i, null);
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userInputForm.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Integer studentNum = Integer.parseInt(request.getParameter("studentNum"));
		String name = request.getParameter("name");
		ServletContext application = this.getServletContext();
		Seat seat = (Seat)application.getAttribute("seat"); 
		
		StudentDAO sql = new StudentDAO();
		
		if(sql.ConfirmationOfExistence(name) == 0) {
			sql.Set_Name_SQL(studentNum, name);
			int seatNum = 0;
			while(sql.ConfirmationOfExistence(seatNum) == 0) {
				seatNum = seat.seatchange();
				sql.Set_Seat_SQL(studentNum, seatNum);
			}
			
			for(int i = 0; i < seat.getSeat().length; i++) {
				for(int j = 0; j < seat.getSeat()[0].length; j++) {
					if(seat.getSeat()[i][j].equals(String.valueOf(seatNum))) {
						seat.getSeat()[i][j] = name;
					}
				}
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/seatChangeResult.jsp");
		dispatcher.forward(request, response);
	}

}

