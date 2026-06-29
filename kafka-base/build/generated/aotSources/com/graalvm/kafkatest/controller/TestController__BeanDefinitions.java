package com.graalvm.kafkatest.controller;

import com.graalvm.kafkatest.service.KafkaPublisher;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TestController}.
 */
@Generated
public class TestController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'testController'.
   */
  private static BeanInstanceSupplier<TestController> getTestControllerInstanceSupplier() {
    return BeanInstanceSupplier.<TestController>forConstructor(KafkaPublisher.class)
            .withGenerator((registeredBean, args) -> new TestController(args.get(0)));
  }

  /**
   * Get the bean definition for 'testController'.
   */
  public static BeanDefinition getTestControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestController.class);
    beanDefinition.setInstanceSupplier(getTestControllerInstanceSupplier());
    return beanDefinition;
  }
}
