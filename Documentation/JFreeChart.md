

## dependency
```xml
      <dependency>
         <groupId>org.jfree</groupId>
         <artifactId>jfreechart</artifactId>
         <version>1.0.15</version>
      </dependency>

      <dependency>
         <groupId>org.jfree</groupId>
         <artifactId>jcommon</artifactId>
         <version>1.0.17</version>
      </dependency>

      <dependency>
         <groupId>org.testng</groupId>
         <artifactId>testng</artifactId>
         <version>6.8.7</version>
         <scope>test</scope>
      </dependency>


      <dependency>
         <groupId>org.apache.xmlgraphics</groupId>
         <artifactId>batik-dom</artifactId>
         <version>1.9.1</version>
      </dependency>
      <dependency>
         <groupId>org.apache.xmlgraphics</groupId>
         <artifactId>batik-xml</artifactId>
         <version>1.9.1</version>
      </dependency>

      <dependency>
         <groupId>org.apache.xmlgraphics</groupId>
         <artifactId>batik-util</artifactId>
         <version>1.9.1</version>
      </dependency>
      <dependency>
         <groupId>org.apache.xmlgraphics</groupId>
         <artifactId>batik-awt-util</artifactId>
         <version>1.9.1</version>
      </dependency>
      <dependency>
         <groupId>org.apache.xmlgraphics</groupId>
         <artifactId>batik-svggen</artifactId>
         <version>1.9.1</version>
      </dependency>
```





## 01 PieChart_AWT
```java
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class _01PieChart_AWT extends ApplicationFrame {
   
   public _01PieChart_AWT( String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   
   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "IPhone 5s" , new Double( 20 ) );  
      dataset.setValue( "SamSung Grand" , new Double( 20 ) );   
      dataset.setValue( "MotoG" , new Double( 40 ) );    
      dataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Mobile Sales",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }

   public static void main( String[ ] args ) {
      _01PieChart_AWT demo = new _01PieChart_AWT( "Mobile Sales" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}
```

## 02 Pie Chart Export Image
```java
import java.io.*;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class _02PieChartExportImage {
   
   public static void main( String[ ] args ) throws Exception {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue("IPhone 5s", new Double( 20 ) );
      dataset.setValue("SamSung Grand", new Double( 20 ) );
      dataset.setValue("MotoG", new Double( 40 ) );
      dataset.setValue("Nokia Lumia", new Double( 10 ) );

      JFreeChart chart = ChartFactory.createPieChart(
         "Mobile Sales",   // chart title
         dataset,          // data
         true,             // include legend
         true,
         false);
         
      int width = 640;   /* Width of the image */
      int height = 480;  /* Height of the image */ 
      File pieChart = new File( "PieChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
   }
}
```

## 03 BarChart_AWT
```java
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class _03BarChart_AWT extends ApplicationFrame {
   
   public _03BarChart_AWT( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Category",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( ) {
      final String fiat = "FIAT";        
      final String audi = "AUDI";        
      final String ford = "FORD";        
      final String speed = "Speed";        
      final String millage = "Millage";        
      final String userrating = "User Rating";        
      final String safety = "safety";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( 1.0 , fiat , speed );        
      dataset.addValue( 3.0 , fiat , userrating );        
      dataset.addValue( 5.0 , fiat , millage ); 
      dataset.addValue( 5.0 , fiat , safety );           

      dataset.addValue( 5.0 , audi , speed );        
      dataset.addValue( 6.0 , audi , userrating );       
      dataset.addValue( 10.0 , audi , millage );        
      dataset.addValue( 4.0 , audi , safety );

      dataset.addValue( 4.0 , ford , speed );        
      dataset.addValue( 2.0 , ford , userrating );        
      dataset.addValue( 3.0 , ford , millage );        
      dataset.addValue( 6.0 , ford , safety );               

      return dataset; 
   }
   
   public static void main( String[ ] args ) {
      _03BarChart_AWT chart = new _03BarChart_AWT("Car Usage Statistics", 
         "Which car do you like?");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}
```

## 04 Bar Chart Export Image
```java
import java.io.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtilities;

public class _04BarChartExportImage {
   
   public static void main( String[ ] args )throws Exception {
      final String fiat = "FIAT";
      final String audi = "AUDI";
      final String ford = "FORD";
      final String speed = "Speed";
      final String millage = "Millage";
      final String userrating = "User Rating";
      final String safety = "safety";

      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      dataset.addValue( 1.0 , fiat , speed );
      dataset.addValue( 3.0 , fiat , userrating );
      dataset.addValue( 5.0 , fiat , millage );
      dataset.addValue( 5.0 , fiat , safety );

      dataset.addValue( 5.0 , audi , speed );
      dataset.addValue( 6.0 , audi , userrating );
      dataset.addValue( 10.0 , audi , millage );
      dataset.addValue( 4.0 , audi , safety );

      dataset.addValue( 4.0 , ford , speed );
      dataset.addValue( 2.0 , ford , userrating );
      dataset.addValue( 3.0 , ford , millage );
      dataset.addValue( 6.0 , ford , safety );

      JFreeChart barChart = ChartFactory.createBarChart(
         "CAR USAGE STATIStICS", 
         "Category", "Score", 
         dataset,PlotOrientation.VERTICAL, 
         true, true, false);
         
      int width = 640;    /* Width of the image */
      int height = 480;   /* Height of the image */ 
      File BarChart = new File( "BarChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
   }
}
```

