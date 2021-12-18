# robot-battle-simulation

Solution for a coding challenge for a job application

# Robot
A robot is characterized by 5 parameters: attack, shield, speed, location and energy.
- Attack (A): represent the explosive power of the missile.
- Defense (D): represent the strength of the shield
- Speed (S): represents the maximum number of meter the robot can move at once.
- Energy(E): self-explanatory
- Location (L): position of the robot on the axis
# Assumptions
- At the beginning of the battle one robot starts at L=0 the other at L=19.
- The battle is round-base: both robots make a move and then the outcome of their move is
- computed
- A missile always hit its target
- A move is either an attack or a movement within the world
- A robot cannot “jump” over each other and they cannot occupy the same space
- A robot dies when its Energy reaches 0 or less.
- Every robot has ﬁnite set amount of energy: 100 units.
- Ten units of ability points can be distributed between attack, defense and speed abilities.
- For example: a robot deﬁned by (A=8,D=1,S=1 is strong in attack, but is slow and has weak
- defense.
- Each move consumes an amount of energy calculated by: (DISTANCE/S)*5
- Each missile hit creates a damage which reduces the energy of a robot
- The damage is calculated by: DAMAGE(R2) = ( RANDOM(BETWEEN 1 AND 10) * A(R1) /
DISTANCE ) – (D(R2) * (DISTANCE / 10))
- Damage cannot be a negative value. Assume 0 if a negative value occurs.
