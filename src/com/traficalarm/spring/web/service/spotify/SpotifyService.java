package com.traficalarm.spring.web.service.spotify;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SpotifyService {
	
	final String scope = "user-read-private user-read-email";
    final String callback = "http://localhost:8888";
    
    @Value("${spotify.clientid}")
    private String clientId;
    @Value("${spotify.clientsecret}")
    private String clientSecret;
    @Value("${spotify.defaultport}")
    private String spotifyPort;
    @Value("${spotify.defaulthost}")
    private String defaultHost;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getSpotifyPort() {
		return spotifyPort;
	}
	public void setSpotifyPort(String spotifyPort) {
		this.spotifyPort = spotifyPort;
	}
	public String getDefaultHost() {
		return defaultHost;
	}
	public void setDefaultHost(String defaultHost) {
		this.defaultHost = defaultHost;
	}
	public String getScope() {
		return scope;
	}
	public String getCallback() {
		return callback;
	}
    
    
    
    
    
    
    
    
    
}
