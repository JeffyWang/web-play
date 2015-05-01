package Service;

import models.Pool;
import models.User;
import org.openstack4j.api.OSClient;
import org.openstack4j.api.compute.ComputeService;
import org.openstack4j.model.storage.block.Volume;
import org.openstack4j.openstack.OSFactory;

import java.util.List;

/**
 * Created by jeffy on 2015/5/1 0001.
 */
public class BlockStorageService {

    public static List<Volume> getVolumes(Integer poolId) {

        org.openstack4j.api.storage.BlockStorageService client = getClient(poolId);

        List<Volume> volumes = (List<Volume>) client.volumes().list();

        return volumes;

    }

    public static org.openstack4j.api.storage.BlockStorageService getClient(Integer poolId) {

        Pool pool = Pool.find.byId(poolId);
        List<User> userList = (List<User>) User.find.where().eq("poolId", poolId).findList();
        User user = userList.get(0);

        OSClient client = OSFactory.builder()
                .endpoint(String.format("http://%s:%s/%s", pool.host, pool.port, pool.version))
                .credentials(user.userName, user.password)
                .tenantName(user.tenantName)
                .authenticate();

        return client.blockStorage();

    }

}
