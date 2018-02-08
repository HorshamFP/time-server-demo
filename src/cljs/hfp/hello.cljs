(ns hfp.hello
  (:require [clojure.browser.dom :as dom]))

(enable-console-print!)


(defn start-ticking []
  (let [ws (js/WebSocket. "ws://localhost:5000")
        el (dom/get-element "content")]
    (set! (.-onmessage ws)
      (fn [event] (dom/set-text el (str (.-data event)))))
    ws))

(println "Hello, world!")
