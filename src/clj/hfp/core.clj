(ns hfp.core
  (:require [aleph.http :as http]
            [manifold.deferred :as d]
            [manifold.stream :as s])
  (:gen-class))


(defn date-handler [req]
  (let [dates (s/periodically 1000 #(str (java.util.Date.)))
        socket @(http/websocket-connection req)]
    (s/connect dates socket)))

(comment
  ;; Create a websocket server using the date handler
  (def server (http/start-server date-handler {:port 5000}))

  ;; Create a test websocket client
  (def client @(http/websocket-client "ws://localhost:5000"))

  ;; Consume a value from the socket
  (s/take! client)

  ;; Close the client and server
  (.close client)
  (.close server))
