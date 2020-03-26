package com.tzj.service.dao.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author TianZiJiang
 * @date 2020-03-26
 */
@Getter
@Setter
@ToString
public class UserDO {

    private String userName;

    private String password;

    private String userId;

    private String phone;

    private String age;

    private String gender;

    private String address;
}
