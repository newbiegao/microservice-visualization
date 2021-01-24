package org.keron.microservicevisualization;

import org.junit.jupiter.api.Test;
import org.keron.microservicevisualization.model.flowcharts.AppNode;
import org.keron.microservicevisualization.model.flowcharts.DataBaseNode;
import org.keron.microservicevisualization.model.flowcharts.Graph;
import org.keron.microservicevisualization.model.flowcharts.Link;
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

        assertThat(text).isEqualTo("graph BT") ;
    }

    @Test
    public void singleAppNodeTest(){

        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(Graph.BT);

        AppNode appNode = new AppNode("app1") ;
        appNode.setTitle("app node 1");
        graph.getNodeList().add(appNode) ;

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

}
