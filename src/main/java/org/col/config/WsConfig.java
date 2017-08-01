package org.col.config;

import io.dropwizard.Configuration;

public class WsConfig extends Configuration {

    public PgConfig db = new PgConfig();
}
