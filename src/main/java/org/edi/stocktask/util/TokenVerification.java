package org.edi.stocktask.util;

import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.util.CharsetConvert;
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

    public  String verification(String token) {
        String verificationMsg = "";
        try{
            if(token!=null&&!token.equals("")){
                UserAuth userAuth = userAuthMapper.serchAuthByToken(token);
                if(userAuth!=null){
                    if(userAuth.getIsActive().trim().equals("Y")){
                        verificationMsg = "ok";
                    }else{
                        verificationMsg = "用户未登录！";
                    }
                }else{
                  verificationMsg = "token不存在！";
                }
            }else{
                verificationMsg = "token为空!";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return CharsetConvert.convert(verificationMsg);
    }

}
