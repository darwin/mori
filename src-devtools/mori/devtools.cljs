(ns mori.devtools
  (:require [devtools.core :as devtools])
  (:require-macros [mori.macros :refer [mori-export]]))

(enable-console-print!)

(mori-export installDevtools devtools.core/install!)
(mori-export uninstallDevtools devtools.core/uninstall!)

(mori-export enableDevtools devtools.core/enable!)
(mori-export disableDevtools devtools.core/disable!)