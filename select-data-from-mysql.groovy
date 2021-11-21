import java.sql.*; 
@Grab('mysql:mysql-connector-java:5.1.6')
 @GrabConfig(systemClassLoader=true)
 import groovy.sql.Sql
class Example { 
   static void main(String[] args) {
      // Creating a connection to the database
      def sql = Sql.newInstance('jdbc:mysql://localhost:3306/mysql', 'root',  
         'srinadh', 'com.mysql.jdbc.Driver')
         def versions_list = []
      sql.eachRow('select * from employee') {
         tp -> 
         println([tp.empid,tp.empname,tp.empaddress])
         versions_list.add(tp.empid)
     }
     for (String version : versions_list) {
		println ("${version}")
	}
      sql.close() 
   } 
}