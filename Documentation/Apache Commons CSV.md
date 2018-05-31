### https://commons.apache.org/proper/commons-csv/user-guide.html
### https://commons.apache.org/proper/commons-csv/project-reports.html
### https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html
### https://dzone.com/articles/working-with-csv-files-in-java-using-apache-common
### https://www.callicoder.com/java-read-write-csv-file-apache-commons-csv/

        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-csv</artifactId>
            <version>1.5</version>
        </dependency>



#### 01 Create CSV File

```java
package com.companyname.ApacheCommonsCSV;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class _01CreateCSVFile {

    public static void main(String[] args) throws IOException {
        //We have to create the CSVPrinter class object 
        Writer writer = Files.newBufferedWriter(Paths.get("studentMain.csv"));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Student Name", "Fees", "Student ID"));
        csvPrinter.flush();
        System.out.println("create csv successfully");
    }
}
```

#### 02 Write CSV file

```java
package com.companyname.ApacheCommonsCSV;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class _02WriteCSVfile {

    public static void main(String[] args) throws IOException {
        //We have to create the CSVPrinter class object 
        Writer writer = Files.newBufferedWriter(Paths.get("student.csv"));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Student Name", "Fees"));
        //Writing records in the generated CSV file
        csvPrinter.printRecord("Akshay Sharma", 1000);
        csvPrinter.printRecord("Rahul Gupta", 2000);
        csvPrinter.printRecord("Jay Karn", 3000);
        //Writing records in the form of a list
        csvPrinter.printRecord(Arrays.asList("Dev Bhatia", 4000));
        csvPrinter.flush();
        System.out.println("Write csv successfully");
    }
}
```

#### 03 Generatinga CSV file

```java
package com.companyname.ApacheCommonsCSV;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class _03GeneratingaCSVfile {
    private static final String SAMPLE_CSV_FILE = "users.csv";
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Name", "Email", "Phone", "Country"));
        csvPrinter.printRecord("Abdullah", "cm@gmail.com", "+880117", "Japan");
        csvPrinter.printRecord("Abida", "abida@gmail.com", "+880172", "Japan");
        csvPrinter.printRecord("Rafid", "rafid@gmail.com", "+880173", "Japan");
        csvPrinter.printRecord(Arrays.asList("Sami", "sami@gmail.com", "+880171", "garmany"));
        csvPrinter.flush();
        System.out.println("Done done");
    }
}
```

#### 04 Read CSV

```java
package com.companyname.ApacheCommonsCSV;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class _04ReadCSV {
//Reading a CSV file (Access Values by Names assigned to each column)
    public static void main(String[] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("student.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Student Name", "Fees").withIgnoreHeaderCase().withTrim());
        for (CSVRecord csvRecord: csvParser) {
            // Accessing Values by Column Index
            String name = csvRecord.get(0);
            //Accessing the values by column header name
            String fees = csvRecord.get("fees");
            //String fees = csvRecord.get(1);
            //Printing the record 
            System.out.println("Record Number - " + csvRecord.getRecordNumber());
            System.out.println("Name : " + name);
            System.out.println("Fees : " + fees);
            System.out.println("\n\n");
        }
    }
}
```

#### 05 Reading a CSV file Access Values by Column Index

```java
package com.companyname.ApacheCommonsCSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class _05ReadingaCSVfile_AccessValuesbyColumnIndex {
    private static final String SAMPLE_CSV_FILE_PATH = "users.csv";
    public static void main(String[] args) throws IOException {
        
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

        for (CSVRecord csvRecord : csvParser) {
            // Accessing Values by Column Index
            String name = csvRecord.get(0);
            String email = csvRecord.get(1);
            String phone = csvRecord.get(2);
            String country = csvRecord.get(3);

            System.out.println("Record No - " + csvRecord.getRecordNumber());
            System.out.println("---------------");
            System.out.println("Name : " + name);
            System.out.println("Email : " + email);
            System.out.println("Phone : " + phone);
            System.out.println("Country : " + country);
            System.out.println("---------------\n\n");
        }
    }
}
```

#### 06 Readinga CSV file Access Values By Names Assigned To Each Column

```java
package com.companyname.ApacheCommonsCSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class _06ReadingaCSVfileAccessValuesByNamesAssignedToEachColumn {
    private static final String SAMPLE_CSV_FILE_PATH = "users.csv";
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("Name", "Email", "Phone", "Country")
                .withIgnoreHeaderCase()
                .withTrim());
        for (CSVRecord csvRecord : csvParser) {
            // Accessing values by the names assigned to each column
            String name = csvRecord.get("Name");
            String email = csvRecord.get("Email");
            String phone = csvRecord.get("Phone");
            String country = csvRecord.get("Country");

            System.out.println("Record No - " + csvRecord.getRecordNumber());
            System.out.println("---------------");
            System.out.println("Name : " + name);
            System.out.println("Email : " + email);
            System.out.println("Phone : " + phone);
            System.out.println("Country : " + country);
            System.out.println("---------------\n\n");
        }
    }

}
```

#### 07 Reading a CSV file With Header Auto Detection Access Values By Header Names

```java
package com.companyname.ApacheCommonsCSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/****
 * It’s very easy to read such CSV files with Apache Commons CSV. 
 * You just need to add a single setting called withFirstRecordAsHeader().
 * 
 * 
 * */
public class _07ReadingaCSVfileWithHeaderAutoDetectionAccessValuesByHeaderNames {
    private static final String SAMPLE_CSV_FILE_PATH = "users.csv";
    public static void main(String[] args) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim());


        for (CSVRecord csvRecord : csvParser) {
            // Accessing values by Header names
            String name = csvRecord.get("Name");
            String email = csvRecord.get("Email");
            String phone = csvRecord.get("Phone");
            String country = csvRecord.get("Country");

            System.out.println("Record No - " + csvRecord.getRecordNumber());
            System.out.println("---------------");
            System.out.println("Name : " + name);
            System.out.println("Email : " + email);
            System.out.println("Phone : " + phone);
            System.out.println("Country : " + country);
            System.out.println("---------------\n\n");
        }
    }
}
```

#### 

```java

```


