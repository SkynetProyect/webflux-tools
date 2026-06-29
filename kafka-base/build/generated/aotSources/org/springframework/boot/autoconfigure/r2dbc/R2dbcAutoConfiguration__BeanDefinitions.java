package org.springframework.boot.autoconfigure.r2dbc;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link R2dbcAutoConfiguration}.
 */
@Generated
public class R2dbcAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'r2dbcAutoConfiguration'.
   */
  public static BeanDefinition getRdbcAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(R2dbcAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'propertiesR2dbcConnectionDetails'.
   */
  private static BeanInstanceSupplier<R2dbcAutoConfiguration.PropertiesR2dbcConnectionDetails> getPropertiesRdbcConnectionDetailsInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<R2dbcAutoConfiguration.PropertiesR2dbcConnectionDetails>forFactoryMethod(R2dbcAutoConfiguration.class, "propertiesR2dbcConnectionDetails", R2dbcProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration", R2dbcAutoConfiguration.class).propertiesR2dbcConnectionDetails(args.get(0)));
  }

  /**
   * Get the bean definition for 'propertiesR2dbcConnectionDetails'.
   */
  public static BeanDefinition getPropertiesRdbcConnectionDetailsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcAutoConfiguration.PropertiesR2dbcConnectionDetails.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration");
    beanDefinition.setInstanceSupplier(getPropertiesRdbcConnectionDetailsInstanceSupplier());
    return beanDefinition;
  }
}
