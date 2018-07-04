package org.edi.stocktask.util;

import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.stocktask.mapper.UserAuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by asus on 2018/7/4.
 */

@Component(value="tokenVerification")
public class TokenVerification {
    @Autowired
    private UserAuthMapper userAuthMapper;

    public  String verification(String token){
        String verificationMsg = "";
        if(token!=null&&!token.equals("")){
            UserAuth userAuth = userAuthMapper.serchAuthByToken(token);
            if(userAuth!=null){
                if(userAuth.getIsActive().trim().equals("Y")){
                    verificationMsg = "ok";
                }else{
                    verificationMsg = "the user is not logged in";
                }
            }else{
                verificationMsg = "the token is not exist";
            }
        }else{
            verificationMsg = "the token is null ";
        }
        return verificationMsg;
    }

}
