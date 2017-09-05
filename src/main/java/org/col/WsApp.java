package org.col;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.col.config.WsConfig;
import org.col.db.MybatisBundle;
import org.col.resources.NameResource;
import org.col.tasks.hello.HelloTask;

public class WsApp extends Application<WsConfig> {

    public static void main(final String[] args) throws Exception {
        new WsApp().run(args);
    }

    @Override
    public String getName() {
        return "Taxonomic Clearing House";
    }

    @Override
    public void initialize(final Bootstrap<WsConfig> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(new MybatisBundle());
    }

    @Override
    public void run(final WsConfig config, final Environment environment) {
        // db
        //final DBIFactory factory = new DBIFactory();
        //final DBI jdbi = factory.build(environment, config.db.pool(), "postgresql");
        //final UserDAO dao = jdbi.onDemand(UserDAO.class);

        // resources
        environment.jersey().register(new NameResource());

        // tasks
        environment.admin().addTask(new HelloTask());


    }

}
