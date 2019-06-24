package trapick.recommend.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import trapick.recommend.domain.Item;
import trapick.recommend.service.RecommendService;

public class SearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RecommendService service = RecommendService.getInstance();
		ActionForward forward = new ActionForward();
		
		List<Item> list = service.ItemListService(request, response);
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		
		for(int i=0; i<list.size();i++) {
			jsonObject.put("name", list.get(i).getName());
			jsonObject.put("latitude", list.get(i).getLatitude());
			jsonObject.put("longitude", list.get(i).getLongitude());
			jsonObject.put("detail", list.get(i).getDetail());
			jsonObject.put("img", list.get(i).getImg());
			jsonObject.put("sales", list.get(i).getSales());
			jsonObject.put("hits", list.get(i).getHits());
			
			jsonArray.add(jsonObject);
			
			System.out.println(jsonArray);
		}
		
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		
		return forward;
	}

}
