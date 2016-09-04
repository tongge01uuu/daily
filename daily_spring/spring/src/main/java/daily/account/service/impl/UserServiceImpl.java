package daily.account.service.impl;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import daily.account.common.domain.User;
import daily.account.dao.mapper.UserMapper;
import daily.account.service.UserService;

public class UserServiceImpl implements UserService
{
	Log log=LogFactory.getLog(UserServiceImpl.class);
	@Setter @Getter private UserMapper userMapper;
	public void add(User record)
	{
		userMapper.insert(record);
	}

	
	public void delete(Integer id)
	{
		
	}

	
	public void update(User user)
	{
		
	}

	
	public List<User> query()
	{
		return null;
	}

}
