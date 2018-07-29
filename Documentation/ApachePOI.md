# Apache POI API

> https://www.apache.org/dyn/closer.lua/poi/release/bin/poi-bin-3.17-20170915.tar.gz

01. Create Blank Workbook
02. Open Existing Workbook
03. Write Into a Spreadsheet
04. Read From a Spreadsheet
05. Create a Cell
06. Cell Styles (not working)
07. Fonts and Font Styles
08. Text Direction
09. Formula
10. Hyperlink EX (not working)
11. Print Area
12. Write Into Excel From Database

#Dependency
		  <dependency>
		    <groupId>org.apache.poi</groupId>
		    <artifactId>poi-ooxml</artifactId>
		    <version>3.15</version>
		  </dependency>



## 01 Create Blank Workbook
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _01CreateBlankWorkbook {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		//Create Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		//Create file system using specific name 
		FileOutputStream out = new FileOutputStream(new File("createworkbook.xlsx")); 
		//write operation workbook using file out object 
		workbook.write(out);
		out.close();
		System.out.println("createworkbook.xlsx written successfully");
	}
}
```
## 02 Open Existing Workbook
```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _02OpenExistingWorkbook {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("/Users/abdullah/Documents/ServletAndJsp/ApachePOI/createworkbook.xlsx"); 
		FileInputStream fIP = new FileInputStream(file);
		//Get the workbook instance for XLSX file
		XSSFWorkbook workbook = new XSSFWorkbook(fIP);
		if(file.isFile() && file.exists()) {
			System.out.println("openworkbook.xlsx file open successfully.");
		}
		else{
			System.out.println("Error to open openworkbook.xlsx file.");
		}
	}
}
```
## 03 Write Into a Spreadsheet
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _03WriteIntoASpreadsheet {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		//Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet( " Employee Info ");
		//Create row object
		XSSFRow row;
		//This data needs to be written (Object[])
		Map < String, Object[] > empinfo =  new TreeMap < String, Object[] >();
		empinfo.put( "1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
		empinfo.put( "2", new Object[] { "tp01", "Gopal", "Technical Manager" });
		empinfo.put( "3", new Object[] { "tp02", "Manisha", "Proof Reader" });
		empinfo.put( "4", new Object[] { "tp03", "Masthan", "Technical Writer" });
		empinfo.put( "5", new Object[] { "tp04", "Satish", "Technical Writer" });
		empinfo.put( "6", new Object[] { "tp05", "Krishna", "Technical Writer" });
		//Iterate over data and write to sheet
		Set < String > keyid = empinfo.keySet();
		int rowid = 0;
		for (String key : keyid){
			row = spreadsheet.createRow(rowid++);
			Object [] objectArr = empinfo.get(key);
			int cellid = 0;
			for (Object obj : objectArr)	{
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String)obj);
			} 
		}
		//Write the workbook in file system
		FileOutputStream out = new FileOutputStream( new File("Writesheet.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("Writesheet.xlsx written successfully" );
	}
}
```
## 04 Read From a Spreadsheet
```java
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _04ReadFromASpreadsheet {
	static XSSFRow row;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(
				new File("/Users/abdullah/Documents/ServletAndJsp/ApachePOI/WriteSheet.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		XSSFSheet spreadsheet = workbook.getSheetAt(0); 
		Iterator < Row > rowIterator = spreadsheet.iterator(); 
		while (rowIterator.hasNext()){
			row = (XSSFRow) rowIterator.next();
			Iterator < Cell > cellIterator = row.cellIterator();
			while ( cellIterator.hasNext()) {
				Cell cell = cellIterator.next(); 
				switch (cell.getCellType()){
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print( cell.getNumericCellValue() + " \t\t " ); 
					break;
				case Cell.CELL_TYPE_STRING: 
					System.out.print( cell.getStringCellValue() + " \t\t " );
					break;
				} 
			}
			System.out.println(); 
		}
		fis.close();
	}
}
```
## 05 Create a Cell
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _05CreateACell {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("cell types"); 
		XSSFRow row = spreadsheet.createRow((short) 2); 
		row.createCell(0).setCellValue("Type of Cell");
		row.createCell(1).setCellValue("cell value");
		row = spreadsheet.createRow((short) 3); 
		row.createCell(0).setCellValue("set cell type BLANK"); 
		row.createCell(1);
		row = spreadsheet.createRow((short) 4); 
		row.createCell(0).setCellValue("set cell type BOOLEAN"); 
		row.createCell(1).setCellValue(true);
		row = spreadsheet.createRow((short) 5); 
		row.createCell(0).setCellValue("set cell type ERROR"); 
		row.createCell(1).setCellValue(XSSFCell.CELL_TYPE_ERROR ); 
		row = spreadsheet.createRow((short) 6); 
		row.createCell(0).setCellValue("set cell type date");
		row.createCell(1).setCellValue(new Date());
		row = spreadsheet.createRow((short) 7);
		row.createCell(0).setCellValue("set cell type numeric" ); 
		row.createCell(1).setCellValue(20 );
		row = spreadsheet.createRow((short) 8); 
		row.createCell(0).setCellValue("set cell type string"); 
		row.createCell(1).setCellValue("A String");
		
		FileOutputStream out = new FileOutputStream( new File("typesofcells.xlsx"));
		workbook.write(out); out.close(); 
		System.out.println("typesofcells.xlsx written successfully");	
	}
}
```
## 06 Cell Styles (not working)
```java
import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
public class _06CellStyles {

