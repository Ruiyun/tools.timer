(defproject ruiyun/tools.timer "1.0.1"
  :description "An easy to use Java Timer wrapper for clojure."
  :lein-release {:deploy-via :clojars}
  :warn-on-reflection true
  :min-lein-version "2.0.0"
  :url "http://github.com/Ruiyun/tools.timer"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.5.1"]]
                   :plugins [[codox "0.6.4"]]}})
