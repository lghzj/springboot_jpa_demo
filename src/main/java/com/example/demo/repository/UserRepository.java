package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lgh
 * @create 2018/04/04
 **/
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String username);

	User findByUserNameOrEmail(String username, String email);

	/**
	 * 更新修改操作如果不添加事物会报错（javax.persistence.TransactionRequiredException: Executing an update/delete query）
	 * @param username
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying
	@Query("update User u set u.userName= ?1 where u.id= ?2")
	int modifyByIdAndUserName(String username, Long id);
}
