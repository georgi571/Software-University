function worldSwimmingRecord(recordInSeconds, distanceInMeters, metersInSecond) {
    const SLOWER_FOR_EVERY_15_METERS = 12.5;

    const slowTimes = Math.floor(distanceInMeters / 15);
    const secondsForNormalSwim = distanceInMeters * metersInSecond;
    const secondsSlow = slowTimes * SLOWER_FOR_EVERY_15_METERS;
    const totalTime = secondsForNormalSwim + secondsSlow;

    if (totalTime < recordInSeconds) {
        console.log(`Yes, he succeeded! The new world record is ${totalTime.toFixed(2)} seconds.`);
    } else {
        const secondsSlowerToBeatTheRecord = totalTime - recordInSeconds;
        console.log(`No, he failed! He was ${secondsSlowerToBeatTheRecord.toFixed(2)} seconds slower.`);
    }
}