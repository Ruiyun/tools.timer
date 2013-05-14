ruiyun.tools.timer
=========

The ruiyun.tools.timer is a Java [Timer] and [TimerTask] wrapper for [Clojure].

Installation
============

Add the following to your **project.clj**:

    [ruiyun/tools.timer "1.0.1"]

Then execute

    lein deps

Quick tutorial
==============

You can simply start a period task in every 5 seconds immediately like this:

```clojure
(use 'ruiyun.tools.timer)
(run-task! #(println "Say hello every 5 seconds.") :period 5000)
```

If you want delay the first run with 2 seconds：

```clojure
(run-task! #(println "Say hello after 2 seconds.") :dealy 2000)
```

Use this if you want to execute a task at an absolute time：

```clojure
(run-task! #(println "Say hello at 2013-01-01T00:00:00 in beijing.") :at #inst "2013-01-01T00:00:00+08:00")
```

And, you can use the same timer in more than one tasks:

```clojure
(def greeting-timer (timer "The timer for greeting"))
(run-task! #(println "Say hello after 2 seconds.") :dealy 2000 :by greeting-timer)
(run-task! #(println "Say hello every 5 seconds.") :period 5000 :by greeting-timer)
```

Finally, you can cancel a timer's tasks:

```clojure
(cancel! greeting-timer)
```

Documentation
=============

For more detailed information on **ruiyun.tools.timer**, please refer to the  [documentation].

License
=======

Copyright (C) 2012 Ruiyun Wen

Distributed under the Eclipse Public License, the same as Clojure.

[Timer]:                http://docs.oracle.com/javase/7/docs/api/java/util/Timer.html
[TimerTask]:            http://docs.oracle.com/javase/7/docs/api/java/util/TimerTask.html
[Clojure]:              http://clojure.org/
[documentation]:        http://ruiyun.github.com/tools.timer/
