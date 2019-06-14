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
import trapick.feed.action.InsertAction;
import trapick.feed.action.InsertFormAction;
import trapick.feed.action.insertActionReply;
import trapick.feed.action.listAction;
import trapick.feed.action.updateFormAction;

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
		System.out.println(commend);
		if (commend.equals("feed/feedInsertForm")) {
			action = new InsertFormAction();
		} else if (commend.equals("feed/insertAction")) {
			action = new InsertAction();
		}else if(commend.equals("feed/list")){
			action =  new listAction();
		}else if(commend.equals("feed/updateForm")){
			action = new updateFormAction();
		}else if(commend.equals("feed/insertActionReply")){
			action = new insertActionReply();
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
