{:namespaces
 ({:source-url nil,
   :wiki-url "ruiyun.tools.timer.core-api.html",
   :name "ruiyun.tools.timer.core",
   :author "ruiyun",
   :doc
   "ruiyun.tools.timer is an easy to use Java Timer wrapper for clojure.\nYou can simply start a period task in every 5 seconds immediately like this:\n\n  (run-task! #(println \"Say hello every 5 seconds.\") :period 5000)\n\nIf you want delay the first run with 2 seconds：\n\n  (run-task! #(println \"Say hello after 2 seconds.\") :dealy 2000)\n\nUse this if you want to execute a task at an absolute time：\n\n  (run-task! #(println \"Say hello at 2013-01-01T00:00:00 in beijing.\") :at #inst \"2013-01-01T00:00:00+08:00\")\n\nAnd, you can use the same timer in more than one tasks:\n\n  (def greeting-timer (timer \"The timer for greeting\"))\n  (run-task! #(println \"Say hello after 2 seconds.\") :dealy 2000 :by greeting-timer)\n  (run-task! #(println \"Say hello every 5 seconds.\") :period 5000 :by greeting-timer)\n\nFinally, you can cancel a timer's tasks:\n\n  (cancel! greeting-timer)"}),
 :vars
 ({:arglists ([timer]),
   :name "cancel!",
   :namespace "ruiyun.tools.timer.core",
   :source-url nil,
   :added "1.0.0",
   :raw-source-url nil,
   :wiki-url
   "/ruiyun.tools.timer.core-api.html#ruiyun.tools.timer.core/cancel!",
   :doc
   "Terminates a timer, discarding any currently scheduled tasks.",
   :var-type "function",
   :line 78,
   :file "src/ruiyun/tools/timer/core.clj"}
  {:arglists ([] [name]),
   :name "deamon-timer",
   :namespace "ruiyun.tools.timer.core",
   :source-url nil,
   :added "1.0.0",
   :raw-source-url nil,
   :wiki-url
   "/ruiyun.tools.timer.core-api.html#ruiyun.tools.timer.core/deamon-timer",
   :doc "Create a new java.util.Timer object with deamon option.",
   :var-type "function",
   :line 33,
   :file "src/ruiyun/tools/timer/core.clj"}
  {:arglists ([task & {:keys [by at delay period on-exception]}]),
   :name "run-task!",
   :namespace "ruiyun.tools.timer.core",
   :source-url nil,
   :added "1.0.0",
   :raw-source-url nil,
   :wiki-url
   "/ruiyun.tools.timer.core-api.html#ruiyun.tools.timer.core/run-task!",
   :doc
   "Execute a timer task, then return the timer user passed or be auto created.\nNormally, User need set one of the two options:\n  :at <time>\n  :delay <milliseconds>\nIf set none of them, the task will launch immediately.\n\nOptional, user can set:\n  :period <milliseconds>\n\nIf user want share a timer between tow or more tasks, he can set an exist timer:\n  :by <a timer>\n\nSometimes user task may cause exception, it's a good reason to use an exception handler:\n  :on-exception <handle function with an exception argument>",
   :var-type "function",
   :line 39,
   :file "src/ruiyun/tools/timer/core.clj"}
  {:arglists ([] [name]),
   :name "timer",
   :namespace "ruiyun.tools.timer.core",
   :source-url nil,
   :added "1.0.0",
   :raw-source-url nil,
   :wiki-url
   "/ruiyun.tools.timer.core-api.html#ruiyun.tools.timer.core/timer",
   :doc "Create a new java.util.Timer object.",
   :var-type "function",
   :line 27,
   :file "src/ruiyun/tools/timer/core.clj"})}
