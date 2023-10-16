package org.consultadd.controller;


import org.consultadd.lambdarestapi.singleton.funtionalInterfaces.AbstractRestApiController;
import org.consultadd.lambdarestapi.singleton.model.Request;
import org.consultadd.lambdarestapi.singleton.model.Response;
import org.consultadd.lambdarestapi.singleton.utils.BeanContext;
import org.consultadd.lambdarestapi.singleton.utils.RequestContext;
import org.consultadd.service.UserService;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class UserController implements AbstractRestApiController {

    private UserService userService;

    public UserController() throws InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchMethodException {
        this.userService = (UserService) BeanContext.getInstance().getBean(UserService.class);
    }

    @Override
    public Response doGet(Request request, RequestContext requestContext) {
        //check path
        Response response = new Response();
        response.setApiData(Map.of("apiCalled", "GET"));
        return response;
    }

    @Override
    public Response doPut(Request request, RequestContext requestContext) {
        Response response = new Response();
        response.setApiData(Map.of("apiCalled", "PUT"));
        return response;
    }

    @Override
    public Response doPost(Request request, RequestContext requestContext) {
        Response response = new Response();
        response.setApiData(Map.of("apiCalled", "POST"));
        return response;
    }

    @Override
    public Response doDelete(Request request, RequestContext requestContext) {
        Response response = new Response();
        response.setApiData(Map.of("apiCalled", "DELETE"));
        return response;
    }
}
