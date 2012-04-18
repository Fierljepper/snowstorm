package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 10:20 AM To change this template use File | Settings
 * | File Templates.
 */
public class SocketInfo extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("a70d731c-0b51-4778-bf17-b1cbba968629");

    private Collection<Socket> sockets;

    public Collection<Socket> getSockets() {
        return sockets;
    }

    public void setSockets(final Collection<Socket> sockets) {
        this.sockets = sockets;
    }
}
