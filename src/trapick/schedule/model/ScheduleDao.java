package trapick.schedule.model;

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

import trapick.schedule.domain.Country;

public class ScheduleDao {
	private static ScheduleDao dao = new ScheduleDao();

	public static ScheduleDao getInstance() {
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

	public List<Country> listCountry() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Country> list = null;
		try {
			list = sqlSession.selectList("trapick.schedule.mapper.selectCountry");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.clearCache();
			}
		}
		return list;
	}
	
	public List<String> listCity(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<String> list = null;
		try {
			list = sqlSession.selectList("trapick.schedule.mapper.selectCity");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.clearCache();
			}
		}
		return list;
	}

}