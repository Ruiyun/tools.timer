(ns ^{:doc "place doc string here"
      :author "ruiyun"}
  ruiyun.tools.timer.core
  (:use cljain.tools.predicate)
  (:import [java.util Timer TimerTask Date]))

(defn timer
  "Create a new java.util.Timer object."
  {:added "0.2.0"}
  ([] (Timer.))
  ([name] (Timer. name)))

(defn deamon-timer
  "Create a new java.util.Timer object with deamon option."
  {:added "0.2.0"}
  []
  (Timer. true))

(defmacro task
  "Create a java.util.TimerTask object with some code."
  {:arglists '([body*])
   :added "0.2.0"}
  [& body]
  `(proxy [TimerTask] []
     (run []
       ~@body)))

(defmulti run!
  "Execute a timer task, then return the timer user passed or created auto.
  User must set one of the two options:
    :at <time>
    :delay <milliseconds>

  Optional, user can set
    :period <milliseconds>"
  {:arglists '([timer? task & options])
   :added "0.2.0"}
  (fn [a & more] (class a)))

(defn- run-task!
  "The 'run!' functions internal implement."
  {:added "0.2.0"}
  [timer task & {:keys [at delay period]}]
  {:pre [(or (instance? Date at) (>= delay 0))
         (or (nil? period) (> period 0))]
   :post [(instance? Timer %)]}
  (let [start-time at]
    (cond
      (not (nil? start-time))
      (if (nil? period)
        (.schedule timer task start-time)
        (.schedule timer task start-time period))

      (not (nil? delay))
      (if (nil? period)
        (.schedule timer task delay)
        (.schedule timer task delay period)))
    timer))

(defmethod run! Timer
  [timer task & options]
  (apply run-task! timer task options))

(defmethod run! TimerTask
  [task & options]
  (apply run-task! (timer) task options))

(defn cancel!
  "Terminates a timer, discarding any currently scheduled tasks."
  {:added "0.2.0"}
  [timer]
  (.cancel timer))
