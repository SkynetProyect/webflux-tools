package org.springframework.boot.autoconfigure.transaction;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.reactive.TransactionalOperator;

/**
 * Bean definitions for {@link TransactionAutoConfiguration}.
 */
@Generated
public class TransactionAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'transactionAutoConfiguration'.
   */
  public static BeanDefinition getTransactionAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(TransactionAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'transactionalOperator'.
   */
  private static BeanInstanceSupplier<TransactionalOperator> getTransactionalOperatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<TransactionalOperator>forFactoryMethod(TransactionAutoConfiguration.class, "transactionalOperator", ReactiveTransactionManager.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration", TransactionAutoConfiguration.class).transactionalOperator(args.get(0)));
  }

  /**
   * Get the bean definition for 'transactionalOperator'.
   */
  public static BeanDefinition getTransactionalOperatorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionalOperator.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration");
    beanDefinition.setInstanceSupplier(getTransactionalOperatorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link TransactionAutoConfiguration.EnableTransactionManagementConfiguration}.
   */
  @Generated
  public static class EnableTransactionManagementConfiguration {
    /**
     * Get the bean definition for 'enableTransactionManagementConfiguration'.
     */
    public static BeanDefinition getEnableTransactionManagementConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionAutoConfiguration.EnableTransactionManagementConfiguration.class);
      beanDefinition.setInstanceSupplier(TransactionAutoConfiguration.EnableTransactionManagementConfiguration::new);
      return beanDefinition;
    }

    /**
     * Bean definitions for {@link TransactionAutoConfiguration.EnableTransactionManagementConfiguration.CglibAutoProxyConfiguration}.
     */
    @Generated
    public static class CglibAutoProxyConfiguration {
      /**
       * Get the bean definition for 'cglibAutoProxyConfiguration'.
       */
      public static BeanDefinition getCglibAutoProxyConfigurationBeanDefinition() {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionAutoConfiguration.EnableTransactionManagementConfiguration.CglibAutoProxyConfiguration.class);
        beanDefinition.setInstanceSupplier(TransactionAutoConfiguration.EnableTransactionManagementConfiguration.CglibAutoProxyConfiguration::new);
        return beanDefinition;
      }
    }
  }
}
