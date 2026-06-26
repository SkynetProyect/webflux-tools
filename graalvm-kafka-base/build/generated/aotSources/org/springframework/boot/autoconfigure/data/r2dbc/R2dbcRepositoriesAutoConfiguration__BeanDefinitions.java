package org.springframework.boot.autoconfigure.data.r2dbc;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link R2dbcRepositoriesAutoConfiguration}.
 */
@Generated
public class R2dbcRepositoriesAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'r2dbcRepositoriesAutoConfiguration'.
   */
  public static BeanDefinition getRdbcRepositoriesAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcRepositoriesAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(R2dbcRepositoriesAutoConfiguration::new);
    return beanDefinition;
  }
}
