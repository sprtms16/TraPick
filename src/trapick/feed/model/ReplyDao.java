package trapick.feed.model;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

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

	public List<Reply> listReply(Map<String, Object> param) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Reply> list = null;
		try {
			list = sqlSession.getMapper(ReplyMapper.class).listReply(param);
			System.out.println(list);
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

	public int selectReplyLikeCheck(ReplyLike replyLike) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int heartCount = -1;
		try {
			heartCount = sqlSession.getMapper(ReplyMapper.class).selectReplyLikeCheck(replyLike);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return heartCount;
	}

	public int deleteReplyLike(ReplyLike replyLike) {
		// TODO Auto-generated method stub
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReplyMapper.class).deleteReplyLike(replyLike);
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

	public int selectReplyLikeCount(int reply_idx) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int heartCount = -1;
		try {
			heartCount = sqlSession.getMapper(ReplyMapper.class).selectReplyLikeCount(reply_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return heartCount;
	}

	public int insertReplyLike(ReplyLike replyLike) {
		// TODO Auto-generated method stub
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReplyMapper.class).insertReplyLike(replyLike);
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

	public int selectReplyDislikeCheck(ReplyDislike replyDislike) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int heartCount = -1;
		try {
			heartCount = sqlSession.getMapper(ReplyMapper.class).selectReplyDislikeCheck(replyDislike);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return heartCount;
	}

	public int deleteReplyDislike(ReplyDislike replyDislike) {
		// TODO Auto-generated method stub
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReplyMapper.class).deleteReplyDislike(replyDislike);
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

	public int selectReplyDislikeCount(int reply_idx) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int heartCount = -1;
		try {
			heartCount = sqlSession.getMapper(ReplyMapper.class).selectReplyDislikeCount(reply_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return heartCount;
	}

	public int insertReplyDislike(ReplyDislike replyDislike) {
		// TODO Auto-generated method stub
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReplyMapper.class).insertReplyDislike(replyDislike);
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
