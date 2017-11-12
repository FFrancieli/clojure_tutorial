(ns clojure-tutorial.core)

(defn example-handler [request]
  {:headers {"Location" "https://github.com/ring-clojure/ring"
           "Set-cookie" "test=1"}
    :status 301})
(defn on-init[]
  println "Initializing sample web app...")

(defn on-destroy []
  println "destroying sample web app...")
