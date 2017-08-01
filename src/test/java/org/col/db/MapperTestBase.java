package org.col.db;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.col.api.Name;
import org.col.config.ConfigTestUtils;
import org.col.db.mapper.NameMapper;
import org.junit.AfterClass;
import org.junit.Rule;

/**
 *
 */
public class MapperTestBase<T> {

    private static HikariDataSource dataSource;
    private static SqlSession session;

    T mapper;

    @Rule
    public ClbDbTestRule dbSetup = ClbDbTestRule.empty();

    public MapperTestBase(Class<T> mapperClazz) {
        initMybatis();
        mapper = session.getMapper(mapperClazz);
    }


    public static void initMybatis() {
        dataSource = ConfigTestUtils.testConfig().pool();

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("test", transactionFactory, dataSource);

        Configuration mybatisCfg = new Configuration(environment);
        mybatisCfg.setMapUnderscoreToCamelCase(true);
        mybatisCfg.setLazyLoadingEnabled(false);
        mybatisCfg.getTypeAliasRegistry().registerAlias(Name.class);
        mybatisCfg.addMapper(NameMapper.class);
        mybatisCfg.setCacheEnabled(false);
        //mybatisCfg.setLocalCacheScope(LocalCacheScope.STATEMENT);
        //mybatisCfg.setDefaultExecutorType(ExecutorType.SIMPLE);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(mybatisCfg);
        session = factory.openSession();
    }

    @AfterClass
    public static void tearDown() {
        session.close();
        dataSource.close();
    }

    public void commit() {
        session.commit();
    }

}