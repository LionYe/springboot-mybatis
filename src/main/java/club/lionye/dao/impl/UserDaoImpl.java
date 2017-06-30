package club.lionye.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import club.lionye.dao.UserDao;
import club.lionye.entity.User;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public User queryByuserName(String username) {
		return sqlSession.selectOne("UserInfo.queryByuserName", username);
	}

	
}
