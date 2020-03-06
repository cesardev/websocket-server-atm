package com.neo.mx.websocket.atm;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat-websocket")
			.setAllowedOrigins("*").withSockJS()
			.setDisconnectDelay(30 * 1000);
//				.setStreamBytesLimit(512 * 1024)
//	            .setHttpMessageCacheSize(1000);
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.setApplicationDestinationPrefixes("/app")
			.enableSimpleBroker("/chat/");
//			config.setPathMatcher(new AntPathMatcher("."));
	}

//	Autenticación
//	@Override
//	public void configureClientInboundChannel(ChannelRegistration registration) {
//		registration.setInterceptors(new ChannelInterceptorAdapter() {
//			@Override
//			public Message<?> preSend(Message<?> message, MessageChannel channel) {
//	
//	            StompHeaderAccessor accessor =
//	                MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
//	
//	            if (StompCommand.CONNECT.equals(accessor.getCommand())) {
//	                Principal user = ... ; // access authentication header(s)
//	                accessor.setUser(user);
//	            }
//	
//	            return message;
//	        }
//		});
//	}

}
