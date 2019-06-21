package trapick.recommend.model;


import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import trapick.recommend.domain.LandMark;
import trapick.schedule.domain.Country;
import trapick.schedule.mapper.ScheduleMapper;

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
			list = sqlSession.selectList("trapick.recommend.mapper.LandMarkMapper.landMarkList",city_name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

	

}
