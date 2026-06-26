package org.springframework.boot.autoconfigure.sql.init;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link R2dbcInitializationConfiguration}.
 */
@Generated
public class R2dbcInitializationConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'r2dbcInitializationConfiguration'.
   */
  public static BeanDefinition getRdbcInitializationConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcInitializationConfiguration.class);
    beanDefinition.setInstanceSupplier(R2dbcInitializationConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'r2dbcScriptDatabaseInitializer'.
   */
  private static BeanInstanceSupplier<SqlR2dbcScriptDatabaseInitializer> getRdbcScriptDatabaseInitializerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SqlR2dbcScriptDatabaseInitializer>forFactoryMethod(R2dbcInitializationConfiguration.class, "r2dbcScriptDatabaseInitializer", ConnectionFactory.class, SqlInitializationProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.sql.init.R2dbcInitializationConfiguration", R2dbcInitializationConfiguration.class).r2dbcScriptDatabaseInitializer(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'r2dbcScriptDatabaseInitializer'.
   */
  public static BeanDefinition getRdbcScriptDatabaseInitializerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SqlR2dbcScriptDatabaseInitializer.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.sql.init.R2dbcInitializationConfiguration");
    beanDefinition.setInstanceSupplier(getRdbcScriptDatabaseInitializerInstanceSupplier());
    return beanDefinition;
  }
}
