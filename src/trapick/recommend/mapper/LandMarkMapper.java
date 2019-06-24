package trapick.recommend.mapper;

import java.util.List;

import trapick.recommend.domain.LandMark;

public interface LandMarkMapper {

   List<LandMark> listLandMark(String city_name);
   
}