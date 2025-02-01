# Dining Philosophers Solution

By: Isabel Lopez Murillo and Caitlyn Kim

## Solution

The solution that we came up with was to change up the order in which philosophers would pick up their forks. This is idea was implemented to make sure that we would avoid the case of each of the philosophers picking up one fork, from which they would be stuck in a permanent state of being unable to eat or think. If we make it so that all philosophers will reach for the fork on their left, except for one who will reach for the fork on their right, then we avoid this issue of deadlock in this problem.

## Features and Structures

We decided the design of the eating phase and thinking phrase should be through modeling that amount of time by using the random function in order to make it realistic - a philosopher does not eat or think for the same amount of time each time they complete an action, so there is randomness involved (but only within a set period of time). 

## Deadlocks and Starvation

As mentioned earlier, deadlocks are impossible in this problem since if all the philosophers pick up the fork to their left, the philosopher that wants to try to pick up the fork on their right will be unable to, which leads them to give up and the process will be able to continue. The solution provided ensures that the condition where all 5 philosophers only have one fork is impossible, avoiding the issue of deadlock. 
