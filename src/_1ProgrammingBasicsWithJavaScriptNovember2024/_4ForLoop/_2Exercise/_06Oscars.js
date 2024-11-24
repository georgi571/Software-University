function oscars(input) {
    const NEED_POINTS_FOR_NOMINATION = 1250.5;

    const actorName = input[0];
    const pointFromAcademy = Number(input[1]);
    const numberOfJudges = input[2];

    let totalPoints = pointFromAcademy;

    for (let i = 3; i < input.length; i += 2) {
        const judgeName = input[i];
        const points = input[i + 1];

        const judgeLengthName = judgeName.length;

        const pointsFromJudge = (points * judgeLengthName) / 2;
        totalPoints += pointsFromJudge;

        if (totalPoints >= NEED_POINTS_FOR_NOMINATION) {
            console.log(`Congratulations, ${actorName} got a nominee for leading role with ${totalPoints.toFixed(1)}!`);
            return;
        }
    }

    const diff = NEED_POINTS_FOR_NOMINATION - totalPoints;

    console.log(`Sorry, ${actorName} you need ${diff.toFixed(1)} more!`);
}