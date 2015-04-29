package controllers;

import models.Pool;
import persistent.PoolPersistence;
import play.db.ebean.Model;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by jeffy on 2015/4/29 0029.
 */
public class PoolApplication  extends Controller {
    public static PoolPersistence poolPersistence = new PoolPersistence();

    public static Result getPools() {

//        List<Pool> pools = new Model.Finder(String.class, Pool.class).all();
        List<Pool> pools = null;
        try {
            pools = poolPersistence.getAll();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ok(Json.toJson(pools));
    }
}
