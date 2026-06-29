package com.graalvm.compilationtest.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.core.ResolvableType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Bean definitions for {@link TestRouter}.
 */
@Generated
public class TestRouter__BeanDefinitions {
  /**
   * Get the bean definition for 'testRouter'.
   */
  public static BeanDefinition getTestRouterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestRouter.class);
    beanDefinition.setTargetType(TestRouter.class);
    ConfigurationClassUtils.initializeConfigurationClass(TestRouter.class);
    beanDefinition.setInstanceSupplier(TestRouter$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'routes'.
   */
  private static BeanInstanceSupplier<RouterFunction> getRoutesInstanceSupplier() {
    return BeanInstanceSupplier.<RouterFunction>forFactoryMethod(TestRouter$$SpringCGLIB$$0.class, "routes")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("testRouter", TestRouter.class).routes());
  }

  /**
   * Get the bean definition for 'routes'.
   */
  public static BeanDefinition getRoutesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RouterFunction.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(RouterFunction.class, ServerResponse.class));
    beanDefinition.setFactoryBeanName("testRouter");
    beanDefinition.setInstanceSupplier(getRoutesInstanceSupplier());
    return beanDefinition;
  }
}
