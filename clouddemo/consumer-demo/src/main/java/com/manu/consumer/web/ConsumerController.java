package com.manu.consumer.web;

import com.manu.consumer.client.UserClient;
import com.manu.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

//    @Autowired
////    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    @HystrixCommand
    public User queryById(@PathVariable("id") Integer id) {
      //使用feign获取服务，返回响应结果
        return userClient.queryById(id);
    }

//    @GetMapping("{id}")
//    @HystrixCommand(fallbackMethod = "queryByIdFallback" )
//    @HystrixCommand(commandProperties = {//设置超时访问时间
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "4000")
//    })
//    @GetMapping("{id}")
//    @HystrixCommand
//    public String queryById(@PathVariable("id") Integer id) {
//        //1.在启动类中restTemplate()方法中添加@LoadBalanced注解
//        //@LoadBalanced注解内置拦截器，拦截服务请求，把user-service拿到，自己做负载均衡得到一个地址
//
//        String url = "http://user-service/user/"+id;
//        String  user = restTemplate.getForObject(url, String.class);
//        return user;
//    }
    public String queryByIdFallback(Integer id) {
        return "服务器正忙，请稍后再试……";
    }
    public String defaultFallback() {
        return "服务器正忙，请稍后再试……";
    }


    //方法2
//    @Autowired
//    private RibbonLoadBalancerClient client;
//
//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Integer id){
//
//        //client.choose()使用轮询算法实现负载均衡，
//        ServiceInstance instance = client.choose("user-service");
//        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
//        return restTemplate.getForObject(url,User.class);
//    }

}
//使用DiscoveryClient进行拉取服务列表
/*
@Autowired
private DiscoveryClient discoveryClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Integer id){
        //根据服务ID获取实例，一个serviceId可以有多个实例，所以返回的是一个集合
        List<Servicpublic void add(int a,int b){

    }eInstance> instances = discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance = instances.get(0);
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;

        User user = restTemplate.getForObject(url, User.class);
        return user;
    }*/
