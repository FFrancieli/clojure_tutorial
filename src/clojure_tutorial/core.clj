(ns clojure-tutorial.core)

(defn example-handler [request]
  {:body (java.io.File. "test.txt")})
(defn on-init[]
  println "Initializing sample web app...")

(defn on-destroy []
  println "destroying sample web app...")
