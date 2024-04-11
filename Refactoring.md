### Refactoring Yatzi

#### First Code Analysis

After watching the video and reading the rules, I took a first glance at Yatzy1 code. Here are my first impressions:

- All code is in a single file
- Code base is small : a total 239 lines
- No respect for object-oriented design principles : a lot of static methods
- Constructor is in the middle of class while it is usually the first thing we see in a class after fields (same remark
  for dices field)
- It seems there is a method for each game rule described by
  Emily [here](https://sammancoaching.org/kata_descriptions/yatzy.html). This is encouraging as developer seems to have
  respected the Single Responsibility Principle (at least at a certain level).
- All methods return the score which is an int.
- Some methods have the dices as input in the form of six ints. While other methods use the dices field of the class so
  do not have input. This will trouble the code reader
- Inconsistent naming of methods : some use snakeCase while other use camelCase. camelCase is commonly seen in python
  code but Java code usually uses camelCase.
- Some small code formatting issue(where the of { methods are put)
- There is unit Test that seems to be covering all methods which is great because we can refactor safely code.
  Otherwise, we will have to write the tests first.

#### TODO:

- Further analysis of game rules described by Emily
- Analyse and read the unit test
- Check code coverage to spot any missing edge case or method
- Establish a refactoring plan and prioritize the tasks. Some quick thoughts here:
    - move the constructor and field dices to first lines
    - create a class DiceRoll to represent the 5 dices
    - consisting naming using camelCase
    - all methods will use the class DiceRoll as their input. So we can remove the field dices from class
    - we can go further by creating in Interface ScoreCategory which calculate the score for each DiceRoll. Each
      implementation will represent a score category (chance, pair, ...). But this will come after the first pass I
      think.

#### Conclusion

The presence of unit test and the spotting of some easy to fix code flaws is encouraging since we could establish
quickly a first plan for code refactoring. Further analysis will be conducted after this first pass.