(ns assignments.util)

(defn implemented? [f]
  (-> f resolve meta :implemented?))

(defn insert-println-if-implemented [form]
  (let [f (first form)]
    (when (and (resolve f) (implemented? f))
      (list '(println "---")
            `(println "Running: " '~form)
            `(println "Result:  " ~form)))))

(defmacro print-and-do [& forms]
  (let [forms-with-println (mapcat insert-println-if-implemented forms)]
    (list* 'do forms-with-println)))

(defn increment [n] (if (instance? Number n) (inc n) n))

(defn is-divisible [dividend divisor] (zero? (mod dividend divisor)))

(defn deduplicate [coll n] (cond
                          (empty? coll) (conj [] n)
                          (not= n (last coll)) (conj coll n)
                          :else coll))