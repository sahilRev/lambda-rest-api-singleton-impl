package org.consultadd;

import org.consultadd.controller.UserController;
import org.consultadd.lambdarestapi.singleton.enums.HttpMethod;
import org.consultadd.lambdarestapi.singleton.model.Request;
import org.consultadd.lambdarestapi.singleton.utils.BeanContext;
import org.consultadd.lambdarestapi.singleton.utils.RequestContext;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        //Bootstrap request
        Request request = new Request();
        request.setMethod(HttpMethod.GET);
        request.setPath("/user");
        request.setApiData(new HashMap<>());

        //GET user controller bean (Singleton)
        BeanContext beanContext = BeanContext.getInstance();
        UserController userController = (UserController) beanContext.getBean(UserController.class);

        //GET user
        System.out.println(userController.handle(request, new RequestContext()));

        //PUT user
        request.setMethod(HttpMethod.PUT);
        System.out.println(userController.handle(request, new RequestContext()));

        //POST user
        request.setMethod(HttpMethod.POST);
        System.out.println(userController.handle(request, new RequestContext()));

        //DELETE user
        request.setMethod(HttpMethod.DELETE);
        System.out.println(userController.handle(request, new RequestContext()));
    }
}