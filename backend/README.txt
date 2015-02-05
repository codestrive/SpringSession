Technology Stack
--------------------------
1. Spring Boot
2. Spring REST
3. Tomcat (Embedded) 
4. Mysql 
5. Maven

Way to Test Application (till date 25th Dec 2014) 
--------------------------------------------------
Step 1. Import and build the Application (Backend project) in Maven
Step 2. Run the SQL scripts from Backend/SQL directory to MYSQL DATABASE 
Step 3. Configure the MYSQL credential in com.dev.backend.Application.java  (it is hardcoded till now) 
Step 4. Run the com.dev.backend.Application.java as a java program and the Test the Products scenario (only backend with REST)
		Product URL are :
		http://localhost:8080/product/    Request Type : GET
		http://localhost:8080/product/product?code=p002  Request Type : DELETE 
		and So on ..
		

		
		


