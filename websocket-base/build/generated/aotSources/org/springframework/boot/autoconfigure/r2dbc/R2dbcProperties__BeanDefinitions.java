package org.springframework.boot.autoconfigure.r2dbc;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link R2dbcProperties}.
 */
@Generated
public class R2dbcProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'r2dbcProperties'.
   */
  public static BeanDefinition getRdbcPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcProperties.class);
    beanDefinition.setInstanceSupplier(R2dbcProperties::new);
    return beanDefinition;
  }
}
