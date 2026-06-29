package com.graalvm.kafkatest;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link CompilationTestApplication}.
 */
@Generated
public class CompilationTestApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'compilationTestApplication'.
   */
  public static BeanDefinition getCompilationTestApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CompilationTestApplication.class);
    beanDefinition.setTargetType(CompilationTestApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(CompilationTestApplication.class);
    beanDefinition.setInstanceSupplier(CompilationTestApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
