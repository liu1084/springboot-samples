package com.jim.data.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: Jim
 * Date: 2018/8/3:下午4:12
 * Description:
 * <p>
 * `name` varchar(150) NOT NULL DEFAULT '',
 * `email` varchar(50) NOT NULL DEFAULT '',
 * `phone` varchar(50) NOT NULL DEFAULT '',
 * `password` varchar(300) NOT NULL DEFAULT '',
 * `is_enabled` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '0:不可用 1:可用',
 * `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:个人用户，以手机为登录凭证 2:企业用户，以邮箱为登录凭证',
 * `activated` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否激活（0-未激活，1-已激活）',
 * `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
 * `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 */
@Entity
@Data
@Table(name = "pms_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String password;

    private int isEnabled;

    private int type;

    private int activated;

    private Date createTime;

    private Date updateTime;
}
