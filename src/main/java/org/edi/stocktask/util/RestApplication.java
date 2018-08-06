package org.edi.stocktask.util;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.edi.initialfantasy.filter.RequestFilter;
import org.glassfish.jersey.server.ResourceConfig;



/**
 * @author Fancy
 * @date 2018/6/1
 */
public class RestApplication extends ResourceConfig {
    public RestApplication() {

        //服务类所在的包路径
        packages("org.edi.stocktask.service");
        packages("org.edi.initialfantasy.filter");
        //注册JSON转换器
        register(JacksonJsonProvider.class);
        register(RequestFilter.class);

    }
}
