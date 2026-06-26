package com.graalvm.kafkatest.config;

import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.core.ResolvableType;
import reactor.kafka.sender.KafkaSender;

/**
 * Bean definitions for {@link KafkaProducerConfig}.
 */
@Generated
public class KafkaProducerConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'kafkaProducerConfig'.
   */
  public static BeanDefinition getKafkaProducerConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(KafkaProducerConfig.class);
    beanDefinition.setTargetType(KafkaProducerConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(KafkaProducerConfig.class);
    beanDefinition.setInstanceSupplier(KafkaProducerConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'kafkaSender'.
   */
  private static BeanInstanceSupplier<KafkaSender> getKafkaSenderInstanceSupplier() {
    return BeanInstanceSupplier.<KafkaSender>forFactoryMethod(KafkaProducerConfig$$SpringCGLIB$$0.class, "kafkaSender")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("kafkaProducerConfig", KafkaProducerConfig.class).kafkaSender());
  }

  /**
   * Get the bean definition for 'kafkaSender'.
   */
  public static BeanDefinition getKafkaSenderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(KafkaSender.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(KafkaSender.class, String.class, String.class));
    beanDefinition.setDestroyMethodNames("close");
    beanDefinition.setFactoryBeanName("kafkaProducerConfig");
    beanDefinition.setInstanceSupplier(getKafkaSenderInstanceSupplier());
    return beanDefinition;
  }
}
