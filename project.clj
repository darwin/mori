(defproject mori "0.5.0-SNAPSHOT"
  :description "Persistent Data Structures for JavaScript"

  :dependencies [[org.clojure/clojure "1.7.0-beta2"]
                 [org.clojure/clojurescript "0.0-3269"]
                 [binaryage/devtools "0.2.3-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.0.5"]]

  :clean-targets ["dev" "release" "dev-devtools" "release-devtools" "target"]

  :cljsbuild
  {:builds
    [;; mori
     {:source-paths ["src"],
      :id "dev",
      :compiler
      {:output-to      "dev/mori.dev.js",
       :output-dir     "dev/"
       :optimizations  :simple
       :cache-analysis true
       :output-wrapper false
       :pretty-print   true}}

     {:source-paths ["src"],
      :id "release"
      :compiler
      {:optimizations  :advanced
       :output-dir     "release"
       :output-wrapper false
       :pretty-print   false
       :verbose        true
       :modules
       {:cljs-base {:entries #{cljs.core mori}
                    :output-to "release/build/mori.base.js"}
        :mutable   {:entries #{mori.mutable}
                    :output-to "release/build/mori.mutable.js"}
        :extra     {:entries #{clojure.data cljs.reader clojure.set mori.extra}
                    :output-to "release/build/mori.extra.js"}}}}

     {:source-paths ["src", "src-devtools"],
      :id "dev-devtools",
      :compiler
                    {:output-to      "dev-devtools/mori.dev.js",
                     :output-dir     "dev-devtools/"
                     :optimizations  :none
                     :cache-analysis true
                     :output-wrapper false
                     :pretty-print   true}}

     {:source-paths ["src", "src-devtools"],
      :id "release-devtools"
      :compiler
      {:optimizations  :advanced
       :output-dir     "release-devtools"
       :output-wrapper false
       ;:pseudo-names   true
       ;:pretty-print   true
       :verbose        true
       :warnings       true
       ;:externs ["externs/devtools.externs.js"]
       :modules
       {:cljs-base {:entries #{cljs.core mori}
                    :output-to "release-devtools/build/mori.base.js"}
        :mutable   {:entries #{mori.mutable}
                    :output-to "release-devtools/build/mori.mutable.js"}
        :extra     {:entries #{clojure.data cljs.reader clojure.set mori.extra}
                    :output-to "release-devtools/build/mori.extra.js"}
        :devtools  {:entries #{devtools.core devtools.format mori.devtools}
                    :output-to "release-devtools/build/mori.devtools.js"}}
       }}]})
