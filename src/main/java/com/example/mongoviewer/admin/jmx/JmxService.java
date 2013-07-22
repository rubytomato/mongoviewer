package com.example.mongoviewer.admin.jmx;

import java.io.IOException;
import java.util.Set;

import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class JmxService {
	private static Logger logger = LoggerFactory.getLogger(JmxService.class);

	public static final String TRIVIA_SERVER_ADDRESS = "service:jmx:rmi://localhost/jndi/rmi://localhost:1099/myconnector";

	private MBeanServerConnection connection;


	public void execute() {
		logger.debug("execute IN");

		try {

			JMXServiceURL url = new JMXServiceURL(TRIVIA_SERVER_ADDRESS);
			JMXConnector connector = JMXConnectorFactory.connect(url, null);
			connection = connector.getMBeanServerConnection();

			 Set<ObjectInstance> mbeans = connection.queryMBeans(null, null);

			for (Object obj: mbeans) {
				ObjectInstance objInstance = (ObjectInstance)obj;
				System.out.println("Name: " + objInstance.getObjectName());
				System.out.println("Class: " + objInstance.getClassName());

				showMBeanInfo(objInstance.getObjectName());

			}

			System.out.println();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.debug("execute OUT");
	}

	private void showMBeanInfo(ObjectName name) {

		try {
			MBeanInfo info = connection.getMBeanInfo(name);
			String description = info.getDescription();
			System.out.println("Description: " + description);

			showMBeanAttributeInfo(info);
			//showMBeanConstructorInfo(info);
			//showMBeanOperationInfo(info);
			//showMBeanNotificationInfo(info);

		} catch (InstanceNotFoundException | IntrospectionException
				| ReflectionException | IOException e) {
			e.printStackTrace();
		}

	}

	private void showMBeanAttributeInfo(MBeanInfo info) {
		MBeanAttributeInfo[] attributes = info.getAttributes();

		if (attributes.length > 0) {
			System.out.println("Attributes:");

			for (MBeanAttributeInfo attribute: attributes) {
				System.out.println("    Name: " + attribute.getName());
				System.out.println("    Description: " + attribute.getDescription());
				System.out.println("    Type: " + attribute.getType());
				if (attribute.isReadable()) {
					if (attribute.isWritable()) {
						System.out.println("    Access: RW");
					} else {
						System.out.println("    Access: RO");
					}
				} else {
					if (attribute.isWritable()) {
						System.out.println("    Access: WO");
					}
				}
				System.out.println();
			}
		}
	}

}
