# HorshamFP: Time Server Demo

A simple demo of a client in ClojureScript and server in Clojure to
stream the current time to the browser.

## Installation

You need Java 8 installed first. Go do that if you don't.

Then clone this repo:

    $ git clone https://github.com/HorshamFP/time-server-demo.git

To run the demo, you will need to install the following: Clojure,
Leiningen and rlwrap. On a Mac this is a case of running:

    $ brew install clojure leiningen rlwrap

On Linux, I refer you to the official instructions here:
https://clojure.org/guides/getting_started#_installation_on_linux

## Usage

These instructions are editor neutral. You do not need Emacs or Cider to
run this demo.

    $ cd time-server-demo
    $ lein repl


You should see a welcome message and a prompt that looks like this:
`hfp.core=>`

At the prompt type the following and hit enter:

    hfp.core=> (def server (http/start-server date-handler {:port 5000}))

That will start the websocket server.

To start the client, open up a second terminal in the project root
directory and type the following:

    $ rlwrap java -cp lib/cljs.jar:src clojure.main repl.clj

That may look a little convoluted but it can be broken down as follows:

1. `rlwrap` is a 'readline wrapper'. It gives you history and a
   friendlier command line experience.
2. `java` is, well, Java, but here you're putting the ClojureScript jar
   file on the classpath and telling clojure.main to compile and execute
   the `repl.clj` script

The above command should present you with the following message

~~~~
Compiling client js ...
Serving HTTP on localhost port 9000
Listening for browser REPL connect ...
~~~~

In your browser go to `http://localhost:9000/`

You should then see the heading "What's the time?" in your browser and
the following output in your terminal

~~~~
Watch compilation log available at: out/watch.log
To quit, type: :cljs/quit
cljs.user=>
~~~~

At the repl prompt type the following to start the clock ticking:

    cljs.user=> (require 'hfp.time)
    cljs.user=> (hfp.time/start-ticking)

In your browser, you should now see the heading update with the current
time once per second.

## License

Creative Commons Attribution Share-Alike 4.0 International
