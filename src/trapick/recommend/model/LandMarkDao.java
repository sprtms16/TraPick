package trapick.recommend.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import trapick.recommend.domain.LandMark;
import trapick.recommend.mapper.LandMarkMapper;

public class LandMarkDao {

	private static LandMarkDao dao = new LandMarkDao();
	
	public static LandMarkDao getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		
		String resource = "mybatis-config.xml";
		 InputStream in = null;
		 
		 try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new SqlSessionFactoryBuilder().build(in);
		
	}
	
	public List<LandMark> listLandMark(String city_name){
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<LandMark> list_Land = new ArrayList<>();
		
		try {
			list_Land = sqlSession.getMapper(LandMarkMapper.class).listLandMark(city_name);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list_Land;
		
	}
	
}