## 05 LineChart_AWT
```java
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class _05LineChart_AWT extends ApplicationFrame {

   public _05LineChart_AWT( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Years","Number of Schools",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      dataset.addValue( 15 , "schools" , "1970" );
      dataset.addValue( 30 , "schools" , "1980" );
      dataset.addValue( 60 , "schools" ,  "1990" );
      dataset.addValue( 120 , "schools" , "2000" );
      dataset.addValue( 240 , "schools" , "2010" );
      dataset.addValue( 300 , "schools" , "2014" );
      return dataset;
   }
   
   public static void main( String[ ] args ) {
      _05LineChart_AWT chart = new _05LineChart_AWT(
         "School Vs Years" ,
         "Numer of Schools vs years");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
   }
}
```

## 06 Line Chart Export Image
```java
import java.io.*;

import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class _06LineChartExportImage {

   public static void main( String[ ] args ) throws Exception {
      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
      line_chart_dataset.addValue( 15 , "schools" , "1970" );
      line_chart_dataset.addValue( 30 , "schools" , "1980" );
      line_chart_dataset.addValue( 60 , "schools" , "1990" );
      line_chart_dataset.addValue( 120 , "schools" , "2000" );
      line_chart_dataset.addValue( 240 , "schools" , "2010" ); 
      line_chart_dataset.addValue( 300 , "schools" , "2014" );

      JFreeChart lineChartObject = ChartFactory.createLineChart(
         "Schools Vs Years","Year",
         "Schools Count",
         line_chart_dataset,PlotOrientation.VERTICAL,
         true,true,false);

      int width = 1920;    /* Width of the image */
      int height = 1080;   /* Height of the image */ 
      File lineChart = new File( "LineChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
   }
}
```

## 07 XYLineChart_AWT
```java
import java.awt.Color; 
import java.awt.BasicStroke; 

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class _07XYLineChart_AWT extends ApplicationFrame {

   public _07XYLineChart_AWT( String applicationTitle, String chartTitle ) {
      super(applicationTitle);
      JFreeChart xylineChart = ChartFactory.createXYLineChart(
         chartTitle ,
         "Category" ,
         "Score" ,
         createDataset() ,
         PlotOrientation.VERTICAL ,
         true , true , false);
         
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.RED );
      renderer.setSeriesPaint( 1 , Color.GREEN );
      renderer.setSeriesPaint( 2 , Color.YELLOW );
      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
      renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
      plot.setRenderer( renderer ); 
      setContentPane( chartPanel ); 
   }
   
   private XYDataset createDataset( ) {
      final XYSeries firefox = new XYSeries( "Firefox" );          
      firefox.add( 1.0 , 1.0 );          
      firefox.add( 2.0 , 4.0 );          
      firefox.add( 3.0 , 3.0 );          
      
      final XYSeries chrome = new XYSeries( "Chrome" );          
      chrome.add( 1.0 , 4.0 );          
      chrome.add( 2.0 , 5.0 );          
      chrome.add( 3.0 , 6.0 );          
      
      final XYSeries iexplorer = new XYSeries( "InternetExplorer" );          
      iexplorer.add( 3.0 , 4.0 );          
      iexplorer.add( 4.0 , 5.0 );          
      iexplorer.add( 5.0 , 4.0 );          
      
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( firefox );          
      dataset.addSeries( chrome );          
      dataset.addSeries( iexplorer );
      return dataset;
   }

   public static void main( String[ ] args ) {
      _07XYLineChart_AWT chart = new _07XYLineChart_AWT("Browser Usage Statistics",
         "Which Browser are you using?");
      chart.pack( );          
      RefineryUtilities.centerFrameOnScreen( chart );          
      chart.setVisible( true ); 
   }
}
```

## 08 XY Line Chart image Export
```java
import java.io.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartUtilities; 

public class _08XYLineChart_imageExport {

   public static void main( String[ ] args )throws Exception {
      final XYSeries firefox = new XYSeries( "Firefox" );
      firefox.add( 1.0 , 1.0 );
      firefox.add( 2.0 , 4.0 );
      firefox.add( 3.0 , 3.0 );
      
      final XYSeries chrome = new XYSeries( "Chrome" );
      chrome.add( 1.0 , 4.0 );
      chrome.add( 2.0 , 5.0 );
      chrome.add( 3.0 , 6.0 );
      
      final XYSeries iexplorer = new XYSeries( "InternetExplorer" );
      iexplorer.add( 3.0 , 4.0 );
      iexplorer.add( 4.0 , 5.0 );
      iexplorer.add( 5.0 , 4.0 );
      
      final XYSeriesCollection dataset = new XYSeriesCollection( );
      dataset.addSeries( firefox );
      dataset.addSeries( chrome );
      dataset.addSeries( iexplorer );

      JFreeChart xylineChart = ChartFactory.createXYLineChart(
         "Browser usage statastics", 
         "Category",
         "Score", 
         dataset,
         PlotOrientation.VERTICAL, 
         true, true, false);
      
      int width = 640;   /* Width of the image */
      int height = 480;  /* Height of the image */ 
      File XYChart = new File( "XYLineChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);
   }
}
```
## 
```java

```
## 
```java

```
## 
```java

```
## 
```java

```
## 
```java

```
## 
```java

```
## 
```java

```



