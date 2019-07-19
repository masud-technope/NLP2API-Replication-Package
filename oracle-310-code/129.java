public class rlogin
{

    public static final void main(String[] args)
    {
        String server, localuser, remoteuser, terminal;
        RLoginClient client;

        if (args.length != 4)
        {
            System.err.println(
                "Usage: rlogin <hostname> <localuser> <remoteuser> <terminal>");
            System.exit(1);
            return ; // so compiler can do proper flow control analysis
        }

        client = new RLoginClient();

        server = args[0];
        localuser = args[1];
        remoteuser = args[2];
        terminal = args[3];

        try
        {
            client.connect(server);
        }
        catch (IOException e)
        {
            System.err.println("Could not connect to server.");
            e.printStackTrace();
            System.exit(1);
        }

        try
        {
            client.rlogin(localuser, remoteuser, terminal);
        }
        catch (IOException e)
        {
            try
            {
                client.disconnect();
            }
            catch (IOException f)
            {}
            e.printStackTrace();
            System.err.println("rlogin authentication failed.");
            System.exit(1);
        }


        IOUtil.readWrite(client.getInputStream(), client.getOutputStream(),
                         System.in, System.out);

        try
        {
            client.disconnect();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        System.exit(0);
    }

}