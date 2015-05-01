package controllers;

import Service.ServerService;
import models.Pool;
import org.openstack4j.model.compute.Server;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.servers_info;

import java.util.List;

/**
 * Created by jeffy on 2015/4/29 0029.
 */
public class ServerApplication  extends Controller {

    public static Result getServers(Integer poolId) {

        List<Server> serverList = ServerService.getServers(poolId);
        Pool pool = Pool.find.byId(poolId);

        return ok(servers_info.render(serverList, pool));

    }

}
