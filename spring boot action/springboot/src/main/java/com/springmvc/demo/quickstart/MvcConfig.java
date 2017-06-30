package com.springmvc.demo.quickstart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import org.springframework.context.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.MimeType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yukai on 2017/6/23.
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableScheduling
@ComponentScans(value = {@ComponentScan("com.springmvc.demo"),@ComponentScan("com.spring.demo.aspect")})
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Bean
    //视图解析器配置
    public InternalResourceViewResolver myViewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    //JSON消息转换器配置
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter()
    {
        MappingJackson2HttpMessageConverter converter=new MappingJackson2HttpMessageConverter();
        List<MediaType> types=new ArrayList();
//        types.add("text/html;charset=UTF-8");
//        types.add("application/json;charset=UTF-8");
        types.add(MediaType.APPLICATION_JSON_UTF8);
        types.add(MediaType.TEXT_HTML);
        converter.setSupportedMediaTypes(types);
        ObjectMapper objectMapper=new ObjectMapper();
// 设置返回值NULL的字段不返回 需要在字段上加注解@JsonInclude(JsonInclude.Include.NON_NULL)
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

//        DefaultSerializerProvider provider=new DefaultSerializerProvider.Impl();
//        provider.setNullValueSerializer();
//        objectMapper.setSerializerProvider();

        converter.setObjectMapper(objectMapper);

        return converter;
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter()
    {
        StringHttpMessageConverter stringHttpMessageConverter=new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        List<MediaType> types=new ArrayList();
//        types.add(MediaType.APPLICATION_JSON_UTF8);
//        types.add(MediaType.TEXT_PLAIN);
//        stringHttpMessageConverter.setSupportedMediaTypes(types);
//        stringHttpMessageConverter.setSupportedMediaTypes(types);
        return stringHttpMessageConverter;
    }

    @Bean
    //文件上传配置
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1024*1024*100);
        return multipartResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        //// FIXME: 2017/6/27 起初写成了addResourceLocations("/WEB-INF/static") 然后各种调试都不成功
//        registry.addResourceHandler("/visit/static/**")   //对外暴露的访问路径
//                .addResourceLocations("/WEB-INF/static");  //文件放置的目录

        registry.addResourceHandler("/visit/static/**")   //对外暴露的访问路径
                .addResourceLocations("/WEB-INF/static/");  //文件放置的目录
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MvcInterceptorExtendsAdapter());
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //例：不可忽略url中特殊字符如"."后的参数
        configurer.setUseSuffixPatternMatch(false);
    }

    //配置jsp页面跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/indexOfViewController") //自定义url
                .setViewName("/index"); //视图控制器实际跳转的页面，本工程是：index.jsp

        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/toPush/sse").setViewName("/push");
    }

    /**
     * 针对那些不会返回view视图的response：
     * 即含有方法含有@ResponseBody或者返回值为HttpEntity等类型的，它们都会用到HttpMessageConverter
     */

    @Override
    /**
     * 新增 HttpMessageConverter ，在默认的基础上追加
     */
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 新增的 以及 SpringMVC默认注册的 HttpMessageConverter，最终设置到
        // RequestMappingHandlerAdapter的
        // private List<HttpMessageConverter<?>> messageConverters属性上
        converters.add(mappingJackson2HttpMessageConverter());

    }

    @Override
    /**
     * 重载默认HttpMessageConverter ，覆盖默认的消息转换器
     */
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        //spring的 StringHttpMessageConverter默认的字符类型是iso8895-1 手动设置UTF-8 覆盖
        converters.add(stringHttpMessageConverter());
    }
}

class JsonNullValueSerializer extends JsonSerializer{

    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

    }
}