import java.sql.*; 
import groovy.sql.Sql
@Grapes(
    @Grab(group='mysql', module='mysql-connector-java', version='5.1.6')
)
@GrabConfig(systemClassLoader=true)
 // Creating a connection to the database
      def sql = Sql.newInstance('jdbc:mysql://localhost:3306/releaseinfodb', 'root',  
         'srinadh', 'com.mysql.jdbc.Driver')
      println("connection successful")
      def release_info_list=[]
      sql.eachRow('select * from release_info_tbl') { row ->
     release_info_list.add(row.release_version)
 }
 for (String version : release_info_list) {
		println ("${version}")
	}
    sql.close() 