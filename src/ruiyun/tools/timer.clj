(ns ^{:doc "ruiyun.tools.timer is an easy to use Java Timer wrapper for clojure.
            You can simply start a period task in every 5 seconds immediately like this:

              (run-task! #(println \"Say hello every 5 seconds.\") :period 5000)

            If you want delay the first run with 2 seconds：

              (run-task! #(println \"Say hello after 2 seconds.\") :dealy 2000)

            Use this if you want to execute a task at an absolute time：

              (run-task! #(println \"Say hello at 2013-01-01T00:00:00 in beijing.\") :at #inst \"2013-01-01T00:00:00+08:00\")

            And, you can use the same timer in more than one tasks:

              (def greeting-timer (timer \"The timer for greeting\"))
              (run-task! #(println \"Say hello after 2 seconds.\") :dealy 2000 :by greeting-timer)
              (run-task! #(println \"Say hello every 5 seconds.\") :period 5000 :by greeting-timer)

            Finally, you can cancel a timer's tasks:

              (cancel! greeting-timer)"
      :author "ruiyun"}
  ruiyun.tools.timer
  (:import [java.util Timer TimerTask Date]))

(defn timer
  "Create a new java.util.Timer object."
  {:added "1.0.0"}
  ([] (Timer.))
  ([^String name] (Timer. name)))

(defn deamon-timer
  "Create a new java.util.Timer object with deamon option."
  {:added "1.0.0"}
  ([] (Timer. true))
  ([name] (Timer. name true)))

(defn run-task!
  "Execute a timer task, then return the timer user passed or be auto created.
  Normally, User need set one of the two options:
    :at <time>
    :delay <milliseconds>
  If set none of them, the task will launch immediately.

  Optional, user can set:
    :period <milliseconds>

  If user want share a timer between tow or more tasks, he can set an exist timer:
    :by <a timer>

  Sometimes user task may cause exception, it's a good reason to use an exception handler:
    :on-exception <handle function with an exception argument>"
  {:added "1.0.0"}
  [task & {:keys [^Timer by, ^Date at, ^long delay, ^long period, on-exception]}]
  {:pre [(fn? task)
         (or (nil? by) (instance? Timer by))
         (or (nil? at) (instance? Date at))
         (or (nil? delay) (>= delay 0))
         (or (nil? period) (> period 0))
         (or (nil? on-exception) (fn? on-exception))]
   :post [(instance? Timer %)]}
  (let [task  (proxy [TimerTask] []
                (run []
                  (if (nil? on-exception)
                    (task)
                    (try
                      (task)
                      (catch Exception e
                        (on-exception e))))))
        ^Timer timer (or by (timer))
        ^long start-time (or at delay 0)]
    (if (nil? period)
      (.schedule timer task start-time)
      (.schedule timer task start-time period))
    timer))

(defn cancel!
  "Terminates a timer, discarding any currently scheduled tasks."
  {:added "1.0.0"}
  [^Timer timer]
  (.cancel timer))
