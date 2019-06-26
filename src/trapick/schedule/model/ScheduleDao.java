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
import trapick.schedule.mapper.ScheduleMapper;

public class ScheduleDao {
	private static final String City_Ename = null;
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
			// list =
			// sqlSession.selectList("trapick.schedule.mapper.selectCountry");
			list = sqlSession.getMapper(ScheduleMapper.class).selectCountry();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

	public List<String> listCity(String country_name) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<String> list = null;
		try {
			// list =
			// sqlSession.selectList("trapick.schedule.mapper.selectCity",
			// country_name);
			list = sqlSession.getMapper(ScheduleMapper.class).selectCity(country_name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

	public String startDate(String idx) {
		// TODO Auto-generated method stub

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String date = null;
		try {
			// list =
			// sqlSession.selectList("trapick.schedule.mapper.selectCity",
			// country_name);
			date = sqlSession.getMapper(ScheduleMapper.class).selectStartDate(idx);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return date;
	}

	public List<String> listCountryIso() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<String> list = null;
		try {
			// list =
			// sqlSession.selectList("trapick.schedule.mapper.selectCity",
			// country_name);
			list = sqlSession.getMapper(ScheduleMapper.class).selectcountryiso();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

	public String selectCountryISO(String country_name) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String iso = null;
		try {
			// list =
			// sqlSession.selectList("trapick.schedule.mapper.selectCity",
			// country_name);
			iso = sqlSession.getMapper(ScheduleMapper.class).selectCountryIso(country_name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return iso;
	}

	public String selectCityEname(String city_Ename) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String ename = null;
		try {
			ename = sqlSession.getMapper(ScheduleMapper.class).selectCityEname(city_Ename);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
			/* System.out.println("dao:" + ename + " param city_Ename:" + city_Ename); */
		}
		return ename;
	}

}
