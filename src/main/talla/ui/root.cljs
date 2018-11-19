(ns talla.ui.root
  (:require
    [fulcro.client.dom :as dom :refer [div]]
    [fulcro.client.primitives :as prim :refer [defsc]]
    [talla.ui.components :as comp]))

(defsc Person [this {:keys [person/name person/profession]}]
  (dom/div
    (dom/p "Name: " name)
    (dom/p "Profession: " profession)))

(def ui-person (prim/factory Person))

(defsc Root [this {:keys [root/message person/name person/profession]}]
  {:query         [:root/message :person/name :person/profession]
   :initial-state {:root/message "Hello!" :person/name "Kasim" :person/profession "Developer"}}
  (div :.ui.segments
    (div :.ui.top.attached.segment
      (div :.content
        (str "Welcome to Fulcro! " name)))
    (div :.ui.attached.segment
      (div :.content
        (comp/ui-placeholder {:w 50 :h 50})
        (div (str message " to " name))
        (ui-person {:person/name name, :person/profession profession})
        (div "Some content here would be nice.")))))
