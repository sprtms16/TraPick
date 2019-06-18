package trapick.feed.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import trapick.feed.domain.Feed;
import trapick.feed.domain.Heart;
import trapick.feed.mapper.FeedMapper;

public class FeedDao {
	private static FeedDao dao = new FeedDao();
	
	public static FeedDao getInstance(){
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource =  "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}

	public int insertFeed(Feed feed) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(FeedMapper.class).insertFeed(feed);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return re;
	}

	public List<Feed> feedList() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Feed> list = null;
		try {
			list = sqlSession.getMapper(FeedMapper.class).feedList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Feed feedUpdate(int feed_idx) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Feed feed = new Feed();
		try {
			feed = sqlSession.getMapper(FeedMapper.class).getFeed(feed_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feed;
	}

	public int updateFeedHeart(Heart heart) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(FeedMapper.class).updateFeedHeart(heart);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	public int deleteFeed(int feed_idx) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(FeedMapper.class).deleteFeed(feed_idx);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	public Feed updateFeed(int feed_idx) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Feed feed = new Feed();
		try {

			feed = sqlSession.getMapper(FeedMapper.class).updateFeed(feed_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feed;

	}

	public int updateFeedAction(Feed feed) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(FeedMapper.class).updateFeedAction(feed);
			// 트랜잭션 == 하나의 작업단위 를 체크해줘야함 다 성공하든지 다 실패하든지
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	
}
