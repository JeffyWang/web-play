package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Jeffy on 2015/4/29 0029.
 */

@Entity
public class User extends Model{

    @Id
    public int id;

    public String user_name;

    public String password;
}
