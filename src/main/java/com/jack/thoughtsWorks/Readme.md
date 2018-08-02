
ThoughtWorks

=======================================

########################Environment Dependence
1、IntelliJ IDEA
2、JDK1.8

########################Directory structure description
|——Main.java
|——Readme.md

########################Test Steps
1. open the Main.java and right click run or debug.
2. copy test list and paste console.
3. click "Enter" button.
4. then you will see the program output.

#######################Test example
If you want to test this method is OK or not, maybe you could use follow input.
(1)correct input
3 3
0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1
(2)Maze format error
3 3
1,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1

3 3
1,1 1,1;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1
(3)Invalid number format
3 3
1,a 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1
(4)Number out of range
3 3
4,2 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1
(5)Incorrect command format
3 3
3,1 0;2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1