function trainTheTrainers(input) {
    const numberOfJudge = Number(input[0]);
    let nameOfPresentation = input[1];

    let totalScoreForAllPresentations = 0.0;
    let numberOfPresentations = 0;

    let index = 2;
    while (nameOfPresentation !== "Finish") {
        let totalScore = 0.0;
        for (let i = 0; i < numberOfJudge; i++) {
            const score = Number(input[index++]);

            totalScore += score;
        }

        const averageScore = totalScore / numberOfJudge;
        totalScoreForAllPresentations += averageScore;
        numberOfPresentations++;

        console.log(`${nameOfPresentation} - ${averageScore.toFixed(2)}.`);
        nameOfPresentation = input[index++];
    }

    const averageTotalScore = totalScoreForAllPresentations / numberOfPresentations;

    console.log(`Student's final assessment is ${averageTotalScore.toFixed(2)}.`);
}