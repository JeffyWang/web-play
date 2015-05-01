package controllers;

import Service.NetworkService;
import models.Pool;
import org.openstack4j.model.network.Network;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.networks_info;

import java.util.List;

/**
 * Created by jeffy on 2015/4/29 0029.
 */
public class NetworkApplication  extends Controller {

    public static Result getNetworks(Integer poolId) {

        List<Network> networkList = NetworkService.getNetworks(poolId);
        Pool pool = Pool.find.byId(poolId);

        return ok(networks_info.render(networkList, pool));

    }

}
