(defn greeting
     ([] (println "Hello, World!"))
     ([x] (println (str "Hello, " x "!")))
     ([x,y] (println (str x ", " y "!"))))
(defn triplicate [f & args]
     (f args)
     (f args)
     (f args))
(defn triplicate2 [f & args]
      (triplicate f args))
(greeting)
(greeting "Clojure")
(greeting "Good morning" "Clojure")
(triplicate greeting "haha")
(triplicate2 greeting "Mona")
(triplicate2 greeting "test1" "test2")
(defn invokejava [x]
    (Math/sin x))
(println (invokejava 5))
(defn http-get [url]
  (let [httpurl (java.net.URL. url)]
       (slurp (.openStream httpurl))))
(http-get "http://www.w3.org")
(println (.contains (http-get "http://www.w3.org") "html"))
(defn one-less-arg [f x]
   (fn [& args]
       (f x)
       (println x args)))
((one-less-arg greeting "super") "haha")
(defn two-fns [f g]
  (fn [arg] (f g arg)))
((two-fns triplicate greeting ) "two-fns")