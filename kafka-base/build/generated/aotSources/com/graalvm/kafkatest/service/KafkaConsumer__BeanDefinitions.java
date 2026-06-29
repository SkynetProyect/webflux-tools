package com.graalvm.kafkatest.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import reactor.kafka.receiver.KafkaReceiver;

/**
 * Bean definitions for {@link KafkaConsumer}.
 */
@Generated
public class KafkaConsumer__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'kafkaConsumer'.
   */
  private static BeanInstanceSupplier<KafkaConsumer> getKafkaConsumerInstanceSupplier() {
    return BeanInstanceSupplier.<KafkaConsumer>forConstructor(KafkaReceiver.class)
            .withGenerator((registeredBean, args) -> new KafkaConsumer(args.get(0)));
  }

  /**
   * Get the bean definition for 'kafkaConsumer'.
   */
  public static BeanDefinition getKafkaConsumerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(KafkaConsumer.class);
    beanDefinition.setInitMethodNames("start");
    beanDefinition.setInstanceSupplier(getKafkaConsumerInstanceSupplier());
    return beanDefinition;
  }
}
