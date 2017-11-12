(ns clojure-tutorial.core)

(defn example-handler [request]
  {:body "Hello clojure!"})

(defn on-init[]
  println "Initializing sample web app...")

(defn on-destroy []
  println "destroying sample web app...")
