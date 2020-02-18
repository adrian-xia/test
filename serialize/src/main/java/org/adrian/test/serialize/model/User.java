package org.adrian.test.serialize.model;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -3838250918516778666L;

    private String username;
    private String password;
    private String idCard;
    private String phone;
    private String email;
    private List<User> friends;

    public static User generate() {
        List<User> friends = Lists.newArrayList();
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setIdCard("idCard");
        user.setPhone("phone");
        user.setEmail("email");
        user.setFriends(friends);
        User friend1 = new User();
        friends.add(friend1);
        friend1.setUsername("username");
        friend1.setPassword("password");
        friend1.setIdCard("idCard");
        friend1.setPhone("phone");
        friend1.setEmail("email");
        User friend2 = new User();
        friends.add(friend2);
        friend2.setUsername("username");
        friend2.setPassword("password");
        friend2.setIdCard("idCard");
        friend2.setPhone("phone");
        friend2.setEmail("email");
        User friend3 = new User();
        friends.add(friend3);
        friend3.setUsername("username");
        friend3.setPassword("password");
        friend3.setIdCard("idCard");
        friend3.setPhone("phone");
        friend3.setEmail("email");
        return user;
    }
}
