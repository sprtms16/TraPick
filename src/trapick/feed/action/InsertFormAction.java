package trapick.feed.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception  {

		ActionForward forward = new ActionForward();
		request.setAttribute("schd_idx", request.getParameter("schd_idx"));
		forward.setRedirect(false);
		forward.setPath("/insert_form.jsp");
		return forward;
	}

}
