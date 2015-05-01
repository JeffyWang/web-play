package models;

import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Jeffy on 2015/4/29 0029.
 */

@Entity
public class User extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
    public Date createDate = new Date();

    @Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
    public Date updateDate = new Date();

    public String userName = "admin";

    public String password  = "admin";

    public String tenantName  = "admin";

    public Integer poolId;

    public static Finder<Integer,User> find = new Finder<Integer,User>(
            Integer.class, User.class
    );

}
