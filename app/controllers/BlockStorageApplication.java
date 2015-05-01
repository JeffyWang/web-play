package controllers;

import Service.BlockStorageService;
import models.Pool;
import org.openstack4j.model.storage.block.Volume;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.block_storage_info;

import java.util.List;

/**
 * Created by jeffy on 2015/4/29 0029.
 */
public class BlockStorageApplication  extends Controller {

    public static Result getBlockStorage(Integer poolId) {

        List<Volume> volumes = BlockStorageService.getVolumes(poolId);
        Pool pool = Pool.find.byId(poolId);

        return ok(block_storage_info.render(volumes, pool));

    }

}
