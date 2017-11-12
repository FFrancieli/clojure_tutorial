(ns clojure-tutorial.core)

(defn example-handler [{:keys [uri] :as uri}]
  {:body (str "uri is: " uri)})

(defn on-init[]
  println "Initializing sample web app...")

(defn on-destroy []
  println "destroying sample web app...")
