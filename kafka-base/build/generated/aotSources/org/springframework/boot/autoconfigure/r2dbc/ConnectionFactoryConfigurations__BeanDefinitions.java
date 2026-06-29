package org.springframework.boot.autoconfigure.r2dbc;

import io.r2dbc.pool.ConnectionPool;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.io.ResourceLoader;

/**
 * Bean definitions for {@link ConnectionFactoryConfigurations}.
 */
@Generated
public class ConnectionFactoryConfigurations__BeanDefinitions {
  /**
   * Bean definitions for {@link ConnectionFactoryConfigurations.PoolConfiguration}.
   */
  @Generated
  public static class PoolConfiguration {
    /**
     * Get the bean definition for 'poolConfiguration'.
     */
    public static BeanDefinition getPoolConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ConnectionFactoryConfigurations.PoolConfiguration.class);
      beanDefinition.setInstanceSupplier(ConnectionFactoryConfigurations.PoolConfiguration::new);
      return beanDefinition;
    }

    /**
     * Bean definitions for {@link ConnectionFactoryConfigurations.PoolConfiguration.PooledConnectionFactoryConfiguration}.
     */
    @Generated
    public static class PooledConnectionFactoryConfiguration {
      /**
       * Get the bean definition for 'pooledConnectionFactoryConfiguration'.
       */
      public static BeanDefinition getPooledConnectionFactoryConfigurationBeanDefinition() {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(ConnectionFactoryConfigurations.PoolConfiguration.PooledConnectionFactoryConfiguration.class);
        beanDefinition.setInstanceSupplier(ConnectionFactoryConfigurations.PoolConfiguration.PooledConnectionFactoryConfiguration::new);
        return beanDefinition;
      }

      /**
       * Get the bean instance supplier for 'connectionFactory'.
       */
      private static BeanInstanceSupplier<ConnectionPool> getConnectionFactoryInstanceSupplier() {
        return BeanInstanceSupplier.<ConnectionPool>forFactoryMethod(ConnectionFactoryConfigurations.PoolConfiguration.PooledConnectionFactoryConfiguration.class, "connectionFactory", R2dbcProperties.class, ObjectProvider.class, ResourceLoader.class, ObjectProvider.class, ObjectProvider.class)
                .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.r2dbc.ConnectionFactoryConfigurations$PoolConfiguration$PooledConnectionFactoryConfiguration", ConnectionFactoryConfigurations.PoolConfiguration.PooledConnectionFactoryConfiguration.class).connectionFactory(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
      }

      /**
       * Get the bean definition for 'connectionFactory'.
       */
      public static BeanDefinition getConnectionFactoryBeanDefinition() {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(ConnectionPool.class);
        beanDefinition.setDestroyMethodNames("dispose");
        beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.r2dbc.ConnectionFactoryConfigurations$PoolConfiguration$PooledConnectionFactoryConfiguration");
        beanDefinition.setInstanceSupplier(getConnectionFactoryInstanceSupplier());
        return beanDefinition;
      }
    }
  }
}
