package org.keron.microservicevisualization.controls;

import org.keron.microservicevisualization.FlowchartsBuilder;
import org.keron.microservicevisualization.model.data.ServerInfo;
import org.keron.microservicevisualization.model.flowcharts.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class IndexControler {

    @GetMapping("/chart/{id}/{direction}")
    public String loadChartText( @PathVariable String id , @PathVariable String direction ){

        if( id.equalsIgnoreCase("sub") ){
            return loadsubgraphTest(direction) ;
        }
        else if( id.equalsIgnoreCase("tree") ){
            return laodTreeNodeTest(direction) ;
        }

        return "" ;
    }

    @GetMapping("/server/{id}")
    public ServerInfo loadServerInfoText( @PathVariable String id  ){

        return getServerInfo(id) ;

    }

    private ServerInfo getServerInfo( String id  ){

        ServerInfo app1 = new ServerInfo() ;
        app1.setId("app1");
        app1.setName("spring-boot-user-service");
        app1.setDescripte("用户服务");
        app1.setTitle("app1");

        ServerInfo app2 = new ServerInfo() ;
        app2.setId("app2");
        app2.setName("spring-boot-order-service");
        app2.setDescripte("酒店订单服务");
        app2.setTitle("app2");

        ServerInfo db1 = new ServerInfo() ;
        db1.setId("db1");
        db1.setName("mysql-user-database");
        db1.setDescripte("会员数据库");
        db1.setTitle("db1");

        HashMap<String , ServerInfo> map = new HashMap<>() ;
        map.put("app1" , app1) ;
        map.put("app2" , app2) ;
        map.put("db1" , db1) ;

        return   map.get(id) ;
    }

    private String loadsubgraphTest( String direction ){

        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(direction);

        // nodes
        Node appNode = new AppNode("app1") ;
        appNode.setTitle("app1");

        Node appNode1 = new AppNode("app2") ;
        appNode1.setTitle("app2");

        Node dataBaseNode = new DataBaseNode("db1") ;
        dataBaseNode.setTitle("DataBase 1");


        Node dataBaseNode1 = new DataBaseNode("db2") ;
        dataBaseNode1.setTitle("DataBase 2");

        Subgraph subgraph1 = new Subgraph("sub1") ;
        subgraph1.setTitle("sub1");
        subgraph1.addChild(appNode);

        Subgraph subgraph2 = new Subgraph("sub2") ;
        subgraph2.setTitle("sub2");
        subgraph2.addChild(appNode1);

        Subgraph subgraph = new Subgraph("sub") ;
        subgraph.setTitle("sub");
        subgraph.addChild(dataBaseNode);
        subgraph.addChild(dataBaseNode1);
        subgraph.addChild(subgraph1);
        subgraph.addChild(subgraph2);

        graph.addNode(subgraph);

        // links
        Link link1 = new Link("app1" ,"app2") ;
        Link link2 = new Link("app1" ,"db1") ;
        Link link3 = new Link("app2" ,"db2") ;

        graph.addLink(link1);
        graph.addLink(link2);
        graph.addLink(link3);

        return builder.build(graph) ;
    }

    private String laodTreeNodeTest( String direction ){

        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(direction);

        // nodes
        Node nginxNode = Node.getNginxNodeInstance("nginx") ;
        nginxNode.setTitle("Nginx Server");
        graph.addNode(nginxNode) ;

        Node appNode = Node.getAppNodeInstance("app1") ;
        appNode.setTitle("app1");
        appNode.setCount(3);
        graph.addNode(appNode) ;

        Node appNode1 = new AppNode("app2") ;
        appNode1.setTitle("app2");
        appNode1.setCount(2);
        graph.addNode(appNode1) ;

        Node dataBaseNode = new DataBaseNode("db1") ;
        dataBaseNode.setTitle("DataBase 1");
        dataBaseNode.setCount(2);
        graph.addNode(dataBaseNode);

        Node dataBaseNode1 = new DataBaseNode("db2") ;
        dataBaseNode1.setTitle("DataBase 2");
        graph.addNode(dataBaseNode1);

        Node userNode = Node.getUserNodeInstance("user") ;
        userNode.setTitle("企业用户");
        graph.addNode(userNode);

        Node redisNode = Node.getRedisNodeInstance("redis") ;
        redisNode.setTitle("redis");
        graph.addNode(redisNode);

        Node mqNode = Node.getMQNodeInstance("mq");
        mqNode.setTitle("kafaka");
        graph.addNode(mqNode) ;

        Node appNode3 = Node.getAppNodeInstance("app3") ;
        appNode3.setTitle("app3");
        graph.addNode(appNode3);

        Node outerNode = Node.getOuterNodeInstance("outer") ;
        outerNode.setTitle("outer");
        graph.addNode(outerNode);

        Node outerNode1 = Node.getOuterNodeInstance("outer1") ;
        outerNode1.setTitle("外部服务");
        graph.addNode(outerNode1);

        // links
        Link link1 = new Link("app1" ,"app2") ;
        link1.setTitle(" http 调用 ");
        Link link2 = new Link("app1" ,"db1") ;
        link2.setTitle(" 从数据库获取用户信息 ");
        Link link3 = new Link("app2" ,"db2") ;
        link3.setTitle(" 读取订单信息 ");
        Link link4 = new Link("nginx" ,"app1") ;
        link4.setTitle(" 请求分发 ");
        Link link5 = new Link("user" ,"nginx") ;
        link5.setTitle(" 用户请求 ");
        Link link6 = new Link("app1" ,"redis") ;
        link6.setTitle(" 请求redis ");
        Link link7 = new Link("app2" ,"mq") ;
        link7.setTitle("发送消息到kafaka");
        Link link8 = new Link("app3" ,"mq") ;
        link8.setTitle("消费消息");
        Link link9 = new Link("app3" ,"outer") ;
        link9.setTitle("发送短信消息");

        graph.addLink(link1);
        graph.addLink(link2);
        graph.addLink(link3);
        graph.addLink(link4);
        graph.addLink(link5);
        graph.addLink(link6);
        graph.addLink(link7);
        graph.addLink(link8);
        graph.addLink(link9);

        return builder.build(graph) ;

    }

}
