package trapick.recommend.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.nodes.Document;

import net.sf.json.JSONArray;
import trapick.recommend.domain.Item;
import trapick.recommend.service.RecommendService;

public class ItemAjaxAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      RecommendService service = RecommendService.getInstance();
      ActionForward forward = new ActionForward();
      
      List<Item> list = service.ItemListService(request, response);
            
      JSONArray jsonArray = JSONArray.fromObject(list);

      response.setContentType("text/html;charset=UTF-8");
      response.getWriter().print(jsonArray);            
      
      return null;
   }

}