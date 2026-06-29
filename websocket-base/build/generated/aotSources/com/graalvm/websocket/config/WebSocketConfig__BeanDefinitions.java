package com.graalvm.websocket.config;

import com.graalvm.websocket.router.WSRouter;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

/**
 * Bean definitions for {@link WebSocketConfig}.
 */
@Generated
public class WebSocketConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'webSocketConfig'.
   */
  public static BeanDefinition getWebSocketConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSocketConfig.class);
    beanDefinition.setTargetType(WebSocketConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(WebSocketConfig.class);
    beanDefinition.setInstanceSupplier(WebSocketConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'handlerMapping'.
   */
  private static BeanInstanceSupplier<HandlerMapping> getHandlerMappingInstanceSupplier() {
    return BeanInstanceSupplier.<HandlerMapping>forFactoryMethod(WebSocketConfig$$SpringCGLIB$$0.class, "handlerMapping", WSRouter.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("webSocketConfig", WebSocketConfig.class).handlerMapping(args.get(0)));
  }

  /**
   * Get the bean definition for 'handlerMapping'.
   */
  public static BeanDefinition getHandlerMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HandlerMapping.class);
    beanDefinition.setFactoryBeanName("webSocketConfig");
    beanDefinition.setInstanceSupplier(getHandlerMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'handlerAdapter'.
   */
  private static BeanInstanceSupplier<WebSocketHandlerAdapter> getHandlerAdapterInstanceSupplier() {
    return BeanInstanceSupplier.<WebSocketHandlerAdapter>forFactoryMethod(WebSocketConfig$$SpringCGLIB$$0.class, "handlerAdapter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("webSocketConfig", WebSocketConfig.class).handlerAdapter());
  }

  /**
   * Get the bean definition for 'handlerAdapter'.
   */
  public static BeanDefinition getHandlerAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSocketHandlerAdapter.class);
    beanDefinition.setFactoryBeanName("webSocketConfig");
    beanDefinition.setInstanceSupplier(getHandlerAdapterInstanceSupplier());
    return beanDefinition;
  }
}
