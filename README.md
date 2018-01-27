# AKMS
manage Activation Key for customers



    #/cust/Customer
    customer page contains (Customer Name , Phone No ,Email )
    #/cust/key
    page to manage Customer Keys and the default status for post activation key is (Not Sent).

    every 1 min the thread check activation Table to Select New Activation Key and Send to Specific Customer if the doen't have that key
   
  
#Configration
	file:com.cust.config.ApplicationConfig.java
	to set email and pass

	file:ApplicationContexr.xml
	lines:<bean id="t" class="com.cust.service.ScheduledTasks">
	</bean>
	<task:scheduled-tasks>
		<task:scheduled ref="t" method="sendkeys" fixed-delay="60000" />
	</task:scheduled-tasks>	
	to set thread delay now 60000m = 1min
Application uses Spring webmvc,hibernate and mysql database
