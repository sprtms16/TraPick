package trapick.recommend.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.recommend.domain.LandMark;
import trapick.recommend.service.RecommendService;

public class LandMarkListAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      RecommendService service = RecommendService.getInstance();
      ActionForward forward = new ActionForward();
      
      List<LandMark> list_Land = service.listLandMarkService(request);
      
      request.setAttribute("list_Land", list_Land);
            
      forward.setRedirect(false);      
      
      return forward;
   }

}