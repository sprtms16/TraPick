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
import trapick.feed.action.InsertAction;
import trapick.feed.action.InsertFormAction;
import trapick.feed.action.deleteFeedAction;
import trapick.feed.action.heartAction;
import trapick.feed.action.insertActionReply;
import trapick.feed.action.listAction;
import trapick.feed.action.replyDislikeAction;
import trapick.feed.action.replyLikeAction;
import trapick.feed.action.updateFeedAction;
import trapick.feed.action.updateFeedFormAction;
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
		String command = requestURI.substring(contextPath.length() + 1);

		Action action = null;
		ActionForward forward = null;
		System.out.println(command);
		System.out.println(request.getSession().getAttribute("user_idx"));
		if (command.equals("feed/feedInsertForm")) {
			action = new InsertFormAction();
		} else if (command.equals("feed/insertAction")) {
			action = new InsertAction();
		} else if (command.equals("feed/list")) {
			action = new listAction();
		} else if (command.equals("feed/insertActionReply")) {
			action = new insertActionReply();
		} else if (command.equals("feed/replyLikeAction")) {
			action = new replyLikeAction();
		} else if (command.equals("feed/replyDislikeAction")) {
			action = new replyDislikeAction();
		} else if (command.equals("feed/hearAction")) {
			action = new heartAction();
		} else if (command.equals("feed/deleteFeedAction")) {
			action = new deleteFeedAction();
		}else if (command.equals("feed/updateForm")) {
			action = new updateFeedFormAction();
		}else if (command.equals("feed/updateFeedAction")) {
			action = new updateFeedAction();
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
