(ns clojure-tutorial.core)

(defn example-handler [request]
  {:headers {"Location" "https://github.com/ring-clojure/ring"
           "Set-cookie" "test=1"}
    :status 301})

(defn on-init[]
  println "Initializing sample web app...")

(defn on-destroy []
  println "destroying sample web app...")

(defn test1-handler [request]
  {:body "test1"})

(defn test2-handler [request]
  { :status 301
    :headers {"Location" "https://github.com/ring-clojure/ring"}})

(defn route-handler [request]
    (condp = (:uri request)
      "/test1" (test1-handler request)
      "/test2" (test2-handler request)
      nil))


