package daily.account.service;

import java.util.List;

import daily.account.common.domain.User;

public interface UserService
{
	public void add(User record);
	public void delete(Integer id);
	public void update(User user);
	public List<User> query();
}
