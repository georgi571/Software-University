function bestPlayer(input) {
    let index = 0;
    let command = input[index++];
    let nameOfBestPlayer = "";
    let numberOfGoalsForBestPlayer = 0;
    let isValid = false;
    while (command !== "END") {
        const nameOfFootballPlayer = command;
        const numberOfScoreGoals = Number(input[index++]);
        if (numberOfScoreGoals > numberOfGoalsForBestPlayer) {
            nameOfBestPlayer = nameOfFootballPlayer;
            numberOfGoalsForBestPlayer = numberOfScoreGoals;
        }
        if (numberOfScoreGoals >= 10) {
            isValid = true;
            break;
        }
        command = input[index++];
    }
    console.log(`${nameOfBestPlayer} is the best player!`);
    if (numberOfGoalsForBestPlayer >= 3){
        console.log(`He has scored ${numberOfGoalsForBestPlayer} goals and made a hat-trick !!!`);
    } else {
        console.log(`He has scored ${numberOfGoalsForBestPlayer} goals.`);
    }
}

bestPlayer((["Neymar",
    "2",
    "Ronaldo",
    "1",
    "Messi",
    "3",
    "END"])
)
bestPlayer((["Silva",
    "5",
    "Harry Kane",
    "10"])
)
bestPlayer((["Petrov",
    "2",
    "Drogba",
    "11"])
)
bestPlayer((["Rooney",
    "1",
    "Junior",
    "2",
    "Paolinio",
    "2",
    "END"])
)
bestPlayer((["Zidane",
    "1",
    "Felipe",
    "2",
    "Johnson",
    "4",
    "END"])
)