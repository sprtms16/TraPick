package trapick.schedule.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.schedule.action.Action;
import trapick.schedule.action.ActionForward;
import trapick.schedule.action.CityListAction;
import trapick.schedule.action.CountryListAction;
import trapick.schedule.action.SelectCountryAction;
import trapick.schedule.action.getStartDateAction;

@WebServlet("/Schedule/*")
public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScheduleController() {
		super();
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURL.substring(contextPath.length() + 1);

		Action action = null;
		ActionForward forward = null;
		System.out.println(command);
		if (command.equals("Schedule/main")) {
			action = new SelectCountryAction();
		} else if (command.equals("Schedule/country")) {
			action = new CountryListAction();
		} else if (command.equals("Schedule/city")) {
			action = new CityListAction();
		}
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}