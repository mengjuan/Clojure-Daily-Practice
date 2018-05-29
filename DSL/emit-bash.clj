(defn emit-bash-form [a]
  (cond 
    (= (class a) clojure.lang.PersistentList)
    (case (name (first a))
      "println" (str "echo " (second a)))

    (= (class a) java.lang.String) a
    (= (class a) java.lang.Long) (str a)
    (= (class a) java.lang.Double) (str a)
    :else (throw (Exception. "Fell through"))))
