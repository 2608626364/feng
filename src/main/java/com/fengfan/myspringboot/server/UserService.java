package com.fengfan.myspringboot.server;

import com.fengfan.myspringboot.dao.UserDetailMapper;
import com.fengfan.myspringboot.pojo.UserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService  implements UserDetailsService {
    @Resource
    private UserDetailMapper userDetailMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetail user = new UserDetail();
        user.setUserName(username);
        List<UserDetail> details = userDetailMapper.selectAll();

        UserDetail userDetail = userDetailMapper.selectByUserDetail(user);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }

        return null;
    }
}
