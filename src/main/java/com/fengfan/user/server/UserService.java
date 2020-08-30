package com.fengfan.user.server;

import com.fengfan.user.dao.UserDetailMapper;
import com.fengfan.user.pojo.UserDetail;
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
