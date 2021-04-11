I pledge the highest level of ethical principles in support of academic excellence.
I ensure that all of my work reflects my own abilities and not those of someone else.

Saying we want to add a cool feature - button "x" to run multiplication.

What code do we need to change/add/remove to support this feature?
in SimpleCalculatorImpl.java we have to:
- create a function that is called insertMultiplication for insertion of this order to output.
- change insertEquals function (and insertEqualsHelper function accordingly) to use this order correctly.
in activity_main.xml file we have to add a TextView for the "x" button, and give it a unique id (like buttonMultiplication).
in MainActivity.java file we have to:
- create a view object for the button (with findViewById).
- set click listeners for this button.

Which tests can we run on the calculator? On the activity? On the app?
tests on the calculator (SimpleCalculatorImplTest):
- when input is multiplication only then output should be "0x".
- when input has multiple orders then only first order seen in output.
tests on the activity (MainActivityTest):
- when user clicks button multiplication then activity should forward call to calculator and show the expected calculator output right away.
tests on the app (AppFlowTest):
- run clicks on "13+5x10="
- run clicks on "x0+5x8<backspace>9="