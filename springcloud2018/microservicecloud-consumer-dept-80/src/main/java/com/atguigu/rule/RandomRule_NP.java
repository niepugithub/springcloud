package com.atguigu.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/20 15:58
 **/
public class RandomRule_NP extends AbstractLoadBalancerRule {
    // total=0， 当total==5之后，指针才能往下走
    // index=0，当前对外提供服务器的地址
    // 当total需要重新置为0，但是已经到达过一个5次，我们的index=1
    // 分析，我们5次，但是微服务只有8001,8002,8003,三台，因此只要index超过3，就得重置index
    private int index;
    private int total;

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }


    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            System.out.println("no load balancer");
            return null;
        }
        Server server = null;
        int count=0;
        while (server == null && count++ <10) {
            List<Server> upServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            int serverCount = allServers.size();
            if(serverCount==0){
                return null;
            }
            if(total<5){
                server=upServers.get(index);
                total++;
            }else {
                total=0;
                index++;
                if(index>=upServers.size()){
                    index=0;
                }
            }
            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe())) {
                return server;
            }
            // Next.
            server = null;
        }
        if (count >= 10) {
            System.out.println(
                    "No available alive servers after 10 tries from load balancer: " + lb);
        }
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }


}
