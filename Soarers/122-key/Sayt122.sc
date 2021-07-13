# Soarer Converter's configuration for IBM Model M122 (1390876, etc.) and
# F122 (6110345, etc.) keyboards.
#
# Author: Depleted Vespene.
# Date: 20181010.
# Version: 1.2.
# ^^^^^ This is the original author
# Sayt`s 122-key layout for the IBM 1389262 Model-M 122-key
#
#Some keys need repair so some aren't mapped, and some keys are mapped to compensate
#
##### BEGIN ########

macroblock

  # Backtab (Shift-Tab, actually) - right to the left of Tab.
  macro EXTRA_F4
    PUSH_META SET_META LSHIFT
    PRESS TAB
    POP_ALL_META
  endmacro

  # This shows how to assign an entire phrase to a single keystroke. Do
  # take into account that the entire macro cannot exceed a certain length.
  macro EXTRA_F8
    PUSH_META CLEAR_META all
	PRESS U
	delay 5
	PRESS W
	delay 5
	PRESS U
	delay 5
    PRESS ENTER
    POP_ALL_META
  endmacro

  # On my M122 (but NOT on the F122), some Alt-Ctrl-arrow combinations
  # don't register as would be expected. I use them a lot, so I need to
  # wade around that problem... and, as it turns out, this key assignment
  # is pretty comfortable for other things as well.
#  macro EXTRA_F10
 #   SET_META LALT RCTRL
 #   onbreak norestoremeta
 #   CLEAR_META RCTRL LALT
 # endmacro

  # Alt-PrtScr in a single keystroke - this is actually quite more
  # convenient than what would be expected at a first glance.
  macro F22
    PUSH_META CLEAR_META all
    MAKE LALT
    PRESS PRINTSCREEN
    BREAK LALT
    POP_ALL_META
  endmacro
  
  # Dedicated control alt delete macro
  macro EXTRA_F5
    PUSH_META CLEAR_META all
	MAKE LALT
	PRESS F9
	BREAK F9
	POP_ALL_META
  endmacro
  
  # On my national layout, Shift-0 produces the '=' character. Adjust this
  # as needed for others.
  macro PAD_EQUALS
    PUSH_META CLEAR_META all
    MAKE LSHIFT
    PRESS 0
    BREAK LSHIFT
    POP_ALL_META
  endmacro

endblock


remapblock

# Left-side function keys.
  EXTRA_F1      LGUI                # "Windows" key.
  EXTRA_F2      ESC
  EXTRA_F3      APP                 # "Menu" key.
# EXTRA_F4      (see macro above)
# EXTRA_F5      (see macro above)
  EXTRA_F6      RALT
  EXTRA_F7      UNASSIGNED          # Future "layer n".
#  EXTRA_F8      UNASSIGNED          # Future "layer 0".
  EXTRA_F9      MEDIA_MY_COMPUTER
  EXTRA_F10     MEDIA_CALCULATOR

# Main alphanumeric block. This remapping is non-negotiable.
  EUROPE_1      BACKSLASH

# Top-side extra function keys.
  F13           MEDIA_MUTE
  F14           MEDIA_VOLUME_DOWN
  F15           MEDIA_VOLUME_UP
#  F16           SELECT_1            # Toggles layer 1 (see below).
  F17           MEDIA_PLAY_PAUSE
  F18           MEDIA_PREV_TRACK
  F19           MEDIA_NEXT_TRACK
  F20           MEDIA_STOP
  F21           NUM_LOCK
# F22           (see macro above)
  F23           PRINTSCREEN
  F24           PAUSE
  
# Temporary left hand ctrl over caps lock.
  CAPS_LOCK     LCTRL

# Navigation cluster; only the "Rule" key needs to be reassigned.
  LANG_4        LEFT

# Numpad. In the default layer, the gray keys are made to behave as they do
# in a regular full-sized keyboard, EXCEPT: a) the top left key outputs the
# equals sign instead of becoming the NumLock key; b) battleships have two
# 1U keys instead of a single 2U plus key - of those, the top one remains
# plus and the bottom key outputs a comma.
  ESC           PAD_EQUALS
  NUM_LOCK      PAD_SLASH
  SCROLL_LOCK   PAD_ASTERIX
  EXTRA_SYSRQ   PAD_MINUS
  PAD_ASTERIX   PAD_PLUS
  PAD_MINUS     COMMA
  PAD_PLUS      PAD_ENTER
# Bonus: on my national layout, Shift-, produces the ';' character. With
# the direct remapping above (instead of a macro), pressing Shift-PAD_MINUS
# has the same effect. Replace with a macro if needed.

endblock


# Layer 1 changes the numpad into a hexpad (0..9, A..F, Enter and colon).

ifselect 1
macroblock

  # On my national layout, Shift-. produces the ':' character. Adjust this
  # as needed.
  macro PAD_PERIOD
    PUSH_META CLEAR_META all
    MAKE LSHIFT
    PRESS PERIOD
    BREAK LSHIFT
    POP_ALL_META
  endmacro

endblock

remapblock
  ESC           A
  NUM_LOCK      B
  SCROLL_LOCK   C
  EXTRA_SYSRQ   D
  PAD_ASTERIX   E
  PAD_MINUS     F
  PAD_PLUS      PAD_ENTER
# PAD_PERIOD    (see macro above)
endblock

##### END ##########
