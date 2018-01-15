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

(defn simple-log-middleware [handler]
  (fn [{:keys [uri] :as request}]
    (println "request path: " uri)
    (handler request)))

(defn route-handler [request]
    (condp = (:uri request)
      "/test1" (test1-handler request)
      "/test2" (test2-handler request)
      nil))

(defn wrapping-handler [request]
 (if-let [response (route-handler request)]
  response
  {:body (str "mapping not found for URI: " (:uri request)) :status 404}))

(def full-handler
  (simple-log-middleware wrapping-handler))
