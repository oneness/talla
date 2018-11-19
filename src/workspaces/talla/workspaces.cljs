(ns talla.workspaces
  (:require
    [nubank.workspaces.core :as ws]
    [talla.demo-ws]))

(defonce init (ws/mount))
