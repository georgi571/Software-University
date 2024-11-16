function sleepyTomCat(holidays) {
    const tomTimeToPlayToCanSleepEnough = 30000;
    const minutesToPlayInWorkingDays = 63;
    const minutesToPlayInHolidayDays = 127
    const daysInOneYear = 365;

    const workingDays = daysInOneYear - holidays;

    const timeToPlayInHolidays = holidays * minutesToPlayInHolidayDays;
    const timeToPlayInWorkingDays = workingDays * minutesToPlayInWorkingDays;

    const totalTimeToPlay = timeToPlayInHolidays + timeToPlayInWorkingDays;

    const diff = Math.abs(tomTimeToPlayToCanSleepEnough - totalTimeToPlay);
    const hours = Math.floor(diff / 60);
    const minutes = diff % 60;

    if (totalTimeToPlay > tomTimeToPlayToCanSleepEnough) {
        console.log(`Tom will run away`);
        console.log(`${hours} hours and ${minutes} minutes more for play`);
    } else {
        console.log(`Tom sleeps well`);
        console.log(`${hours} hours and ${minutes} minutes less for play`);
    }
}

sleepyTomCat(20)
sleepyTomCat(113)