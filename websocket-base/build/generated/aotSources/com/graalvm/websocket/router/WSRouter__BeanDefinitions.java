package com.graalvm.websocket.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link WSRouter}.
 */
@Generated
public class WSRouter__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'WSRouter'.
   */
  private static BeanInstanceSupplier<WSRouter> getWSRouterInstanceSupplier() {
    return BeanInstanceSupplier.<WSRouter>forConstructor(ObjectMapper.class)
            .withGenerator((registeredBean, args) -> new WSRouter(args.get(0)));
  }

  /**
   * Get the bean definition for 'wSRouter'.
   */
  public static BeanDefinition getWSRouterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WSRouter.class);
    beanDefinition.setInstanceSupplier(getWSRouterInstanceSupplier());
    return beanDefinition;
  }
}
