# Dining Philosophers Solution

By: Isabel Lopez Murillo and Caitlyn Kim

## Solution

The solution that we came up with was to use ```synchronized``` to ensure that no two philosophers can use the same fork at the same time, locking the right fork if the left fork is attempted to me picked up. This stops the issue of there being confusion with each philosopher having a left and right fork, and one left fork for a philosopher can be the right fork for another. Another addition was to change up the order in which philosophers would pick up their forks. This is idea was implemented to make sure that we would avoid the case of each of the philosophers picking up one fork, from which they would be stuck in a permanent state of being unable to eat or think. If we make it so that all philosophers will reach for the fork on their left, except for one who will reach for the fork on their right, then we avoid this issue of deadlock in this problem.

## Features and Structures

Each philosopher is represented as a thread using the ```Philosopher``` class, which extends ```Thread```. The table is not explicitly defined in the code, but is somewhat represented through the forks, which are represented as ```Objects```, which are stored in an array. We have each fork as a unique ```Object``` in the array. Like the table, the spaghetti is not explicitly represented, but it is represented in terms of the philosophers needing both the left and right forks in order to successfully "eat."

We decided the design of the eating phase and thinking phrase should be through modeling that amount of time by using the random function in order to make it realistic - a philosopher does not eat or think for the same amount of time each time they complete an action, so there is randomness involved (but only within a set period of time). The thinking phase happens for a random time between 1-5 seconds, during which the code prints a message, and similarly for the eating page, each philosopher can only eat if both forks are acquired through the nested ```synchronized``` blocks, during which is will print a message and "eat" for a random amount of time. After "eating," the philosopher will enter the "thinking" phase and vice versa.

## Deadlocks and Starvation

As mentioned earlier, deadlocks are impossible in this problem since if all the philosophers pick up the fork to their left, the philosopher that wants to try to pick up the fork on their right will be unable to, which leads them to give up and the process will be able to continue. The solution provided ensures that the condition where all 5 philosophers only have one fork is impossible, avoiding the issue of deadlock. In addition, the use of nested ```synchronized``` blocks in our code ensure that no two philosophers can use the same fork at the same time, which helps us avoid a logistical issue where multiple philosophers are eating using the same fork.
