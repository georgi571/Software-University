function walking(input) {
    const GOAL_STEPS_PER_DAY = 10000;

    let command = input[0];

    let totalSteps = 0;
    let isGoalReached = false;

    let counter = 1;
    while (command !== "Going home") {
        const steps = Number(command);
        totalSteps += steps;

        if (totalSteps >= GOAL_STEPS_PER_DAY) {
            isGoalReached = true;
            break;
        }

        command = input[counter++];
    }

    if (!isGoalReached) {
        const stepsToGoHome = Number(input[counter++]);

        totalSteps += stepsToGoHome;
        if (totalSteps >= GOAL_STEPS_PER_DAY) {
            isGoalReached = true;
        }
    }

    const diff = Math.abs(GOAL_STEPS_PER_DAY - totalSteps);

    if (isGoalReached) {
        console.log(`Goal reached! Good job!`);
        console.log(`${diff} steps over the goal!`)
    } else {
        console.log(`${diff} more steps to reach goal.`);
    }
}