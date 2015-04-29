package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Server;
import org.openstack4j.openstack.OSFactory;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result users() {
        List<User> users = new Model.Finder(String.class, User.class).all();

        return ok(toJson(users));
    }

    public static Result addUser() {
        User user = Form.form(User.class).bindFromRequest().get();
        user.save();
        return ok(toJson(user));
    }

    public static Result test() {
        JsonNode json = request().body().asJson();


        return ok(json);

    }

    public static Result getServers() {
        OSClient OS = OSFactory.builder()
                .endpoint("http://172.16.12.15:5000/v2.0")
                .credentials("admin","admin")
                .tenantName("admin")
                .authenticate();

        List<Server> servers = (List<Server>) OS.compute().servers().list();
        List<models.Server> serverList = new ArrayList<models.Server>();
        for (Server s : servers) {
            models.Server server = new models.Server();
            server.name = s.getName();
            serverList.add(server);
        }

        return ok(server.render(serverList));
    }

    public static Result testString(String s) {
        return ok(s);
    }

    public static Result params(String s) {
        String p1 = request().getQueryString("p1");

        return ok(s);
    }
}
