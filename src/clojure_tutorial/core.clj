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
  (throw (RuntimeException. "error!"))
  {:body "test1"})

(defn test2-handler [request]
  { :status 301
    :headers {"Location" "https://github.com/ring-clojure/ring"}})

(defn simple-log-middleware [handler]
  (fn [{:keys [uri] :as request}]
    (println "request path: " uri)
    (handler request)))

(defn not-found-middleware [handler]
  (fn [request]
    (or (handler request)
      {:status 404 :body (str "not found - with middleware " (:uri request))})))

(defn exception-middleware-fn [handler request]
  (try (handler request)
    (catch Throwable e
    {
      :status 500
      :body (apply str (interpose "\n" (.getStackTrace e)))})))

(defn wrap-exception-middleware [handler]
  (fn [request]
    (exception-middleware-fn handler request)))

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
  (-> route-handler
    not-found-middleware
    wrap-exception-middleware
    simple-log-middleware))