	public static void main(String[] args) {
		/***
	    XSSFWorkbook workbook = new XSSFWorkbook(); 
	      XSSFSheet spreadsheet = workbook.createSheet("cellstyle");
	      XSSFRow row = spreadsheet.createRow((short) 1);
	      row.setHeight((short) 800);
	      XSSFCell cell = (XSSFCell) row.createCell((short) 1);
	      cell.setCellValue("test of merging");

	      //MEARGING CELLS 
	      //this statement for merging cells

	      spreadsheet.addMergedRegion(
	         new CellRangeAddress(
	            1, //first row (0-based)
	            1, //last row (0-based)
	            1, //first column (0-based)
	            4 //last column (0-based)
	         )
	      );
	      
	      //CELL Alignment
	      row = spreadsheet.createRow(5); 
	      cell = (XSSFCell) row.createCell(0);
	      row.setHeight((short) 800);
	      
	      // Top Left alignment 
	      XSSFCellStyle style1 = workbook.createCellStyle();
	      spreadsheet.setColumnWidth(0, 8000);
	      style1.setAlignment(XSSFCellStyle.ALIGN_LEFT);
	      style1.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
	      cell.setCellValue("Top Left");
	      cell.setCellStyle(style1);
	      row = spreadsheet.createRow(6); 
	      cell = (XSSFCell) row.createCell(1);
	      row.setHeight((short) 800);
	      
	      // Center Align Cell Contents 
	      XSSFCellStyle style2 = workbook.createCellStyle();
	      style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
	      style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
	      cell.setCellValue("Center Aligned"); 
	      cell.setCellStyle(style2);
	      row = spreadsheet.createRow(7); 
	      cell = (XSSFCell) row.createCell(2);
	      row.setHeight((short) 800);
	      
	      // Bottom Right alignment 
	      XSSFCellStyle style3 = workbook.createCellStyle();
	      style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
	      style3.setVerticalAlignment(XSSFCellStyle.VERTICAL_BOTTOM);
	      cell.setCellValue("Bottom Right");
	      cell.setCellStyle(style3);
	      row = spreadsheet.createRow(8);
	      cell = (XSSFCell) row.createCell(3);
	      
	      // Justified Alignment 
	      XSSFCellStyle style4 = workbook.createCellStyle();
	      style4.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
	      style4.setVerticalAlignment(XSSFCellStyle.VERTICAL_JUSTIFY);
	      cell.setCellValue("Contents are Justified in Alignment"); 
	      cell.setCellStyle(style4);
	      
	      //CELL BORDER
	      row = spreadsheet.createRow((short) 10);
	      row.setHeight((short) 800);
	      cell = (XSSFCell) row.createCell((short) 1);
	      cell.setCellValue("BORDER");
	      
	      XSSFCellStyle style5 = workbook.createCellStyle();
	      style5.setBorderBottom(XSSFCellStyle.BORDER_THICK);
	      style5.setBottomBorderColor(IndexedColors.BLUE.getIndex());
	      style5.setBorderLeft(XSSFCellStyle.BORDER_DOUBLE);
	      style5.setLeftBorderColor(IndexedColors.GREEN.getIndex());
	      style5.setBorderRight(XSSFCellStyle.BORDER_HAIR);
	      style5.setRightBorderColor(IndexedColors.RED.getIndex());
	      style5.setBorderTop(XSSFCellStyle.BIG_SPOTS);
	      style5.setTopBorderColor(IndexedColors.CORAL.getIndex());
	      cell.setCellStyle(style5);
	      
	      //Fill Colors
	      //background color
	      row = spreadsheet.createRow((short) 10 );
	      cell = (XSSFCell) row.createCell((short) 1);
	      
	      XSSFCellStyle style6 = workbook.createCellStyle();
	      style6.setFillBackgroundColor(HSSFColor.LEMON_CHIFFON.index );
	      style6.setFillPattern(XSSFCellStyle.LESS_DOTS);
	      
	      style6.setFillPattern(XSSFCellStyle);
	      style6.setAlignment(XSSFCellStyle.ALIGN_FILL);
	      spreadsheet.setColumnWidth(1,8000);
	      cell.setCellValue("FILL BACKGROUNG/FILL PATTERN");
	      cell.setCellStyle(style6);
	      
	      //Foreground color
	      row = spreadsheet.createRow((short) 12);
	      cell = (XSSFCell) row.createCell((short) 1);
	      
	      XSSFCellStyle style7 = workbook.createCellStyle();
	      style7.setFillForegroundColor(HSSFColor.BLUE.index);
	      style7.setFillPattern( XSSFCellStyle.LESS_DOTS);
	      style7.setAlignment(XSSFCellStyle.ALIGN_FILL);
	      cell.setCellValue("FILL FOREGROUND/FILL PATTERN");
	      cell.setCellStyle(style7);

	      FileOutputStream out = new FileOutputStream(new File("cellstyle.xlsx"));
	      workbook.write(out);
	      out.close();
	      System.out.println("cellstyle.xlsx written successfully");
	      
	      ***/
	}
}
```
## 07 Fonts and Font Styles
```java
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell; 
import org.apache.poi.xssf.usermodel.XSSFCellStyle; 
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow; 
import org.apache.poi.xssf.usermodel.XSSFSheet; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class _07FontsAndFontStyles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("Fontstyle"); 
		XSSFRow row = spreadsheet.createRow(2);
		//Create a new font and alter it.
		XSSFFont font = workbook.createFont(); 
		font.setFontHeightInPoints((short) 30);
		font.setFontName("IMPACT"); font.setItalic(true); 
		font.setColor(HSSFColor.BRIGHT_GREEN.index);
		//Set font into style
		XSSFCellStyle style = workbook.createCellStyle(); 
		style.setFont(font);
		// Create a cell with a value and set style to it.
		XSSFCell cell = row.createCell(1);
		cell.setCellValue("Font Style");
		cell.setCellStyle(style);
		FileOutputStream out = new FileOutputStream( new File("fontstyle.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("fontstyle.xlsx written successfully");
	}
}
```
## 08 Text Direction
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class _08TextDirection {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet spreadsheet = workbook.createSheet("Text direction");
		XSSFRow row = spreadsheet.createRow(2);
		XSSFCellStyle myStyle = workbook.createCellStyle();
		myStyle.setRotation((short) 0);
		XSSFCell cell = row.createCell(1);
		cell.setCellValue("0D angle");
		cell.setCellStyle(myStyle);

		//30 degrees
		myStyle = workbook.createCellStyle();
		myStyle.setRotation((short) 30);
		cell = row.createCell(3);
		cell.setCellValue("30D angle");
		cell.setCellStyle(myStyle);

		//90 degrees
		myStyle = workbook.createCellStyle();
		myStyle.setRotation((short) 90);
		cell = row.createCell(5);
		cell.setCellValue("90D angle");
		cell.setCellStyle(myStyle);

		//120 degrees
		myStyle = workbook.createCellStyle();
		myStyle.setRotation((short) 120);
		cell = row.createCell(7);
		cell.setCellValue("120D angle");
		cell.setCellStyle(myStyle);

		//270 degrees
		myStyle = workbook.createCellStyle();
		myStyle.setRotation((short) 270);
		cell = row.createCell(9);
		cell.setCellValue("270D angle");
		cell.setCellStyle(myStyle);

		//360 degrees
		myStyle = workbook.createCellStyle();
		myStyle.setRotation((short) 360);
		cell = row.createCell(12);
		cell.setCellValue("360D angle");
		cell.setCellStyle(myStyle);

		FileOutputStream out = new FileOutputStream(new File("textdirection.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("textdirection.xlsx written successfully");
	}
}
```
## 09 Formula
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class _09Formula {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet spreadsheet = workbook.createSheet("formula");
		XSSFRow row = spreadsheet.createRow(1);
		XSSFCell cell = row.createCell(1);

		cell.setCellValue("A = ");
		cell = row.createCell(2);
		cell.setCellValue(2);
		row = spreadsheet.createRow(2);
		cell = row.createCell(1);
		cell.setCellValue("B = ");
		cell = row.createCell(2);
		cell.setCellValue(4);
		row = spreadsheet.createRow(3);
		cell = row.createCell(1);
		cell.setCellValue("Total = ");
		cell = row.createCell(2);

		// Create SUM formula
		cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
		cell.setCellFormula("SUM(C2:C3)");
		cell = row.createCell(3);
		cell.setCellValue("SUM(C2:C3)");
		row = spreadsheet.createRow(4);
		cell = row.createCell(1);
		cell.setCellValue("POWER =");
		cell=row.createCell(2);

		// Create POWER formula
		cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
		cell.setCellFormula("POWER(C2,C3)");
		cell = row.createCell(3);
		cell.setCellValue("POWER(C2,C3)");
		row = spreadsheet.createRow(5);
		cell = row.createCell(1);
		cell.setCellValue("MAX = ");
		cell = row.createCell(2);

		// Create MAX formula
		cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
		cell.setCellFormula("MAX(C2,C3)");
		cell = row.createCell(3);
		cell.setCellValue("MAX(C2,C3)");
		row = spreadsheet.createRow(6);
		cell = row.createCell(1);
		cell.setCellValue("FACT = ");
		cell = row.createCell(2);

		// Create FACT formula
		cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
		cell.setCellFormula("FACT(C3)");
		cell = row.createCell(3);
		cell.setCellValue("FACT(C3)");
		row = spreadsheet.createRow(7);
		cell = row.createCell(1);
		cell.setCellValue("SQRT = ");
		cell = row.createCell(2);

		// Create SQRT formula
		cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
		cell.setCellFormula("SQRT(C5)");
		cell = row.createCell(3);
		cell.setCellValue("SQRT(C5)");
		workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
		FileOutputStream out = new FileOutputStream(new File("formula.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("fromula.xlsx written successfully");
	}
}

```
## 10 Hyperlink EX
```java
import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class _10HyperlinkEX {

	public static void main(String[] args) throws Exception{
		
		/*****
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet spreadsheet = workbook.createSheet("Hyperlinks");
		XSSFCell cell;
		CreationHelper createHelper = workbook.getCreationHelper();
		XSSFCellStyle hlinkstyle = workbook.createCellStyle();
		XSSFFont hlinkfont = workbook.createFont();
		hlinkfont.setUnderline(XSSFFont.U_SINGLE);
		hlinkfont.setColor(HSSFColor.BLUE.index);
		hlinkstyle.setFont(hlinkfont);

		//URL Link
		cell = spreadsheet.createRow(1).createCell((short) 1);
		cell.setCellValue("URL Link");
		XSSFHyperlink link = (XSSFHyperlink)createHelper.createHyperlink(Hyperlink.LINK_URL);
		link.setAddress("http://www.tutorialspoint.com/");
		cell.setHyperlink((XSSFHyperlink) link);
		cell.setCellStyle(hlinkstyle);

		//Hyperlink to a file in the current directory
		cell = spreadsheet.createRow(2).createCell((short) 1);
		cell.setCellValue("File Link");
		link = (XSSFHyperlink)createHelper.createHyperlink(Hyperlink.LINK_FILE);
		link.setAddress("cellstyle.xlsx");
		cell.setHyperlink(link);
		cell.setCellStyle(hlinkstyle);

		//e-mail link
		cell = spreadsheet.createRow(3).createCell((short) 1);
		cell.setCellValue("Email Link");
		link = (XSSFHyperlink)createHelper.createHyperlink(Hyperlink.LINK_EMAIL);
		link.setAddress("mailto:contact@tutorialspoint.com?" + "subject = Hyperlink");
		cell.setHyperlink(link);
		cell.setCellStyle(hlinkstyle);

		FileOutputStream out = new FileOutputStream(new File("hyperlink.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("hyperlink.xlsx written successfully");
		
		****/
	}
}
```
## 11 Print Area
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _11PrintArea {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet spreadsheet = workbook.createSheet("Print Area");
		//set print area with indexes
		workbook.setPrintArea(
				0, //sheet index
				0, //start column
				5, //end column
				0, //start row
				5 //end row
				);
		//set paper size
		spreadsheet.getPrintSetup().setPaperSize(XSSFPrintSetup.A4_PAPERSIZE);
		//set display grid lines or not
		spreadsheet.setDisplayGridlines(true);
		//set print grid lines or not
		spreadsheet.setPrintGridlines(true);
		FileOutputStream out = new FileOutputStream(new File("printarea.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("printarea.xlsx written successfully"); 
	}
}
```
## 12 Write Into Excel From Database
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*****
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| EMP                |
| Khan               |
| MoviesDb           |
| MydbCm             |
| STUDENTS           |
| TestDb             |
| cmabdullah         |
| cmdb               |
| demo               |
| khanCm             |
| mydb               |
| mydbforeign        |
| mysql              |
| performance_schema |
| sonoo              |
| sys                |
+--------------------+
17 rows in set (0.00 sec)

mysql> use TestDb;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables ;
+------------------+
| Tables_in_testdb |
+------------------+
| Area             |
| Employee         |
| Equipment        |
| Problem          |
| Schedule         |
| employeeTable    |
| login            |
+------------------+
7 rows in set (0.00 sec)

mysql> select * from  TestDb.Employee;
+------------+--------------+-----------------+--------------+---------------+-------+------+--------+
| EmployeeId | EmployeeName | EmployeeAddress | EmployeeType | EmployeeEmail | uname | pass | AreaId |
+------------+--------------+-----------------+--------------+---------------+-------+------+--------+
|        201 | C M Abdullah | Amtali Barguna  |            1 | cm@gmail.com  | cma   | 20   |     40 |
|        202 | Tawhid Islam | Pabna           |            2 | tw@gmail.com  | tw    | 10   |     41 |
+------------+--------------+-----------------+--------------+---------------+-------+------+--------+
2 rows in set (0.00 sec)

mysql> describe Employee;
+-----------------+--------------+------+-----+---------+----------------+
| Field           | Type         | Null | Key | Default | Extra          |
+-----------------+--------------+------+-----+---------+----------------+
| EmployeeId      | int(11)      | NO   | PRI | NULL    | auto_increment |
| EmployeeName    | varchar(45)  | YES  |     | NULL    |                |
| EmployeeAddress | varchar(255) | YES  |     | NULL    |                |
| EmployeeType    | int(11)      | YES  |     | NULL    |                |
| EmployeeEmail   | varchar(45)  | YES  |     | NULL    |                |
| uname           | varchar(45)  | NO   |     | NULL    |                |
| pass            | varchar(45)  | NO   |     | NULL    |                |
| AreaId          | int(11)      | NO   | PRI | NULL    |                |
+-----------------+--------------+------+-----+---------+----------------+
8 rows in set (0.00 sec)

mysql> 

*****/
public class _12WriteIntoExcelFromDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database...");
		Connection conn = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/TestDb?autoReconnect=true&useSSL=false","root","rootcm");
		System.out.println("Creating statement...");
		Statement stmt = conn.createStatement();
		String sql = "SELECT EmployeeId, EmployeeName, EmployeeAddress, EmployeeType, EmployeeEmail,uname,  pass FROM Employee";
		ResultSet rs = stmt.executeQuery(sql);
		// csv
		
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet spreadsheet = workbook.createSheet("employe db");
		XSSFRow row = spreadsheet.createRow(1);
		XSSFCell cell;
		cell = row.createCell(1);
		cell.setCellValue("Employee Id");
		cell = row.createCell(2);
		cell.setCellValue("Employee Name");
		cell = row.createCell(3);
		cell.setCellValue("Employee Address");
		cell = row.createCell(4);
		cell.setCellValue("Employee Type");
		cell = row.createCell(5);
		cell.setCellValue("Employee Email");
		cell = row.createCell(6);
		cell.setCellValue("Employee Username");
		cell = row.createCell(7);
		cell.setCellValue("Employee Password");
		
		
		
		int i = 2;
		
		while(rs.next()){
			
			int id  = rs.getInt("EmployeeId");
			String ename = rs.getString("EmployeeName");
			String address = rs.getString("EmployeeAddress");
			int etype = rs.getInt("EmployeeType");
			String email = rs.getString("EmployeeEmail");
			String username = rs.getString("uname");
			String password = rs.getString("pass");

			System.out.print("ID: " + id);
			System.out.print(", Employee Name : " + ename);
			System.out.print(", Employee Degree: " + address);
			System.out.println(", Employee Type : " + etype);
			System.out.println(", Employee Email : " + email);
			System.out.println(", Username : " + username);
			System.out.println(", Password : " + password);
			// csv
			row = spreadsheet.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue(rs.getInt("EmployeeId"));
			cell = row.createCell(2);
			cell.setCellValue(rs.getString("EmployeeName"));
			cell = row.createCell(3);
			cell.setCellValue(rs.getString("EmployeeAddress"));
			cell = row.createCell(4);
			cell.setCellValue(rs.getString("EmployeeType"));
			cell = row.createCell(5);
			cell.setCellValue(rs.getString("EmployeeEmail"));
			cell = row.createCell(6);
			cell.setCellValue(rs.getString("uname"));
			
			cell = row.createCell(7);
			cell.setCellValue(rs.getString("pass"));
			i++;
		}
		FileOutputStream out = new FileOutputStream(new File("exceldatabase.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("exceldatabase.xlsx written successfully");

		System.out.println("Goodbye!");
	}
}
```
