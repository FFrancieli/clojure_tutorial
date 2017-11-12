(defproject clojure_tutorial "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.2.0"]]

  :plugins      [[lein-ring "0.8.7"]]
  :ring         { :handler clojure-tutorial.core/route-handler
                  :init    clojure-tutorial.core/on-init
                  :destroy clojure-tutorial.core/on-destroy})
