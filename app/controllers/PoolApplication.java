package controllers;

import models.Pool;
import play.mvc.Controller;
import views.html.add_pool;
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



        return ok(add_pool.render());

    }
}
