function trekkingMania(input) {
    const n = input[0];

    let musalaNumberOfGroups = 0;
    let monbalanNumberOfGroups = 0;
    let kilimandjaroNumberOfGroups = 0;
    let k2NumberOfGroups = 0;
    let everestNumberOfGroups = 0;

    let totalNumberOfPeoples = 0;
    for (let i = 1; i < input.length; i++) {
        const numberOfPeople = Number(input[i]);

        totalNumberOfPeoples += numberOfPeople;

        if (numberOfPeople <= 5) {
            musalaNumberOfGroups += numberOfPeople;
        } else if (numberOfPeople <= 12) {
            monbalanNumberOfGroups += numberOfPeople;
        } else if (numberOfPeople <= 25) {
            kilimandjaroNumberOfGroups += numberOfPeople;
        } else if (numberOfPeople <= 40) {
            k2NumberOfGroups += numberOfPeople;
        } else if (numberOfPeople >= 41) {
            everestNumberOfGroups += numberOfPeople;
        }
    }

    const musalaPercent = (musalaNumberOfGroups / totalNumberOfPeoples) * 100;
    const monbalPercent = (monbalanNumberOfGroups / totalNumberOfPeoples) * 100;
    const kilimandjaroPercent = (kilimandjaroNumberOfGroups / totalNumberOfPeoples) * 100;
    const k2Percent = (k2NumberOfGroups / totalNumberOfPeoples) * 100;
    const everestPercent = (everestNumberOfGroups / totalNumberOfPeoples) * 100;

    console.log(`${musalaPercent.toFixed(2)}%`);
    console.log(`${monbalPercent.toFixed(2)}%`);
    console.log(`${kilimandjaroPercent.toFixed(2)}%`);
    console.log(`${k2Percent.toFixed(2)}%`);
    console.log(`${everestPercent.toFixed(2)}%`);
}