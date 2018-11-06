[![Travis](https://travis-ci.org/teverett/ktelnet.svg?branch=master)](https://travis-ci.org/teverett/ktelnet)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2ee879081835443fb2269a32dac0e795)](https://www.codacy.com/app/teverett/ktelnet?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=teverett/ktelnet&amp;utm_campaign=Badge_Grade)

# kTelnet

A Java library which inputs an RFC-compliant Telnet server.  The server is fully multithreaded and supports many of the Telnet RFC's.

## License
kTelnet is licensed under the BSD terms

## Maven Coordinates

```
<groupId>com.khubla.ktelnet</groupId>
<artifactId>ktelnet</artifactId>
<packaging>jar</packaging>
<version>1.0</version>
```

## Using kTelnet

A simple example using the default Telnet implementation:

<pre>
   private final static int THREADS = 20;
   private final static int PORT = 2121;

   public static void main(String[] args) {
      try {
         /*
          * telnet
          */
         final TelnetServer telnetServer = new TelnetServer(PORT, THREADS, new BasicShellFactoryImpl());
         telnetServer.start();
         /*
          * wait
          */
         Thread.sleep(1000);
         System.out.println("Press any key to exit");
         System.in.read();
         /*
          * shutdown
          */
         telnetServer.shutdown();
      } catch (final Exception e) {
         e.printStackTrace();
         System.exit(0);
      }
</pre>

## Login
Login is implemented by passing an implementation of `AuthenticationHandler` to the shell constructor.  A simple properties file based implementation `PropertiesFileAuthenticationHandlerImpl` is provided.

## Custom shells

Custom shells can be implemented by extending the classes `ShellFactory`, `BasicTelnetCommandRegistryImpl` and `AbstractCommand`.  A very simple shell which implements the "quit" command is provided: `BasicShellImpl`

## Logging

kTelnet supports logging at the byte level via `NVTSpy`.  A console implementation `ConsoleNVTSpyImpl` and a log file implementation `LoggingNVTSpyImpl` are provided.
