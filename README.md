Java-Chemistry-Project
======================

> Current Version 1.2

CHANGELOG:

---------------------------------------------------

INDEV

--changes from v1.2--

- able to view changelog

- able to view build info

- on launch bug fix

- changes made to 'smart render', a
molecule must contain 20 atoms in order to be rendered in shorthand

- able to delete the last added atom from the molecule

- users can now pick bond types when adding atoms

- add atom bugfix

- project class added, but not implemented

- obsolete classes removed

- new project form added

- cranges made to GUI structure

- now works with 'Project' as opposed to 'Molecule'

- keeps track of number of Molecules in project

- can now change rendeing type

---------------------------------------------------
v1.2

--changes from v1.1--

- Java Swing GUI implemented!!!

- hydrogen, fluorine, chlorone 'auto fill' feature

- Chem now runs a GUI

---------------------------------------------------
v1.1

--changes from v1.0--

- atom nodes now have a 'parent', does nothing yet but will be
implemented to rendering soon

- 'smart rendering', larger chemicals have a simpler
render structure, as opposed to the full render, eg.


        H-0-H  --would render as--> H20

- a more advanced protein building system, now accpects
amino acid instruction sets

- atoms now have a unique ID, composed of a molecule ID, and
an atom id, eg atom 2.15 is atom 15, of group 2

- molecule can no longer bond and incorperate two atoms
from the outside via bonding, molecules can only
gain atoms from being bonded to

- error fixing in the 'Experiment' class

- more module tests in 'Chem'

------------------------------------------------------

IDEAS

--SIMULATION--

- calculate stability using electronegativity & energy quanta

- simulate bonding using electronegativity, energy quanta & entropy

--OTHER--

- add a temprature variable for a project (affects stability, decreases size of stability bracket)




