package org.springframework.boot.autoconfigure.r2dbc;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;

/**
 * Bean definitions for {@link R2dbcTransactionManagerAutoConfiguration}.
 */
@Generated
public class R2dbcTransactionManagerAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'r2dbcTransactionManagerAutoConfiguration'.
   */
  public static BeanDefinition getRdbcTransactionManagerAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcTransactionManagerAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(R2dbcTransactionManagerAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'connectionFactoryTransactionManager'.
   */
  private static BeanInstanceSupplier<R2dbcTransactionManager> getConnectionFactoryTransactionManagerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<R2dbcTransactionManager>forFactoryMethod(R2dbcTransactionManagerAutoConfiguration.class, "connectionFactoryTransactionManager", ConnectionFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.r2dbc.R2dbcTransactionManagerAutoConfiguration", R2dbcTransactionManagerAutoConfiguration.class).connectionFactoryTransactionManager(args.get(0)));
  }

  /**
   * Get the bean definition for 'connectionFactoryTransactionManager'.
   */
  public static BeanDefinition getConnectionFactoryTransactionManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcTransactionManager.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.r2dbc.R2dbcTransactionManagerAutoConfiguration");
    beanDefinition.setInstanceSupplier(getConnectionFactoryTransactionManagerInstanceSupplier());
    return beanDefinition;
  }
}
