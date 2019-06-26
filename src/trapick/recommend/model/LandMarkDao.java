package trapick.recommend.model;

import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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

	public Connection getConnection() {
		DataSource ds = null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LandMark> landMarkList(String city_name) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<LandMark> list = null;
		try {
			list = sqlSession.selectList("trapick.recommend.mapper.LandMarkMapper.landMarkList", city_name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

	public List<String> cityList(String country_name) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<String> list = null;
		try {
			list = sqlSession.selectList("trapick.recommend.mapper.LandMarkMapper.cityList", country_name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

	public void saveSchedule(Map<String, String> map) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.insert("trapick.recommend.mapper.LandMarkMapper.saveSchedule", map);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public List<LandMark> listLandMark(String city_name) {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<LandMark> list_Land = new ArrayList<>();

		try {
			list_Land = sqlSession.getMapper(LandMarkMapper.class).listLandMark(city_name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list_Land;

	}

}
