package Service;

import models.Pool;
import models.User;
import org.openstack4j.api.OSClient;
import org.openstack4j.api.compute.ComputeService;
import org.openstack4j.model.compute.Server;
import org.openstack4j.openstack.OSFactory;

import java.util.List;

/**
 * Created by jeffy on 2015/5/1 0001.
 */
public class ServerService {

    public static List<Server> getServers(Integer poolId) {

        ComputeService client = getClient(poolId);

        List<Server> servers = (List<Server>) client.servers().list();

        return servers;

    }

    public static ComputeService getClient(Integer poolId) {

        Pool pool = Pool.find.byId(poolId);
        List<User> userList = (List<User>) User.find.where().eq("poolId", poolId).findList();
        User user = userList.get(0);

        OSClient client = OSFactory.builder()
                .endpoint(String.format("http://%s:%s/%s", pool.host, pool.port, pool.version))
                .credentials(user.userName, user.password)
                .tenantName(user.tenantName)
                .authenticate();

        return client.compute();

    }

}
