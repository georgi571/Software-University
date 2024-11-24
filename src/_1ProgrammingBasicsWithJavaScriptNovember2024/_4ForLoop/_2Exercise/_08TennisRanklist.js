function tennisRankList(input) {
    const n = input[0];

    const startingPoints = Number(input[1]);

    let winningPoints = 0;
    let winTournaments = 0;

    for (let i = 2; i < input.length; i++) {
        const position = input[i];

        if (position === "W") {
            winningPoints += 2000;
            winTournaments++;
        } else if (position === "F") {
            winningPoints += 1200;
        } else if (position === "SF") {
            winningPoints += 720;
        }
    }

    const finalPoints = winningPoints + startingPoints;
    const averagePoints = Math.floor(winningPoints / n);
    const percentWinner = (winTournaments / n) * 100;

    console.log(`Final points: ${finalPoints}`);
    console.log(`Average points: ${averagePoints}`);
    console.log(`${percentWinner.toFixed(2)}%`);
}