package trapick.feed.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import trapick.feed.domain.Reply;
import trapick.feed.domain.ReplyDislike;
import trapick.feed.domain.ReplyLike;
import trapick.feed.mapper.FeedMapper;
import trapick.feed.mapper.ReplyMapper;

public class ReplyDao {
	private static ReplyDao replyDao = new ReplyDao();

	public static ReplyDao getInstance() {
		return replyDao;
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

	public int insertReply(Reply reply) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(ReplyMapper.class).insertReply(reply);
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

	public List<Reply> listReply(int feed_idx) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Reply> list = null;
		try {
			list = sqlSession.getMapper(ReplyMapper.class).listReply(feed_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	
	}

	public int updateReplyLike(ReplyLike replyLike) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(ReplyMapper.class).updateReplyLike(replyLike);
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

	public int updateReplyDislike(ReplyDislike replyDislike) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(ReplyMapper.class).updateReplyDislike(replyDislike);
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
