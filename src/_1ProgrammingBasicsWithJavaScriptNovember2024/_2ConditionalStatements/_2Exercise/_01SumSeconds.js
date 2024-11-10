function sumSeconds(firstTime, secondTime, thirdTime) {
    const totalTimeInSeconds = firstTime + secondTime + thirdTime;
    const minutes = Math.floor(totalTimeInSeconds / 60);
    const seconds = totalTimeInSeconds % 60;

    if (seconds < 10) {
        console.log(`${minutes}:0${seconds}`)
    } else {
        console.log(`${minutes}:${seconds}`)
    }
}
