(ns tinydd.metamodel
  (:require [utils.clojure :refer :all]
            [utils.model   :refer :all] ))


; todo : move to tinydd.metamodel.race ?
(declare get-all-race, add-race, update-race, remove-race, the-race-name)

(defn get-all-race
  "return a vector of all race of model M"
  [M]
  (get M :all-race []) )

(defn add-race
  "[M1 N] -> [M2 R].
  return an updated model M2 from M1 where a new Race R has been added with name N"
  [M1 N]
  (let [GET1          (throw-if-not get "model wo :next-id")
        NEXT-ID       (GET1 M1 :next-id)
        R             NEXT-ID
        NEW-NEXT-ID   (inc NEXT-ID)
        NEW-ALL-RACE  (conj (get M1 :all-race []) R)
        NEW-RACE      {:id R, :name N}
        M2            (assoc M1 :next-id NEW-NEXT-ID, :all-race NEW-ALL-RACE, R NEW-RACE) ]
    [M2, R] ))

(defn update-race
  "[M1 R N] -> M2.
  return an updated model M2 from M1 where Race R has new name N"
  [M1 R N]
  (let [NEW-RACE      {:id R, :name N}
        M2            (assoc M1, R NEW-RACE) ]
    M2 ))

(defn remove-race
  "[M1 R] -> M2
  return an updated model M2 from M1 where Race R has been removed"
  [M1 R]
  (let [NEW-ALL-RACE  (remove #{R} (get M1 :all-race []))
        M2            (dissoc M1 R)
        M2            (assoc M2 :all-race NEW-ALL-RACE) ]
  M2 ))

(defn the-race-name
  "return the name of the race R in the model M"
  [M R]
  (let [GET1 (throw-if-not get (str "race-name of " R " not found"))
        GET2 (throw-if-not get (str "race " R " not found"))]
    (GET1 (GET2 M R) :name) ))




