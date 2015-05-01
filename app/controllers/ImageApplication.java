package controllers;

import Service.ImageService;
import models.Pool;
import org.openstack4j.model.image.Image;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.images_info;

import java.util.List;

/**
 * Created by jeffy on 2015/4/29 0029.
 */
public class ImageApplication  extends Controller {

    public static Result getImages(Integer poolId) {

        List<Image> imageList = ImageService.getImages(poolId);
        Pool pool = Pool.find.byId(poolId);

        return ok(images_info.render(imageList, pool));

    }

}
