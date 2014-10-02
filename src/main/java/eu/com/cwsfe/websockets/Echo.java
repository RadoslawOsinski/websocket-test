package eu.com.cwsfe.websockets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnOpen;

/**
 * Created by Radosław Osiński
 */
@ServerEndpoint("/echo")
public class Echo {

    private static final Logger LOG = LogManager.getLogger(Echo.class);

    private Session session;

    @OnOpen
    public void connect(Session session) {
        this.session = session;
    }

    @OnClose
    public void close() {
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) {
        LOG.info("Received message: " + message);
        this.session.getAsyncRemote().sendText("Echo: " + message);
    }
}
