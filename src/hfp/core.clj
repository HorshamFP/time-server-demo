(ns hfp.core
  (:gen-class))



(def non-websocket-request
  {:status 400
   :headers {"content-type" "application/text"}
   :body "Expected a websocket request."})



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
