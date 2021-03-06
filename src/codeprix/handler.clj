(ns codeprix.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))
(defn add
  [a b]
  (+ a b))

(defroutes app-routes
  (GET "/name/:name" [name] (str "Hello " name))
  (GET "/add/:a/:b" [a b] (str (add (Integer. a) (Integer. b))))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
