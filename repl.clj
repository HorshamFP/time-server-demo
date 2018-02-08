(require 'cljs.repl)
(require 'cljs.build.api)
(require 'cljs.repl.browser)

(cljs.build.api/build "src/cljs"
  {:main 'hfp.time
   :output-to "out/main.js"
   :browser-repl true
   :verbose true})

(cljs.repl/repl (cljs.repl.browser/repl-env)
  :watch "src/cljs"
  :output-dir "out")
