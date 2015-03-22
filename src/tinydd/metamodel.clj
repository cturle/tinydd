(ns tinydd.metamodel)


(defn throw-if-not
  "return a function that return FN applied to args if not nil, else throw an Exception with message MSG"
  [FN MSG]
  (fn [& args]
    (let [R (apply FN args)]
      (if (nil? R) (throw (Exception. MSG)) R) )))


(defn new-model
  "create and return a new model"
  []
  {:next-id 1}
  )


(declare get-all-race, add-race, the-race-name)


(defn get-all-race
  "return a vector of all race of model M"
  [M]
  (get M :all-race []) )

(defn add-race
  "return an updated model from M where a new Race has been added with name N"
  [M N]
  (let [GET1          (throw-if-not get "model wo :next-id")
        NEXT-ID       (GET1 M :next-id)
        NEW-RACE-ID   NEXT-ID
        NEW-NEXT-ID   (inc NEXT-ID)
        NEW-ALL-RACE  (conj (get M :all-race []) NEW-RACE-ID)
        NEW-RACE      {:id NEW-RACE-ID, :name N}
        ]
    [(assoc M :next-id     NEW-NEXT-ID,
              :all-race    NEW-ALL-RACE,
              NEW-RACE-ID  NEW-RACE )
     NEW-RACE-ID ]))

(defn the-race-name
  "return the name of the race R in the model M"
  [M R]
  (let [GET1 (throw-if-not get (str "race-name of " R " not found"))
        GET2 (throw-if-not get (str "race " R " not found"))]
    (GET1 (GET2 M R) :name) ))




