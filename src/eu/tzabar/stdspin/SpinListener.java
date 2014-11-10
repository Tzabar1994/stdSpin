package eu.tzabar.stdspin;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

/**
 * Created by Dan on 10/11/2014.
 * It is part of stdSpin.
 */
public class SpinListener
{
    private int portNumber;
    private DatagramSocket socket;
    private byte[] buffer;
    private DatagramPacket packet;

    public SpinListener(int port)
    {
        portNumber = port;
        try
        {
            socket = new DatagramSocket(portNumber);
        }
        catch (SocketException e)
        {
            System.out.println(e.getMessage());
        }

        buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
    }

    public void receivePacket()
    {
        try
        {
            socket.receive(packet);
            System.out.println(Arrays.toString(packet.getData()));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
