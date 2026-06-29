package org.springframework.boot.autoconfigure.r2dbc;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.r2dbc.core.DatabaseClient;

/**
 * Bean definitions for {@link ConnectionFactoryDependentConfiguration}.
 */
@Generated
public class ConnectionFactoryDependentConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'connectionFactoryDependentConfiguration'.
   */
  public static BeanDefinition getConnectionFactoryDependentConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ConnectionFactoryDependentConfiguration.class);
    beanDefinition.setInstanceSupplier(ConnectionFactoryDependentConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'r2dbcDatabaseClient'.
   */
  private static BeanInstanceSupplier<DatabaseClient> getRdbcDatabaseClientInstanceSupplier() {
    return BeanInstanceSupplier.<DatabaseClient>forFactoryMethod(ConnectionFactoryDependentConfiguration.class, "r2dbcDatabaseClient", ConnectionFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.r2dbc.ConnectionFactoryDependentConfiguration", ConnectionFactoryDependentConfiguration.class).r2dbcDatabaseClient(args.get(0)));
  }

  /**
   * Get the bean definition for 'r2dbcDatabaseClient'.
   */
  public static BeanDefinition getRdbcDatabaseClientBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DatabaseClient.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.r2dbc.ConnectionFactoryDependentConfiguration");
    beanDefinition.setInstanceSupplier(getRdbcDatabaseClientInstanceSupplier());
    return beanDefinition;
  }
}
