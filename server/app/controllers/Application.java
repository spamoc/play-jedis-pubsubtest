package controllers;

import play.*;
import play.mvc.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import views.html.*;

public class Application extends Controller {
  
    protected final static JedisPool pool;
    static{
        String host = "127.0.0.1";
        int port = 6379;
        pool = new JedisPool(new JedisPoolConfig(), host, port);
    }
    public static Result index() {
        Jedis client = pool.getResource();
        return ok(index.render("Your new application is ready."));
    }
  
}
