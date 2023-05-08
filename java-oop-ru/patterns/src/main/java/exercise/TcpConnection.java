package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection {
    private  String ip;
    private int port;
    public Connection currentState;

    TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.currentState = new Disconnected(this);
    }

    public String getCurrentState() {
        return this.currentState.getCurrentState();
    }

    public void connect() {
        this.currentState.connect();
    }

    public void disconnect() {
        this.currentState.disconnect();

    }

    public void write(String data) {
        this.currentState.write(data);
    }
}
// END
