package org.keron.microservicevisualization;

import org.junit.jupiter.api.Test;
import org.keron.microservicevisualization.model.flowcharts.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FlowchartsBuilderTest {

    @Test
    public void simpleGraphTest(){

        FlowchartsBuilder builder = new FlowchartsBuilder() ;

        Graph graph = new Graph() ;
        graph.setLayout(Graph.BT);

        String text = builder.build(graph) ;

        assertThat(text).contains("BT") ;
    }

    @Test
    public void singleAppNodeTest(){

        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(Graph.BT);

        AppNode appNode = new AppNode("app1") ;
        appNode.setTitle("app node 1");
        graph.addNode(appNode);

        String text = builder.build(graph) ;

        assertThat(text).contains("app1") ;

    }

    @Test
    public void AppDataBaseNodeTest(){

        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(Graph.BT);

        AppNode appNode = new AppNode("app1") ;
        appNode.setTitle("app");
        graph.addNode(appNode) ;


        DataBaseNode dataBaseNode = new DataBaseNode("DB1") ;
        dataBaseNode.setTitle("DataBase");
        graph.addNode(dataBaseNode);

        String text = builder.build(graph) ;

        assertThat(text).contains("DB1") ;

    }

    @Test
    public void linkNodeTest(){

        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(Graph.BT);

        // ndoes
        AppNode appNode = new AppNode("app1") ;
        appNode.setTitle("app");
        graph.addNode(appNode) ;


        DataBaseNode dataBaseNode = new DataBaseNode("db1") ;
        dataBaseNode.setTitle("DataBase");
        graph.addNode(dataBaseNode);

        // links
        Link link = new Link("app1" , "db1") ;
        link.setTitle(" app query db1 ");
        graph.addLink(link);

        String text = builder.build(graph) ;

        assertThat(text).contains("db1") ;

    }

    @Test
    public void treeNodeTest(){

        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(Graph.TB);

        // nodes
        Node appNode = new AppNode("app1") ;
        appNode.setTitle("app1");
        graph.addNode(appNode) ;

        Node appNode1 = new AppNode("app2") ;
        appNode1.setTitle("app2");
        graph.addNode(appNode1) ;

        Node dataBaseNode = new DataBaseNode("db1") ;
        dataBaseNode.setTitle("DataBase 1");
        graph.addNode(dataBaseNode);

        Node dataBaseNode1 = new DataBaseNode("db2") ;
        dataBaseNode1.setTitle("DataBase 2");
        graph.addNode(dataBaseNode1);

        // links
        Link link1 = new Link("app1" ,"app2") ;
        Link link2 = new Link("app1" ,"db1") ;
        Link link3 = new Link("app2" ,"db2") ;

        graph.addLink(link1);
        graph.addLink(link2);
        graph.addLink(link3);

        String text = builder.build(graph) ;

        assertThat(text).contains("db2") ;

    }

    @Test
    public void subgraphTest(){

        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(Graph.TB);

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

        String text = builder.build(graph) ;

        assertThat(text).contains("db2") ;

    }

}
