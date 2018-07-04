package org.edi.stocktask.mapper;

import org.edi.initialfantasy.bo.userauthrization.UserAuth;

/**
 * Created by asus on 2018/7/4.
 */
public interface UserAuthMapper {
    UserAuth serchAuthByToken(String token);
}
