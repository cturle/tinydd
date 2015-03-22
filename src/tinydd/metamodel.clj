(ns tinydd.metamodel)


(defn throw-if-not
  ""
  [EXP MSG]
  (if (nil? EXP) (throw (Exception. MSG)) EXP) )

(defn new-model
  "create and return a new model"
  []
  {:next-id 1}
  )


(defn get-all-race
  "return a vector of all race of model M"
  [M]
  (get M :all-race []) )

(defn add-race
  "return an updated model from M where a new Race has been added with name N"
  [M N]
  (let [NEXT-ID       (throw-if-not (get M :next-id) "model wo :next-id")
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
  (throw-if-not (get (throw-if-not (get M R) (str "race " R " not found")) :name) (str "race-name of " R " not found")) )




