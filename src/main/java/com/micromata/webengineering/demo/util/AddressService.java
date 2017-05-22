package com.micromata.webengineering.demo.util;

import java.net.InetAddress;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


// Helper functions to retrieve the server's hostname, ip and port for the running application.
// a google search for "spring boot get host an ip".
@Service
@Configuration
public class AddressService implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {
	private int port;
	
	/*
	 * Return the host address as an IP Address.
	 * 
	 * @return address
	 */
	public String getHostAdress() {
		return InetAddress.getLoopbackAddress().getHostAddress();
	}
	
	/*
	 * Return the host address as a DNS-resolvable name.
	 * 
	 * @return address
	 */
	public String getHostName() {
		return InetAddress.getLoopbackAddress().getHostName();
	}
	
	/*
	 * Return the port of the application.
	 * 
	 * @return port
	 */
	public int getPort(){
		return port;
	}

	/*
	 * This method is called when a particular event (noted in the interface) is executed. 
	 * In our case, the event was the start of the embedded application container as statet in the generic parameter.
	 * 
	 * @param event the occurred event
	 */
	@Override
	public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
		port = event.getEmbeddedServletContainer().getPort();
		
	}
}
