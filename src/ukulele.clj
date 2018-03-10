(ns chords)

(use 'overtone.live)

;; We use a saw-wave that we defined in the oscillators tutorial
(definst saw-wave [freq 440 attack 0.01 sustain 0.4 release 0.1 vol 0.4] 
  (* (env-gen (env-lin attack sustain release) 1 1 0 1 FREE)
     (saw freq)
     vol))

(demo (sin-osc))

;; Define a function for convenience
(defn note->hz [music-note]
    (midi->hz (note music-note)))

;; Let's make it even easier
(defn saw2 [music-note]
    (saw-wave (midi->hz (note music-note))))

;; Great!
(saw2 :A4)
(saw2 :C5)
(saw2 :C4)
