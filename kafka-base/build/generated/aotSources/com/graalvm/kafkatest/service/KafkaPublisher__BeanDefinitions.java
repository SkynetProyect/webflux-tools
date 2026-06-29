package com.graalvm.kafkatest.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import reactor.kafka.sender.KafkaSender;

/**
 * Bean definitions for {@link KafkaPublisher}.
 */
@Generated
public class KafkaPublisher__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'kafkaPublisher'.
   */
  private static BeanInstanceSupplier<KafkaPublisher> getKafkaPublisherInstanceSupplier() {
    return BeanInstanceSupplier.<KafkaPublisher>forConstructor(KafkaSender.class)
            .withGenerator((registeredBean, args) -> new KafkaPublisher(args.get(0)));
  }

  /**
   * Get the bean definition for 'kafkaPublisher'.
   */
  public static BeanDefinition getKafkaPublisherBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(KafkaPublisher.class);
    beanDefinition.setInstanceSupplier(getKafkaPublisherInstanceSupplier());
    return beanDefinition;
  }
}
