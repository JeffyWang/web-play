package controllers;

import Service.ServerService;
import models.Pool;
import models.User;
import org.openstack4j.model.compute.Server;
import play.data.Form;
import play.mvc.Controller;
import views.html.index;
import views.html.pool_detail;
import views.html.pools;
import play.mvc.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jeffy on 2015/4/29 0029.
 */
public class PoolApplication  extends Controller {

    public static Result getPools() {

        List<models.Pool> poolList = Pool.find.all();

        return ok(pools.render(poolList));

    }

    public static Result addPool() {

        Pool pool = Form.form(Pool.class).bindFromRequest().get();
        pool.save();
        User user = new User();
        user.poolId = pool.id;
        user.save();

        return ok(index.render());

    }

    public static Result getPool(Integer poolId) {

        Pool pool = Pool.find.byId(poolId);

        return ok(pool_detail.render(pool));

    }
}
