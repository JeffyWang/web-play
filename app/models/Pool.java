package models;

import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jeffy on 2015/4/29 0029.
 */

@Entity
public class Pool extends Model{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
    public Date createDate = new Date();

    @Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
    public Date updateDate = new Date();

    public String poolName;

    public String host;

    public Integer port;

    public String version;

    public static Finder<Integer,Pool> find = new Finder<Integer,Pool>(
            Integer.class, Pool.class
    );

}
