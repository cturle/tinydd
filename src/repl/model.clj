(ns repl.model
  (:require [tinydd.model :as m] ))


; - create a new model
; confirm-if : a model is currently loaded
(defn new-model [])

; - save the model
; check : a model is loaded
; confirm-if : file already exists
(defn save-model [PATH] "d:/temp/model1.clj")

; - delete model from memory
; check : a model is loaded
; confirm-if : model not saved
(defn delete-model-from-memory [])

; - check model is no more in memory
(defn is-there-a-model? [])

; - restore the model from persistence
; confirm : if a model is currently loaded
(defn restore-model [PATH] "d:/temp/model1.clj")
