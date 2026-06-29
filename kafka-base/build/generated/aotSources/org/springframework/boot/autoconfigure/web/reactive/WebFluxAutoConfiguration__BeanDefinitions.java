package org.springframework.boot.autoconfigure.web.reactive;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.core.env.Environment;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.DispatcherHandler;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import org.springframework.web.reactive.function.server.support.HandlerFunctionAdapter;
import org.springframework.web.reactive.function.server.support.RouterFunctionMapping;
import org.springframework.web.reactive.function.server.support.ServerResponseResultHandler;
import org.springframework.web.reactive.resource.ResourceUrlProvider;
import org.springframework.web.reactive.result.SimpleHandlerAdapter;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityResultHandler;
import org.springframework.web.reactive.result.view.ViewResolutionResultHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.server.WebExceptionHandler;
import org.springframework.web.server.i18n.LocaleContextResolver;
import org.springframework.web.server.session.WebSessionManager;

/**
 * Bean definitions for {@link WebFluxAutoConfiguration}.
 */
@Generated
public class WebFluxAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'webFluxAutoConfiguration'.
   */
  public static BeanDefinition getWebFluxAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(WebFluxAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link WebFluxAutoConfiguration.EnableWebFluxConfiguration}.
   */
  @Generated
  public static class EnableWebFluxConfiguration {
    /**
     * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration'.
     */
    private static BeanInstanceSupplier<WebFluxAutoConfiguration.EnableWebFluxConfiguration> getEnableWebFluxConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<WebFluxAutoConfiguration.EnableWebFluxConfiguration>forConstructor(WebFluxProperties.class, WebProperties.class, ServerProperties.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> new WebFluxAutoConfiguration.EnableWebFluxConfiguration(args.get(0), args.get(1), args.get(2), args.get(3)));
    }

    /**
     * Get the bean definition for 'enableWebFluxConfiguration'.
     */
    public static BeanDefinition getEnableWebFluxConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class);
      InstanceSupplier<WebFluxAutoConfiguration.EnableWebFluxConfiguration> instanceSupplier = getEnableWebFluxConfigurationInstanceSupplier();
      instanceSupplier = instanceSupplier.andThen(WebFluxAutoConfiguration_EnableWebFluxConfiguration__Autowiring::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'webFluxConversionService'.
     */
    private static BeanInstanceSupplier<FormattingConversionService> getWebFluxConversionServiceInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<FormattingConversionService>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "webFluxConversionService")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).webFluxConversionService());
    }

    /**
     * Get the bean definition for 'webFluxConversionService'.
     */
    public static BeanDefinition getWebFluxConversionServiceBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(FormattingConversionService.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getWebFluxConversionServiceInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'webFluxValidator'.
     */
    private static BeanInstanceSupplier<Validator> getWebFluxValidatorInstanceSupplier() {
      return BeanInstanceSupplier.<Validator>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "webFluxValidator")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).webFluxValidator());
    }

    /**
     * Get the bean definition for 'webFluxValidator'.
     */
    public static BeanDefinition getWebFluxValidatorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(Validator.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getWebFluxValidatorInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'localeContextResolver'.
     */
    private static BeanInstanceSupplier<LocaleContextResolver> getLocaleContextResolverInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<LocaleContextResolver>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "localeContextResolver")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).localeContextResolver());
    }

    /**
     * Get the bean definition for 'localeContextResolver'.
     */
    public static BeanDefinition getLocaleContextResolverBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(LocaleContextResolver.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getLocaleContextResolverInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'webSessionManager'.
     */
    private static BeanInstanceSupplier<WebSessionManager> getWebSessionManagerInstanceSupplier() {
      return BeanInstanceSupplier.<WebSessionManager>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "webSessionManager", ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).webSessionManager(args.get(0)));
    }

    /**
     * Get the bean definition for 'webSessionManager'.
     */
    public static BeanDefinition getWebSessionManagerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSessionManager.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getWebSessionManagerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'webHandler'.
     */
    private static BeanInstanceSupplier<DispatcherHandler> getWebHandlerInstanceSupplier() {
      return BeanInstanceSupplier.<DispatcherHandler>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "webHandler")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).webHandler());
    }

    /**
     * Get the bean definition for 'webHandler'.
     */
    public static BeanDefinition getWebHandlerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DispatcherHandler.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getWebHandlerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'responseStatusExceptionHandler'.
     */
    private static BeanInstanceSupplier<WebExceptionHandler> getResponseStatusExceptionHandlerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<WebExceptionHandler>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "responseStatusExceptionHandler")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).responseStatusExceptionHandler());
    }

    /**
     * Get the bean definition for 'responseStatusExceptionHandler'.
     */
    public static BeanDefinition getResponseStatusExceptionHandlerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebExceptionHandler.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getResponseStatusExceptionHandlerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'requestMappingHandlerMapping'.
     */
    private static BeanInstanceSupplier<RequestMappingHandlerMapping> getRequestMappingHandlerMappingInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<RequestMappingHandlerMapping>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "requestMappingHandlerMapping", RequestedContentTypeResolver.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).requestMappingHandlerMapping(args.get(0)));
    }

    /**
     * Get the bean definition for 'requestMappingHandlerMapping'.
     */
    public static BeanDefinition getRequestMappingHandlerMappingBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(RequestMappingHandlerMapping.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getRequestMappingHandlerMappingInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'webFluxContentTypeResolver'.
     */
    private static BeanInstanceSupplier<RequestedContentTypeResolver> getWebFluxContentTypeResolverInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<RequestedContentTypeResolver>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "webFluxContentTypeResolver")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).webFluxContentTypeResolver());
    }

    /**
     * Get the bean definition for 'webFluxContentTypeResolver'.
     */
    public static BeanDefinition getWebFluxContentTypeResolverBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(RequestedContentTypeResolver.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getWebFluxContentTypeResolverInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'routerFunctionMapping'.
     */
    private static BeanInstanceSupplier<RouterFunctionMapping> getRouterFunctionMappingInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<RouterFunctionMapping>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "routerFunctionMapping", ServerCodecConfigurer.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).routerFunctionMapping(args.get(0)));
    }

    /**
     * Get the bean definition for 'routerFunctionMapping'.
     */
    public static BeanDefinition getRouterFunctionMappingBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(RouterFunctionMapping.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getRouterFunctionMappingInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'resourceHandlerMapping'.
     */
    private static BeanInstanceSupplier<HandlerMapping> getResourceHandlerMappingInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<HandlerMapping>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "resourceHandlerMapping", ResourceUrlProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).resourceHandlerMapping(args.get(0)));
    }

    /**
     * Get the bean definition for 'resourceHandlerMapping'.
     */
    public static BeanDefinition getResourceHandlerMappingBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(HandlerMapping.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getResourceHandlerMappingInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'resourceUrlProvider'.
     */
    private static BeanInstanceSupplier<ResourceUrlProvider> getResourceUrlProviderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ResourceUrlProvider>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "resourceUrlProvider")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).resourceUrlProvider());
    }

    /**
     * Get the bean definition for 'resourceUrlProvider'.
     */
    public static BeanDefinition getResourceUrlProviderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ResourceUrlProvider.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getResourceUrlProviderInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'requestMappingHandlerAdapter'.
     */
    private static BeanInstanceSupplier<RequestMappingHandlerAdapter> getRequestMappingHandlerAdapterInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<RequestMappingHandlerAdapter>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "requestMappingHandlerAdapter", ReactiveAdapterRegistry.class, ServerCodecConfigurer.class, FormattingConversionService.class, RequestedContentTypeResolver.class, Validator.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).requestMappingHandlerAdapter(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
    }

    /**
     * Get the bean definition for 'requestMappingHandlerAdapter'.
     */
    public static BeanDefinition getRequestMappingHandlerAdapterBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(RequestMappingHandlerAdapter.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getRequestMappingHandlerAdapterInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'serverCodecConfigurer'.
     */
    private static BeanInstanceSupplier<ServerCodecConfigurer> getServerCodecConfigurerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ServerCodecConfigurer>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "serverCodecConfigurer")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).serverCodecConfigurer());
    }

    /**
     * Get the bean definition for 'serverCodecConfigurer'.
     */
    public static BeanDefinition getServerCodecConfigurerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ServerCodecConfigurer.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getServerCodecConfigurerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'webFluxAdapterRegistry'.
     */
    private static BeanInstanceSupplier<ReactiveAdapterRegistry> getWebFluxAdapterRegistryInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ReactiveAdapterRegistry>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "webFluxAdapterRegistry")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).webFluxAdapterRegistry());
    }

    /**
     * Get the bean definition for 'webFluxAdapterRegistry'.
     */
    public static BeanDefinition getWebFluxAdapterRegistryBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveAdapterRegistry.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getWebFluxAdapterRegistryInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'handlerFunctionAdapter'.
     */
    private static BeanInstanceSupplier<HandlerFunctionAdapter> getHandlerFunctionAdapterInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<HandlerFunctionAdapter>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "handlerFunctionAdapter")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).handlerFunctionAdapter());
    }

    /**
     * Get the bean definition for 'handlerFunctionAdapter'.
     */
    public static BeanDefinition getHandlerFunctionAdapterBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(HandlerFunctionAdapter.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getHandlerFunctionAdapterInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'simpleHandlerAdapter'.
     */
    private static BeanInstanceSupplier<SimpleHandlerAdapter> getSimpleHandlerAdapterInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<SimpleHandlerAdapter>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "simpleHandlerAdapter")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).simpleHandlerAdapter());
    }

    /**
     * Get the bean definition for 'simpleHandlerAdapter'.
     */
    public static BeanDefinition getSimpleHandlerAdapterBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleHandlerAdapter.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getSimpleHandlerAdapterInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'webFluxWebSocketHandlerAdapter'.
     */
    private static BeanInstanceSupplier<WebSocketHandlerAdapter> getWebFluxWebSocketHandlerAdapterInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<WebSocketHandlerAdapter>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "webFluxWebSocketHandlerAdapter")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).webFluxWebSocketHandlerAdapter());
    }

    /**
     * Get the bean definition for 'webFluxWebSocketHandlerAdapter'.
     */
    public static BeanDefinition getWebFluxWebSocketHandlerAdapterBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSocketHandlerAdapter.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getWebFluxWebSocketHandlerAdapterInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'responseEntityResultHandler'.
     */
    private static BeanInstanceSupplier<ResponseEntityResultHandler> getResponseEntityResultHandlerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ResponseEntityResultHandler>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "responseEntityResultHandler", ReactiveAdapterRegistry.class, ServerCodecConfigurer.class, RequestedContentTypeResolver.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).responseEntityResultHandler(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'responseEntityResultHandler'.
     */
    public static BeanDefinition getResponseEntityResultHandlerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ResponseEntityResultHandler.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getResponseEntityResultHandlerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'responseBodyResultHandler'.
     */
    private static BeanInstanceSupplier<ResponseBodyResultHandler> getResponseBodyResultHandlerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ResponseBodyResultHandler>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "responseBodyResultHandler", ReactiveAdapterRegistry.class, ServerCodecConfigurer.class, RequestedContentTypeResolver.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).responseBodyResultHandler(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'responseBodyResultHandler'.
     */
    public static BeanDefinition getResponseBodyResultHandlerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ResponseBodyResultHandler.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getResponseBodyResultHandlerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'viewResolutionResultHandler'.
     */
    private static BeanInstanceSupplier<ViewResolutionResultHandler> getViewResolutionResultHandlerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ViewResolutionResultHandler>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "viewResolutionResultHandler", ReactiveAdapterRegistry.class, RequestedContentTypeResolver.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).viewResolutionResultHandler(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'viewResolutionResultHandler'.
     */
    public static BeanDefinition getViewResolutionResultHandlerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ViewResolutionResultHandler.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getViewResolutionResultHandlerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'serverResponseResultHandler'.
     */
    private static BeanInstanceSupplier<ServerResponseResultHandler> getServerResponseResultHandlerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ServerResponseResultHandler>forFactoryMethod(WebFluxAutoConfiguration.EnableWebFluxConfiguration.class, "serverResponseResultHandler", ServerCodecConfigurer.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration", WebFluxAutoConfiguration.EnableWebFluxConfiguration.class).serverResponseResultHandler(args.get(0)));
    }

    /**
     * Get the bean definition for 'serverResponseResultHandler'.
     */
    public static BeanDefinition getServerResponseResultHandlerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ServerResponseResultHandler.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$EnableWebFluxConfiguration");
      beanDefinition.setInstanceSupplier(getServerResponseResultHandlerInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link WebFluxAutoConfiguration.WelcomePageConfiguration}.
   */
  @Generated
  public static class WelcomePageConfiguration {
    /**
     * Get the bean definition for 'welcomePageConfiguration'.
     */
    public static BeanDefinition getWelcomePageConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxAutoConfiguration.WelcomePageConfiguration.class);
      beanDefinition.setInstanceSupplier(WebFluxAutoConfiguration.WelcomePageConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'welcomePageRouterFunctionMapping'.
     */
    private static BeanInstanceSupplier<RouterFunctionMapping> getWelcomePageRouterFunctionMappingInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<RouterFunctionMapping>forFactoryMethod(WebFluxAutoConfiguration.WelcomePageConfiguration.class, "welcomePageRouterFunctionMapping", ApplicationContext.class, WebFluxProperties.class, WebProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$WelcomePageConfiguration", WebFluxAutoConfiguration.WelcomePageConfiguration.class).welcomePageRouterFunctionMapping(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'welcomePageRouterFunctionMapping'.
     */
    public static BeanDefinition getWelcomePageRouterFunctionMappingBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(RouterFunctionMapping.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$WelcomePageConfiguration");
      beanDefinition.setInstanceSupplier(getWelcomePageRouterFunctionMappingInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link WebFluxAutoConfiguration.WebFluxConfig}.
   */
  @Generated
  public static class WebFluxConfig {
    /**
     * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration$WebFluxConfig'.
     */
    private static BeanInstanceSupplier<WebFluxAutoConfiguration.WebFluxConfig> getWebFluxConfigInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<WebFluxAutoConfiguration.WebFluxConfig>forConstructor(Environment.class, WebProperties.class, WebFluxProperties.class, ListableBeanFactory.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> new WebFluxAutoConfiguration.WebFluxConfig(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7)));
    }

    /**
     * Get the bean definition for 'webFluxConfig'.
     */
    public static BeanDefinition getWebFluxConfigBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxAutoConfiguration.WebFluxConfig.class);
      beanDefinition.setInstanceSupplier(getWebFluxConfigInstanceSupplier());
      return beanDefinition;
    }
  }
}
