package com.os;

import com.config.RandomRibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
/*其中 name 是服务的名字，configuration是策略配置类的名字*/
@RibbonClient(name = "order-provider", configuration = RandomRibbonConfiguration.class)
@ServletComponentScan("com.os.util")
public class OrderConsumerApplication {
    /*提交
 *RestTemplate 是 Spring 提供的用于访问 Rest 服务的客户端，
 *RestTemplate 提供了多种便捷访问远程 Http 服务的方法,能够大大提高客户端
的编写效率。
 *调用 RestTemplate 的默认构造函数，RestTemplate 对象在底层通过使用 java.
net 包下的实现创建 HTTP 请求，
使用 RestTemplate 进行 rest 操作的时候，会自动使用负载均衡策略，它内部
会在 RestTemplate 中加入 LoadBalancerInterceptor 这个拦截器，这个拦截器的作
用就是使用负载均衡。
 */
    @Bean
    @LoadBalanced //默认采用轮询方式
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerApplication.class, args);
    }

}
