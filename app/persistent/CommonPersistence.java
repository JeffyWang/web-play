package persistent;

import play.db.ebean.Model;

import java.util.List;

/**
 * Created by jeffy on 2015/4/29 0029.
 */
public class CommonPersistence {

    public String className = "";

    public CommonPersistence(String className) {
        this.className = className;
    }

    public List getAll() throws ClassNotFoundException {
        return new Model.Finder(String.class, Class.forName(className)).all();
    }

}
