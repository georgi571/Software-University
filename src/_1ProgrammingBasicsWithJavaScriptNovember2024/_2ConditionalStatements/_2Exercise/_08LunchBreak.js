function luchBreak(movieName, movieTime, breakTime) {
    const TIME_FOR_LUNCH = 0.125;
    const TIME_FOR_REST = 0.25;

    const lunchTime = breakTime * TIME_FOR_LUNCH;
    const restTime = breakTime * TIME_FOR_REST;

    const leftTimeForMovie = breakTime - lunchTime - restTime;

    const diff = Math.ceil(Math.abs(leftTimeForMovie - movieTime));

    if (leftTimeForMovie >= movieTime) {
        console.log(`You have enough time to watch ${movieName} and left with ${diff} minutes free time.`);
    } else {
        console.log(`You don't have enough time to watch ${movieName}, you need ${diff} more minutes.`);
    }
}