package trapick.recommend.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.recommend.action.Action;
import trapick.recommend.action.ActionForward;
import trapick.recommend.action.HotelAjaxAction;
import trapick.recommend.action.ItemListAction;
import trapick.recommend.action.ItemListAjaxAction;
import trapick.recommend.action.LandMarkListAction;
import trapick.recommend.action.ListSortAction;
import trapick.recommend.action.RestAjaxAction;
import trapick.recommend.action.SaveScheduleAction;

@WebServlet("/Recommend/*")
public class RecommendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecommendController() {
		super();
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);

		System.out.println(command);
		Action action = null;
		
		ActionForward forward = null;

		if(command.equals("Recommend/itemList")) {
			action = new ItemListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("Recommend/sortList")) {
			action = new ListSortAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("Recommend/sortDist")) {
			action = new ListSortAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("Recommend/landMarkAjax")) {
			action = new LandMarkListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("Recommend/itemAjax")) {
			action = new ItemListAjaxAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("Recommend/saveAjax")) {
			action = new SaveScheduleAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("Recommend/restAjax")) {
	         action = new RestAjaxAction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	    }else if (command.equals("Recommend/hotelAjax")) {
	         action = new HotelAjaxAction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	    }
		
		
		if(forward!=null)
		{
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doProcess(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doProcess(request, response);
		}
		
	}
	