(ns repl.session
  (:require [repl.model :refer :all]
            [repl.race  :refer :all] ))

;;; repl interaction : scenario 1
; - create a new model
; - add a new race with name = "elf"
; - list all races, displaying their name
; - save the model
; - delete model from memory
; - restore the model from persistence
; - check all races are back.

; - create a new model
; confirm-if : a model is currently loaded
(new-model)

; - add a new race with name = "elf"
; check : a model is loaded
(add-race "Elf")

; - list all races, displaying their name
; check : a model is loaded
(display-many-race (get-all-race))

; - save the model
; check : a model is loaded
; confirm-if : file already exists
(save-model "d:/temp/model1.clj")

; - delete model from memory
; check : a model is loaded
; confirm-if : model not saved
(delete-model-from-memory)
; - check model is no more in memory
(is-there-a-model?)

; - restore the model from persistence
; confirm : if a model is currently loaded
(restore-model "d:/temp/model1.clj")
; - check a model is in memory
(is-there-a-model?)

; - check all races are back.
; check : a model is loaded
(display-many-race (get-all-race))
