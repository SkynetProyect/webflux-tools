package com.graalvm.kafkatest.config;

import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.core.ResolvableType;
import reactor.kafka.receiver.KafkaReceiver;

/**
 * Bean definitions for {@link KafkaConsumerConfig}.
 */
@Generated
public class KafkaConsumerConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'kafkaConsumerConfig'.
   */
  public static BeanDefinition getKafkaConsumerConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(KafkaConsumerConfig.class);
    beanDefinition.setTargetType(KafkaConsumerConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(KafkaConsumerConfig.class);
    beanDefinition.setInstanceSupplier(KafkaConsumerConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'kafkaReceiver'.
   */
  private static BeanInstanceSupplier<KafkaReceiver> getKafkaReceiverInstanceSupplier() {
    return BeanInstanceSupplier.<KafkaReceiver>forFactoryMethod(KafkaConsumerConfig$$SpringCGLIB$$0.class, "kafkaReceiver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("kafkaConsumerConfig", KafkaConsumerConfig.class).kafkaReceiver());
  }

  /**
   * Get the bean definition for 'kafkaReceiver'.
   */
  public static BeanDefinition getKafkaReceiverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(KafkaReceiver.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(KafkaReceiver.class, String.class, String.class));
    beanDefinition.setFactoryBeanName("kafkaConsumerConfig");
    beanDefinition.setInstanceSupplier(getKafkaReceiverInstanceSupplier());
    return beanDefinition;
  }
}
