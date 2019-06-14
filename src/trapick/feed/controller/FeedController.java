package trapick.feed.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.feed.action.Action;
import trapick.feed.action.ActionForward;
import trapick.feed.action.ErrorAction;
import trapick.feed.action.FeedFormAction;
import trapick.feed.action.InsertFormAction;

@WebServlet("/feed/*")
public class FeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FeedController() {
		super();

	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String commend = requestURI.substring(contextPath.length() + 1);

		Action action = null;
		ActionForward forward = null;

		if (commend.equals("feed/feedInsertForm")) {
			action = new InsertFormAction();
		} else if (commend.equals("feed/feedform")) {
			System.out.println(commend);
			action = new FeedFormAction();
		} else {
			action = new ErrorAction();
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
