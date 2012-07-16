ruiyun.tools.timer
=========

The ruiyun.tools.timer is a Java [Timer] and [TimerTask] wrapper for [Clojure].

Installation
============

Add the following to your **project.clj** or pom.xml:

Lein artifact:

    [ruiyun/tools.timer "1.0.0-SNAPSHOT"]

Maven:

    <dependency>
      <groupId>ruiyun</groupId>
      <artifactId>tools.timer</artifactId>
      <version>1.0.0-SNAPSHOT</version>
    </dependency>

Then execute

    lein deps

And here is an example to show how to work with ruiyun.tools.timer.

```clojure
    (use 'ruiyun.tools.timer)
    TBD..
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